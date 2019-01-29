package org.sathish.cf.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookingServer {

	public static void main(String[] args) {
		SpringApplication.run(BookingServer.class, args);
	}
}
