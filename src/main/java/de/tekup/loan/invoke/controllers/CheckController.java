package de.tekup.loan.invoke.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.invoke.client.RestClient;
import de.tekup.loan.invoke.types.CustomerRequest;
import de.tekup.loan.invoke.types.WsResponse;



@Controller
public class CheckController {
	
	@Autowired
	private RestClient client;
	
	@GetMapping("/check/customer")
	public String customerForm(Model model) {
		CustomerRequest request = new CustomerRequest();
		model.addAttribute("request",request);
		return "request";
	}
	
	@PostMapping("/check/customer")
	public String webServiceResponse(@ModelAttribute("request") CustomerRequest request, Model model) {
		WsResponse response = client.consumeService(request);
		model.addAttribute("response",response);
		return "response";
	}

}
