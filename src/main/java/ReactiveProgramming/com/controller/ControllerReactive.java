package ReactiveProgramming.com.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
public class ControllerReactive {
	
	
	    @Autowired
	    WebClient webClient;

		@PostConstruct
		public void init() {
			webClient = WebClient.builder().baseUrl("http://localhost:8585/code")
					.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
		}
	    
	    @GetMapping("/EmployeeAll")
		public Map<Long, Object> trackAllBooking() {
			Flux<Employee> emp =  webClient.get().uri("/all").retrieve().bodyToFlux(Employee.class);
			Mono<List<Employee>> e = emp.filter(k->k.getId()>0).map(s -> s).collectList();
			Flux<Employee> flux2 = e.flatMapIterable(list -> list);
			
			
			return null;
			

}
	    
}
