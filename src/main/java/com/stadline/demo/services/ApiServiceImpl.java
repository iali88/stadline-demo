package com.stadline.demo.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.stadline.demo.entity.AuthParameter;
import com.stadline.demo.entity.HydraMemberActivity;
import com.stadline.demo.entity.HydraMemberCoach;
import com.stadline.demo.entity.HydraMemberEvent;
import com.stadline.demo.entity.HydraMemberStudio;
import com.stadline.demo.entity.ResponseApi;
import com.stadline.demo.entity.SimpleEvent;
import com.stadline.demo.entity.TraceAppel;
import com.stadline.demo.repo.TraceAppelDAO;

@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;
	
	private TraceAppelDAO traceAppelDAO;
	
	private AuthParameter authParameter;
		
	private final String pathActivities = "/activities";
	
	private final String pathStudios = "/studios"; 
	
	private final String pathCoaches = "/coaches";
	
	private final String pathEvents = "/events";
	
	public ApiServiceImpl(RestTemplate restTemplate, TraceAppelDAO traceAppelDao, AuthParameter authParameter) {
		this.restTemplate = restTemplate;
		this.traceAppelDAO = traceAppelDao;
		this.authParameter = authParameter;
	}
	
	@Override
	public List<HydraMemberActivity> getActivities() {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(authParameter.getApi_url()).path("/" + authParameter.getClient_token() + pathActivities);	
		ResponseApi<HydraMemberActivity> responseApi = callApiForMultipleEntity(uriBuilder.toUriString(), new ParameterizedTypeReference<ResponseApi<HydraMemberActivity>>() {});
		
		return responseApi.getHydraMember();
	}

	
	

	@Override
	public List<HydraMemberStudio> getStudios() {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(authParameter.getApi_url()).path("/" + authParameter.getClient_token() + pathStudios);
		ResponseApi<HydraMemberStudio> responseApi = callApiForMultipleEntity(uriBuilder.toUriString(), new ParameterizedTypeReference<ResponseApi<HydraMemberStudio>>() {});
		
		return responseApi.getHydraMember();

	}
	
	@Override
	public List<HydraMemberCoach> getCoaches() {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(authParameter.getApi_url()).path("/" + authParameter.getClient_token() + pathCoaches);
		ResponseApi<HydraMemberCoach> responseApi = callApiForMultipleEntity(uriBuilder.toUriString(), new ParameterizedTypeReference<ResponseApi<HydraMemberCoach>>() {});
		
		return responseApi.getHydraMember();

	}
	

	@Override
	public List<HydraMemberEvent> getListEventsbyPeriod(String dateStart, String dateEnd, String calendrier, String id) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(authParameter.getApi_url())
				.path("/" + authParameter.getClient_token() + pathEvents)
				.queryParam("startedAt", dateStart)
				.queryParam("endedAt", dateEnd);
		
		String calendarParam = "&calendars[]=" + "/"+ authParameter.getClient_token() + "/" + calendrier + "/" + id ;
		String uriFinal = uriBuilder.toUriString() + calendarParam;
		
		ResponseApi<HydraMemberEvent> responseApi = callApiForMultipleEntity(uriFinal, new ParameterizedTypeReference<ResponseApi<HydraMemberEvent>>() {});
		
		return responseApi.getHydraMember();

	}
	
	@Override
	public List<SimpleEvent> getSimpleEventsListByPeriod(String dateStart, String dateEnd, String calendrier, String id) {
		

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(authParameter.getApi_url())
				.path("/" + authParameter.getClient_token() + pathEvents)
				.queryParam("startedAt", dateStart)
				.queryParam("endedAt", dateEnd);
		
		String calendarParam = "&calendars[]=" + "/"+ authParameter.getClient_token() + "/" + calendrier + "/" + id ;
		String uriFinal = uriBuilder.toUriString() + calendarParam;
		
		ResponseApi<HydraMemberEvent> responseApi = callApiForMultipleEntity(uriFinal, new ParameterizedTypeReference<ResponseApi<HydraMemberEvent>>() {});	
		
		List<HydraMemberEvent> events = responseApi.getHydraMember();
		
		// Transformation de chaque event en event simple 
		return events.stream().map(event -> {
					
					HydraMemberActivity hydraActivity = getActivityById(event.getActivity().split("/")[3]);
					HydraMemberStudio hydraStudio = getStudioById(event.getStudio().split("/")[3]);
					Duration duration = Duration.between(event.getStartedAtDate(),event.getEndedAtDate());
					int nbPlaces = event.getAttendingLimit() - event.getBookedAttendees().size();
					
					return new SimpleEvent(  event.getStartedAt().toString().substring(0, 10),
											 event.getStartedAt().toString().substring(11, 19), 
											 Math.abs(duration.toMinutes()),
											 hydraStudio.getName().toString(),
											 hydraActivity.getName().toString(),
											 nbPlaces);
				}).collect(Collectors.toList());

	}
	
	
	@Override
	public HydraMemberActivity getActivityById(String id) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(authParameter.getApi_url()).path("/" + authParameter.getClient_token() + pathActivities + "/" + id);	
		HydraMemberActivity hydraMemberActivity = callApiForUniqueEntity(uriBuilder.toUriString(), HydraMemberActivity.class);
		
		return hydraMemberActivity;
	
	}
	
	@Override
	public HydraMemberStudio getStudioById(String id) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(authParameter.getApi_url()).path("/" + authParameter.getClient_token() + pathStudios + "/" + id);	
		HydraMemberStudio hydraMemberStudio = callApiForUniqueEntity(uriBuilder.toUriString(), HydraMemberStudio.class);
		
		return hydraMemberStudio;
		
	}
	
	@Override
	public HydraMemberCoach getCoachById(String id) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(authParameter.getApi_url()).path("/" + authParameter.getClient_token() + pathCoaches + "/" + id);	
		
		HydraMemberCoach hydraMemberCoach = callApiForUniqueEntity(uriBuilder.toUriString(), HydraMemberCoach.class);
		
		return hydraMemberCoach;
		
	}
	
	private <T> T callApiForUniqueEntity(String path, Class<T> classType) {
		
		StackTraceElement[] stackTrace = new Throwable().getStackTrace();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authParameter.getToken());
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<T> activityResponse = (ResponseEntity<T>) restTemplate.exchange(path, HttpMethod.GET, entity, classType);
				
		traceAppelDAO.save(new TraceAppel(path, stackTrace[1].getMethodName(), LocalDateTime.now()));
		
		return activityResponse.getBody();
	}
	
	
	private <T> ResponseApi<T> callApiForMultipleEntity(String path, ParameterizedTypeReference<ResponseApi<T>> parameterizedTypeReference) {
		
		StackTraceElement[] stackTrace = new Throwable().getStackTrace();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + authParameter.getToken());
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<ResponseApi<T>> activityResponse = restTemplate.exchange(path, HttpMethod.GET, entity, parameterizedTypeReference );
		ResponseApi<T> responseApi = activityResponse.getBody();
		
		traceAppelDAO.save(new TraceAppel(path, stackTrace[1].getMethodName(), LocalDateTime.now()));
		
		return responseApi;
	}
	

}
