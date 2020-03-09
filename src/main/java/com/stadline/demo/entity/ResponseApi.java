package com.stadline.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseApi<T> {

	@JsonProperty("@context")
    private String context;
	
	@JsonProperty("@id")
    private String id;
	
	@JsonProperty("@type")
	private String type;
    
	@JsonProperty("hydra:member")
	private List<T> hydraMember = null;
	
	@JsonProperty("hydra:totalItems")
    private Integer hydraTotalItems;
	
	@JsonProperty("hydra:search")
    private HydraSearch hydraSearch;

    public ResponseApi() {
    	
    }
    
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<T> getHydraMember() {
        return hydraMember;
    }

    public void setHydraMember(List<T> hydraMember) {
        this.hydraMember = hydraMember;
    }

    public Integer getHydraTotalItems() {
        return hydraTotalItems;
    }

    public void setHydraTotalItems(Integer hydraTotalItems) {
        this.hydraTotalItems = hydraTotalItems;
    }

    public HydraSearch getHydraSearch() {
        return hydraSearch;
    }

    public void setHydraSearch(HydraSearch hydraSearch) {
        this.hydraSearch = hydraSearch;
    }
	
}
