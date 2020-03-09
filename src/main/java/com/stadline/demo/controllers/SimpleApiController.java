package com.stadline.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stadline.demo.entity.HydraMemberActivity;
import com.stadline.demo.entity.HydraMemberCoach;
import com.stadline.demo.entity.HydraMemberEvent;
import com.stadline.demo.entity.HydraMemberStudio;
import com.stadline.demo.entity.SimpleEvent;
import com.stadline.demo.services.ApiService;

@RestController
@RequestMapping("/api")
public class SimpleApiController {
	
	private ApiService apiService; 
	
	@Autowired
	public SimpleApiController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@GetMapping("/activities")
	public List<HydraMemberActivity> getActivities() {
		
		List<HydraMemberActivity> activities = apiService.getActivities();
		
		return activities; 
	}
	
	@GetMapping("/studios")
	public List<HydraMemberStudio> getStudios() {
		
		List<HydraMemberStudio> studios = apiService.getStudios();
		
		return studios; 
	}
	
	@GetMapping("/coaches")
	public List<HydraMemberCoach> getCoaches() {
		
		List<HydraMemberCoach> studios = apiService.getCoaches();
		
		return studios; 
	}
	
	@GetMapping("/events/full/{dateStart}/{dateEnd}/{calendrier}/{id}")
	public List<HydraMemberEvent> getListEventsByPeriod(@PathVariable String dateStart, @PathVariable String dateEnd, @PathVariable String calendrier, @PathVariable String id) {
		
		List<HydraMemberEvent> events = apiService.getListEventsbyPeriod(dateStart, dateEnd, calendrier, id);
	
		return events;
	}
	
	
	@GetMapping("/events/{dateStart}/{dateEnd}/{calendrier}/{id}")
	public List<SimpleEvent> getListSimpleEventsByPeriod(@PathVariable String dateStart, @PathVariable String dateEnd, @PathVariable String calendrier, @PathVariable String id) {
		
		List<SimpleEvent> events = apiService.getSimpleEventsListByPeriod(dateStart, dateEnd, calendrier, id);
	
		return events;
	}
	
	@GetMapping("/activity/{id}")
	public HydraMemberActivity getActivity(@PathVariable String id) {
		
		HydraMemberActivity activity = apiService.getActivityById(id);
		
		return activity; 
	}
	
	@GetMapping("/studio/{id}")
	public HydraMemberStudio getStudio(@PathVariable String id) {
		
		HydraMemberStudio studio = apiService.getStudioById(id);
		
		return studio; 
	}
	
	@GetMapping("/coach/{id}")
	public HydraMemberCoach getCoach(@PathVariable String id) {
		
		HydraMemberCoach coach = apiService.getCoachById(id);
		
		return coach; 
	}
	
}
