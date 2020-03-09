
package com.stadline.demo.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HydraSearch {

	@JsonProperty("@type")
    private String type;
	
	@JsonProperty("@hydra:template")
    private String hydraTemplate;
	
	@JsonProperty("@hydra:variableRepresentation")
    private String hydraVariableRepresentation;
    
	@JsonProperty("@hydra:mapping")
	private List<HydraMapping> hydraMapping = null;
    
	
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public HydraSearch() {
    	
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHydraTemplate() {
        return hydraTemplate;
    }

    public void setHydraTemplate(String hydraTemplate) {
        this.hydraTemplate = hydraTemplate;
    }

    public String getHydraVariableRepresentation() {
        return hydraVariableRepresentation;
    }

    public void setHydraVariableRepresentation(String hydraVariableRepresentation) {
        this.hydraVariableRepresentation = hydraVariableRepresentation;
    }

    public List<HydraMapping> getHydraMapping() {
        return hydraMapping;
    }

    public void setHydraMapping(List<HydraMapping> hydraMapping) {
        this.hydraMapping = hydraMapping;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
