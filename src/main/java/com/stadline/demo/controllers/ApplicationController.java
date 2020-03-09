package com.stadline.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stadline.demo.entity.HydraMemberActivity;
import com.stadline.demo.entity.HydraMemberStudio;
import com.stadline.demo.entity.SimpleEvent;
import com.stadline.demo.services.ApiService;

@Controller
@RequestMapping("/appli")
public class ApplicationController {

	private ApiService apiService; 
	
	public ApplicationController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@GetMapping({"", "/", "/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/events/byAct")
	public String afficherFormSearchByActivity(Model model) {
		
		List<HydraMemberActivity> liste = apiService.getActivities();
		
		Map<Integer, String> mapActivity = liste.stream().collect(
				Collectors.toMap(e -> Integer.parseInt(e.getId().split("/")[3])  , e -> (String) e.getName()));
				
		model.addAttribute("mapActivity", mapActivity);
		model.addAttribute("isStudio", false);

		return "searchForm";
	}
	
	@PostMapping("/events/byAct")
	public String searchByActivityFormPost(@RequestParam("typeRecherche") String typeRecherche, @RequestParam("dateDeb") String dateDeb, @RequestParam("dateFin") String dateFin, Model model) {
		
		List<SimpleEvent> events = apiService.getSimpleEventsListByPeriod(dateDeb, dateFin, "activities", typeRecherche);
		model.addAttribute("events", events);
		
		return "events"; 
	}
	
	@GetMapping("/events/byStu")
	public String afficherFormSearchByStudio(Model model) {
		
		List<HydraMemberStudio> liste = apiService.getStudios();
		
		Map<Integer, String> mapActivity = liste.stream().collect(
				Collectors.toMap(e -> Integer.parseInt(e.getId().split("/")[3])  , e -> (String) e.getName()));
				
		model.addAttribute("mapActivity", mapActivity);
		model.addAttribute("isStudio", true);


		return "searchForm";
	}
	
	@PostMapping("/events/byStu")
	public String searchByStudioFormPost(@RequestParam("typeRecherche") String typeRecherche, @RequestParam("dateDeb") String dateDeb, @RequestParam("dateFin") String dateFin, Model model) {
		
		List<SimpleEvent> events = apiService.getSimpleEventsListByPeriod(dateDeb, dateFin, "studios", typeRecherche);				
		model.addAttribute("events", events);
		
		return "events"; 
	}
	
}
