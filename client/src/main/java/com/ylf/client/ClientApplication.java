package com.ylf.client;
import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


//@EnableEurekaClient
@SpringBootApplication
@RestController
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
    @Value("${server.port}")
	String port;
	@RequestMapping("/hi/{id}")
	public String hi(@PathVariable("id")String id){
		return "hi "+id+" i am "+port;
	}

	private static final Logger LOG = LoggerFactory.getLogger(ClientApplication.class);
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hii")
	public String callHome(){
		LOG.info("calling trace service-miya");
		return restTemplate.getForObject("http://localhost:8999/info", String.class);
	}
	@RequestMapping("/info")
	public String info(){
		return "i'm service-hi";

	}

	@RequestMapping("/json")
	public String json(@RequestBody String info){
       return info;
	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}


