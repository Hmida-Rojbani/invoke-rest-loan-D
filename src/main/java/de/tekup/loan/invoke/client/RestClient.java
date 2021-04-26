package de.tekup.loan.invoke.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.tekup.loan.invoke.types.CustomerRequest;
import de.tekup.loan.invoke.types.WsResponse;
@Service
public class RestClient {
	
	private RestTemplate template = new RestTemplate();
	private static final String URL = "http://localhost:8080/api/get-status";
	
	public WsResponse consumeService(CustomerRequest request) {
		// consuming the rest web service
		WsResponse response = template.postForObject(URL, request, WsResponse.class);
		return response;
	}
	

}
