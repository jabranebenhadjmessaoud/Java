package com.devices;

public class Phone extends Device{

	//constructor
public Phone () {}
	//Methods
public void makeCall () {
	System.out.println("Making a Call ");
	this.setBattery(getBattery()-5);
	System.out.println(this.getBattery());
	if (this.getBattery()<10) {
		System.out.println("Battery too low. its less than 10% !!!");
	}
}

public void playGame () {
	if (this.getBattery()>25) {
		System.out.println("Playing a Game ");
		this.setBattery(getBattery()-20);
		System.out.println(this.getBattery());
	}
	else {
		System.out.println("Battery Below 25%, You Can't Play until you charge it ");
	}
}
public void charge () {
	System.out.println("Charging the Phone");
	this.setBattery(getBattery()+50);
	if(this.getBattery()>100) {
		this.setBattery(100);
	}
	System.out.println(this.getBattery());
}
	
	
}
