package com.tracking.report.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DEVICE_DATA")
public class DeviceData {

	@Override
	public String toString() {
		return "DeviceData [eventId=" + eventId + ", dateTime=" + dateTime + ", productId=" + productId + ", latitude="
				+ latitude + ", longitude=" + longitude + ", Battery=" + Battery + ", light=" + light
				+ ", airplaneMode=" + airplaneMode + "]";
	}
	@Id
	Long eventId;
	
	@NonNull	
	Timestamp dateTime;
	@NonNull
	String productId;
	
	Double latitude;
	
	Double longitude;
	@NonNull
	float Battery;
	@NonNull
	String light;
	@NonNull
	String airplaneMode;
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long data) {
		this.eventId = data;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp data) {
		this.dateTime = data;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public float getBattery() {
		return Battery;
	}
	public void setBattery(float battery) {
		Battery = battery;
	}
	public String getLight() {
		return light;
	}
	public void setLight(String light) {
		this.light = light;
	}
	public String getAirplaneMode() {
		return airplaneMode;
	}
	public void setAirplaneMode(String airplaneMode) {
		this.airplaneMode = airplaneMode;
	}

}
