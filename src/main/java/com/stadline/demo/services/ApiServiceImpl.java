package com.stadline.demo.services;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stadline.demo.entity.HydraMemberActivity;
import com.stadline.demo.entity.HydraMemberCoach;
import com.stadline.demo.entity.HydraMemberEvent;
import com.stadline.demo.entity.HydraMemberStudio;
import com.stadline.demo.entity.ResponseApi;
import com.stadline.demo.entity.SimpleEvent;

@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;
	
	@Value("${api.url}")
	private final String api_url;
	
	@Value("${client.id}")
	private final String client_id; 
	
	@Value("${client.secret}")
	private final String client_secret; 
	
	@Value("${authentification.type}")
	private final String authentification_type; 
	
	@Value("${client.token}")
	private final String client_token;
	
	private String token = null; 
	
	public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url, @Value("${client.id}") String client_id, @Value("${client.secret}") String client_secret, @Value("${authentification.type}") String authentification_type, @Value("${client.token}") String client_token) {
		this.api_url = api_url;
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.authentification_type = authentification_type;
		this.client_token = client_token;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public List<HydraMemberActivity> getActivities() {
		
		if(token == null) {
			token = getToken();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
				.path("/" + client_token + "/activities");		
		
		ResponseEntity<ResponseApi<HydraMemberActivity>> activityResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<ResponseApi<HydraMemberActivity>>() {});
		ResponseApi<HydraMemberActivity> responseApi = activityResponse.getBody();
		
		return responseApi.getHydraMember();
	}

	
	@Override
	public List<HydraMemberStudio> getStudios() {
		
		if(token == null) {
			token = getToken();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
				.path("/" + client_token + "/studios");		
		
		ResponseEntity<ResponseApi<HydraMemberStudio>> activityResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<ResponseApi<HydraMemberStudio>>() {});
		ResponseApi<HydraMemberStudio> responseApi = activityResponse.getBody();
		
		return responseApi.getHydraMember();

	}
	
	@Override
	public List<HydraMemberCoach> getCoaches() {
		
		// récupération du token 
		if(token == null) {
			token = getToken();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
				.path("/" + client_token + "/coaches");		
		
		ResponseEntity<ResponseApi<HydraMemberCoach>> activityResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, new ParameterizedTypeReference<ResponseApi<HydraMemberCoach>>() {});
		ResponseApi<HydraMemberCoach> responseApi = activityResponse.getBody();
		
		return responseApi.getHydraMember();

	}
	

	@Override
	public List<HydraMemberEvent> getListEventsbyPeriod(String dateStart, String dateEnd, String calendrier, String id) {
		
		if(token == null) {
			token = getToken();
		}
		
		String calendarParam = "&calendars[]=" + "/"+ client_token + "/" + calendrier + "/" + id ;
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
				.path("/" + client_token + "/events")
				.queryParam("startedAt", dateStart)
				.queryParam("endedAt", dateEnd);
		
		String uriFinal = uriBuilder.toUriString() + calendarParam;
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<ResponseApi<HydraMemberEvent>> activityResponse = restTemplate.exchange(uriFinal, HttpMethod.GET, entity, new ParameterizedTypeReference<ResponseApi<HydraMemberEvent>>() {});
		
		ResponseApi<HydraMemberEvent> responseApi = activityResponse.getBody();
		
		return responseApi.getHydraMember();

	}
	
	@Override
	public List<SimpleEvent> getSimpleEventsListByPeriod(String dateStart, String dateEnd, String calendrier, String id) {
		
		if(token == null) {
			token = getToken();
		}
		
		String calendarParam = "&calendars[]=" + "/"+ client_token + "/" + calendrier + "/" + id ;
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
				.path("/" + client_token + "/events")
				.queryParam("startedAt", dateStart)
				.queryParam("endedAt", dateEnd);
		
		String uriFinal = uriBuilder.toUriString() + calendarParam;
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<ResponseApi<HydraMemberEvent>> activityResponse = restTemplate.exchange(uriFinal, HttpMethod.GET, entity, new ParameterizedTypeReference<ResponseApi<HydraMemberEvent>>() {});
		
		ResponseApi<HydraMemberEvent> responseApi = activityResponse.getBody();
		
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
		
		if(token == null) {
			token = getToken();
		}
				
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
				.path("/" + client_token + "/activities/" + id);
				
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<HydraMemberActivity> activityResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, HydraMemberActivity.class);
		
		HydraMemberActivity hydraMemberActivity = activityResponse.getBody();
		
		return hydraMemberActivity;
	
	}
	
	@Override
	public HydraMemberStudio getStudioById(String id) {
		
		if(token == null) {
			token = getToken();
		}
				
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
				.path("/" + client_token + "/studios/" + id);
				
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<HydraMemberStudio> activityResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, HydraMemberStudio.class);
		
		HydraMemberStudio hydraMemberStudio = activityResponse.getBody();
		
		return hydraMemberStudio;
		
	}
	
	@Override
	public HydraMemberCoach getCoachById(String id) {

		if(token == null) {
			token = getToken();
		}
				
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
				.path("/" + client_token + "/coaches/" + id);
				
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<HydraMemberCoach> activityResponse = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, HydraMemberCoach.class);
		
		HydraMemberCoach hydraMemberCoach = activityResponse.getBody();
		
		return hydraMemberCoach;
		
	}
	
	
	private String getToken() {
		
		String token = null;
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
				.path("/" + client_token + "/oauth/v2/token")
				.queryParam("client_id", client_id)
				.queryParam("client_secret", client_secret)
				.queryParam("grant_type", authentification_type);

		ResponseEntity<String> response = null;
				
		response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, HttpEntity.EMPTY, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node;

		try {
			
			node = mapper.readTree(response.getBody());
			token = node.path("access_token").asText();
		
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return token;
	}

}
