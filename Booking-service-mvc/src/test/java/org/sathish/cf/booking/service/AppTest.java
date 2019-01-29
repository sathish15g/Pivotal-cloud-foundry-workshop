package org.sathish.cf.booking.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sathish.cf.booking.Booking;
import org.sathish.cf.booking.WebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import static com.github.tomakehurst.wiremock.client.WireMock.*; 

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

	@Autowired
	WebController controller;

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8081);

	@Test
	public void test() {

		wireMockRule.stubFor(post(urlPathEqualTo("/add"))
                .willReturn(aResponse().withStatus(201)));

		Booking booking = new Booking();

		booking.setCode("123");

		controller.addBooking(booking);

	}

}
