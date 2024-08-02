package com.weather.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.dto.DaysDTO;
import com.weather.dto.HourDTO;
import com.weather.dto.WeatherDTO;
import com.weather.service.ExternalApi;


@RestController
public class WeatherAPI {

	@Autowired
	ExternalApi ext;
	
	@GetMapping("/weather")
	public ResponseEntity<WeatherDTO> getWeather(@RequestParam String city)
	{
		System.out.println("Hello");
		return ext.fetchWeather(city);
	}
	
	@GetMapping("/weather/day")
	public DaysDTO getDays(@RequestParam String city,@RequestParam String day)
	{
		
		return ext.getParticularDayWeather(city,day);
	}
	
	@GetMapping("/weather/day/hour")
	public HourDTO getHourWeather(@RequestParam String city,@RequestParam String day,@RequestParam String hour)
	{
		hour = hour.substring(0,2)+":00:00";// if the given hour is in hours:minutes:seconds like 12:23:23 etc.
		return ext.getParticularHourWeather(city, day, hour);
	}
}
