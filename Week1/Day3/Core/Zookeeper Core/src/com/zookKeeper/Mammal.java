package com.zookKeeper;

public class Mammal {
	// attributes

	protected int energy=100;
	
	// constructor
	public Mammal () {}
	
	// Getters and Setters 

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	// methods
	public void dispalyEnergy(){
		System.out.println(this.getEnergy());
		
	}
	
	
	
}
