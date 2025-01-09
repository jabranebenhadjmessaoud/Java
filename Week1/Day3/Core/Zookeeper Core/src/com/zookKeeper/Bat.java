package com.zookKeeper;

public class Bat extends Mammal {

	// attributes 
	
	// Constructor 
		public Bat() {
		this.energy=300;
		}
		
	// Methods
		public void fly() {
			this.setEnergy(this.getEnergy()-50);
			System.out.println("The Bat is Airborne");
			}
			public void eatHumans() {
				this.setEnergy(this.getEnergy()+25);
				System.out.println("Bat ate a Human and Satisfied");
			}	
			public void attackTown() {
				this.setEnergy(this.getEnergy()-100);
				System.out.println("Bat Attacked a Town");
			}
	
}
