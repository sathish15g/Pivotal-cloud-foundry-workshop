package org.sathish.cf.booking;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

	@Autowired
    private BookingRepository repository;

	private static final Log logger = LogFactory.getLog(BookingController.class);
	
	@RequestMapping("/list")
    public List<Booking> getBooking(){
		
	logger.info("Get Bookings");
		
        return repository.findAll();
    }

   	@RequestMapping(method = RequestMethod.POST, path="/add")
    public ResponseEntity<String> addBooking(@RequestBody Booking booking){
    	
		
	logger.info("Add booking:" + booking.getCode());
		
        repository.save(booking);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
