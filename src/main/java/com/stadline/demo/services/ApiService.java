package com.stadline.demo.services;

import java.util.List;

import com.stadline.demo.entity.HydraMemberActivity;
import com.stadline.demo.entity.HydraMemberCoach;
import com.stadline.demo.entity.HydraMemberEvent;
import com.stadline.demo.entity.HydraMemberStudio;
import com.stadline.demo.entity.SimpleEvent;

public interface ApiService {

	List<HydraMemberActivity> getActivities();

	List<HydraMemberStudio> getStudios();
	
	List<HydraMemberCoach> getCoaches();
	
	List<HydraMemberEvent> getListEventsbyPeriod(String dateStart, String dateEnd, String calendrier, String id);
	
	List<SimpleEvent> getSimpleEventsListByPeriod(String dateStart, String dateEnd, String calendrier, String id); 
	
	HydraMemberActivity getActivityById(String id);
	
	HydraMemberStudio getStudioById(String id);

	HydraMemberCoach getCoachById(String id);

	

}
