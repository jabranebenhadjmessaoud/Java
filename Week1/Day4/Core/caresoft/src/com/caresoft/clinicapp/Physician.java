package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an IDcopy
	public Physician(ArrayList<String> patientNotes,Integer id,int pin) {
		super(id,pin);
		this.patientNotes = patientNotes;
	}
    // TO DO: Implement HIPAACompliantUser!
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		 if (pin>999 && pin<10000) {
			 return true ;
		 }
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (this.id == confirmedAuthID) {
			return true ;
		}
		return false;
	}
	
    // TO DO: Setters & Getters
}
