package com.weather.dto;

import java.util.List;

public class WeatherDTO {

	String address;
	double latitude;
	double longitude;
	String description;
	List<DaysDTO> days;
	
	
	public String getAddress() {
		return address;
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public String getDescription() {
		return description;
	}
	public List<DaysDTO> getDays() {
		return days;
	}
	
	public DaysDTO getParticularDay(String day)
	{
		DaysDTO particularDay = null;
		for(DaysDTO d: days)
		{
			
			if(d.datetime.equals(day))
			{
				particularDay = d;
				break;
			}
		}
		return particularDay;
	}
	
	
	
	
}
