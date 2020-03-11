package com.stadline.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.stadline.demo.entity.AuthParameter;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public AuthParameter authParameter(@Value("${api.url}") String api_url, @Value("${client.id}") String client_id,
			@Value("${client.secret}") String client_secret,
			@Value("${authentification.type}") String authentification_type,
			@Value("${client.token}") String client_token) {

		return new AuthParameter(api_url, client_id, client_secret, authentification_type, client_token);
	}
}
