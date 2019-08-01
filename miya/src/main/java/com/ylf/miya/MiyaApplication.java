package com.ylf.miya;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class MiyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiyaApplication.class, args);
	}

	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	@ResponseBody
	public String hi(@RequestParam("name") String name){
		return "hi "+name+" i am "+port;
	}

	private static final Logger LOG = LoggerFactory.getLogger(MiyaApplication.class);
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hii")
	public String callHome(){
		LOG.info("calling trace service-hi  ");
		return restTemplate.getForObject("http://localhost:8762/info", String.class);
	}
	@RequestMapping("/info")
	public String info(){
		return "i'm service-miya";

	}
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
