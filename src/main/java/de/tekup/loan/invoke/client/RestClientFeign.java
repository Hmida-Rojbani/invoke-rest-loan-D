package de.tekup.loan.invoke.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import de.tekup.loan.invoke.types.CustomerRequest;
import de.tekup.loan.invoke.types.WsResponse;

@FeignClient(url = "localhost:8080", value = "localhost:8080")
public interface RestClientFeign {
	
	@PostMapping(path = "/api/get-status")
	public WsResponse consumeService(@RequestBody CustomerRequest request);

}
