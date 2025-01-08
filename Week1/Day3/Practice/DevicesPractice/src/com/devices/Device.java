package com.devices;

public class Device {
	//attributes
	private int battery=100;
	// constructor 
	public Device () {}
	
	// Getter and Setter For the Battery
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}

	public void batterylife() {
		System.out.println(this.getBattery());
	}
	
	
}
