package org.sathish.cf.booking;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Controller
public class WebController {

	private static final Log logger = LogFactory.getLog(WebController.class);
	
	@Autowired
	private DaoClient client;

	@RequestMapping("/")
	public ModelAndView welcome(Model model) {
		logger.info("Start Request for welcome v1.6");
		model.addAttribute("booking", new Booking());

		return new ModelAndView("home");
	}
	
	@RequestMapping("/bookings")
	@HystrixCommand(fallbackMethod="noBookingAvailable")
	public ModelAndView getBooking() {
		
		logger.info("Start Request for Bookings");
		
		List<Booking> books = client.getBooking();	
		
		logger.info("Getting bookings:" + books.size());
		
		ModelAndView model = new ModelAndView("list");
		model.addObject("bookings", books);
		return model;
				
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	@HystrixCommand(fallbackMethod="noBookingAvailable")
	public ModelAndView addBooking(@ModelAttribute Booking booking) {
		
		logger.info("Add booking:" + booking.getCode());
		
		ResponseEntity<?> response = client.addBooking(booking);
		
		logger.info("Response:" + response.getStatusCodeValue());
				
		return new ModelAndView("redirect:/");
				
	}	
	public ModelAndView noBookingAvailable() {

		logger.info("Invoked Circuit Breaker");

		return new ModelAndView("circuitbreaker");
	}
	
	public ModelAndView noBookingAvailable(@ModelAttribute Booking booking) {

		return noBookingAvailable();
	}
}
