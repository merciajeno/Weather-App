package com.weather.dto;

import java.util.List;

public class DaysDTO {
 
	String datetime;
	double tempmax;
	double tempmin;
	List<HourDTO> hours;
	
	public String getDatetime() {
		return datetime;
	}
	public double getTempmax() {
		return tempmax;
	}
	public double getTempmin() {
		return tempmin;
	}
	public List<HourDTO> getHours() {
		return hours;
	}
	public HourDTO getHour(String hour)
	{
		HourDTO hourDto = null;
		for(HourDTO h:hours)
		{
			if(h.datetime.equals(hour))
			{
				hourDto = h;
				break;
			}
		}
		return hourDto;
	}
	
	
}
