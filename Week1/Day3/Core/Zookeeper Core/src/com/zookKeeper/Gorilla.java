package com.zookKeeper;

public class Gorilla  extends Mammal{

	// attributes 
	
	// Constructor 
	public Gorilla() {}
	// Methods
	public void throwSomething() {
		this.setEnergy(this.getEnergy()-5);
		System.out.println("Gorilla Has Thrown Something");
		}
		public void eatBananas() {
			this.setEnergy(this.getEnergy()+10);
			System.out.println("Gorilla ate a Banana and Satisfied");
		}	
		public void climb() {
			this.setEnergy(this.getEnergy()-10);
			System.out.println("Gorilla has climbed a tree");
		}
		
	
}
