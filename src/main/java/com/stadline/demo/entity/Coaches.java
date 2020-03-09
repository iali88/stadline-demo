
package com.stadline.demo.entity;

import java.util.HashMap;
import java.util.Map;

public class Coaches {

    private String key;
    private Integer docCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Coaches() {
    	
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getDocCount() {
        return docCount;
    }

    public void setDocCount(Integer docCount) {
        this.docCount = docCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
