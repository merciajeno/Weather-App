package com.weather.dto;

public class HourDTO {

	String datetime;
    double temp;
	double humidity;
	double precip;
	double solarenergy;
	String conditions;
	String icon;
	String[] stations;
	public String getDatetime() {
		return datetime;
	}
	public double getTemp() {
		return temp;
	}
	public double getHumidity() {
		return humidity;
	}
	public double getPrecip() {
		return precip;
	}
	public double getSolarenergy() {
		return solarenergy;
	}
	public String getConditions() {
		return conditions;
	}
	public String getIcon() {
		return icon;
	}
	public String[] getStations() {
		return stations;
	}
	
	
}
