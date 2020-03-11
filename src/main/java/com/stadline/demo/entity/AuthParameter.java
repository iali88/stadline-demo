package com.stadline.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthParameter {

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

	@Autowired
	private RestTemplate restTemplate;
	
	public AuthParameter(RestTemplate restTemplate, @Value("${api.url}") String api_url, @Value("${client.id}") String client_id, @Value("${client.secret}") String client_secret, @Value("${authentification.type}") String authentification_type, @Value("${client.token}") String client_token) {
		this.api_url = api_url;
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.authentification_type = authentification_type;
		this.client_token = client_token;
		this.restTemplate = restTemplate;
	}
	
	
	public AuthParameter(@Value("${api.url}") String api_url, @Value("${client.id}") String client_id, @Value("${client.secret}") String client_secret, @Value("${authentification.type}") String authentification_type, @Value("${client.token}") String client_token) {
		this.api_url = api_url;
		this.client_id = client_id;
		this.client_secret = client_secret;
		this.authentification_type = authentification_type;
		this.client_token = client_token;
	}
		

	public void getTokenFromApi() {

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

		this.token = token;
		
	}

	public String getApi_url() {
		return api_url;
	}

	public String getClient_id() {
		return client_id;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public String getAuthentification_type() {
		return authentification_type;
	}

	public String getClient_token() {
		return client_token;
	}

	public String getToken() {
		return token;
	}
	
	

}
