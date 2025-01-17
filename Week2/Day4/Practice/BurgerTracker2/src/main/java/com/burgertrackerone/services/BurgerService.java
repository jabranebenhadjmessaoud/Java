package com.burgertrackerone.services;

import java.util.List;
import java.util.Optional;

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
	
	public Burger getBurgerById(Long id) {
		Optional<Burger> burger = burgerRepo.findById(id);
		if(burger.isEmpty()) {
			return null;
		}
		return burger.get();
	}
	
	public Burger updateBurger(Long id, Burger newBurger) {
		newBurger.setId(id);
		return burgerRepo.save(newBurger);
	}
}
