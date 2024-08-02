package com.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.dto.DaysDTO;
import com.weather.dto.HourDTO;
import com.weather.dto.WeatherDTO;

@Service
public class ExternalApi {
	
	RestTemplate restTemp = new RestTemplate();
	
	@Value("${API_KEY}")
	String key;
    ExternalApi()
    {
    	
    }
	
	public ResponseEntity<WeatherDTO> fetchWeather(String city)
	{
		StringBuffer url = new StringBuffer("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/");
		url.append(city);
		url.append("?unitGroup=metric");
		url.append("&key=5BTPHNSNE7GPQUUUA9VTRXB3Y&contentType=json");
		String strUrl = url.toString();
	    
		ResponseEntity<WeatherDTO> entity = restTemp.getForEntity(strUrl,WeatherDTO.class);
		
		return entity;
	}
	
	public DaysDTO getParticularDayWeather(String city,String day)
	{
		StringBuffer url = new StringBuffer("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/");
		url.append(city);
		url.append("?unitGroup=metric");
		url.append("&include=hours");
		url.append("&key=5BTPHNSNE7GPQUUUA9VTRXB3Y&contentType=json");
		String strUrl = url.toString();
		WeatherDTO weather = restTemp.getForObject(strUrl, WeatherDTO.class);
		return weather.getParticularDay(day);
		
	}
	
	public HourDTO getParticularHourWeather(String city, String day,String hour)
	{
		DaysDTO particularDay = getParticularDayWeather(city, day);
		HourDTO particularHour = particularDay.getHour(hour);
		return particularHour;
	}
	
	
	

}
