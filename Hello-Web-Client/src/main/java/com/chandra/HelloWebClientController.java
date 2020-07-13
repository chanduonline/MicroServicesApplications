package com.chandra;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HelloWebClientController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@GetMapping("/")
	public String handleRequest(Model model)
	{
		
		List<ServiceInstance> instance = discoveryClient.getInstances("hello-service");
		if(instance!=null && instance.size()>0)
		{
			ServiceInstance serviceInstance = instance.get(0);
			String url = serviceInstance.getUri().toString();
		
			url = url+"/hello";
			
			RestTemplate restTemplate = new RestTemplate();
			HelloObject hello = restTemplate.getForObject(url,HelloObject.class);
			model.addAttribute("msg",hello.getMessage());
			model.addAttribute("Time", LocalDateTime.now());
			
		}
		return "hello-page";
	}

}
