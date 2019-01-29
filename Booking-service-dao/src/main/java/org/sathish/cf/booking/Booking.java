package org.sathish.cf.booking;

import java.io.Serializable;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Booking implements Serializable{

	@Id
	@JsonProperty("code")
	protected String code;
	@JsonProperty("flightNumber")
	protected String flightNumber;
	@JsonProperty("name")
	protected String name;
	@JsonProperty("surname")
	protected String surname;
	@JsonProperty("seat")
	protected String seat; 
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	@Override
    public String toString() {
		return "{\"code\":\"" + code + "\"}" +
				"{\"flightNumber\":\"" + flightNumber + "\"}" +
				"{\"name\":\"" + name + "\"}" +
				"{\"surname\":\"" + surname + "\"}" +
				"{\"seat\":\"" + seat + "\"}";

    }

}
