package com.burgertrackerone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burgertrackerone.models.Burger;
import com.burgertrackerone.repositories.BurgerRepository;


@Service
public class BurgerService {

	@Autowired
	BurgerRepository burgerRepo;
	
	public List<Burger> getAllBurgers(){
		return burgerRepo.findAll();
	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
}
