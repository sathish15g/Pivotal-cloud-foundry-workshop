package org.sathish.cf.booking;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="sathish-booking-service-dao")
public interface DaoClient {
	
	  @RequestMapping(method = RequestMethod.GET, value = "/list")
	  List<Booking> getBooking();
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/add")
	  ResponseEntity<String> addBooking(Booking booking);
}