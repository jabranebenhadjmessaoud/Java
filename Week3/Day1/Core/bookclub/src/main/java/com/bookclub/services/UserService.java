package com.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bookclub.models.LoginUser;
import com.bookclub.models.User;
import com.bookclub.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
//get all users
public List<User> findAllUsers(){
	return userRepo.findAll();
}

//get userById
public User findById(Long id) {
	Optional<User> u = userRepo.findById(id);
	if(u.isEmpty()) {
		System.out.println("empty user ");
		return null;
	}
	return u.get();
}

//get user by email
public User findByEmail(String email) {
	Optional<User> u = userRepo.findByEmail(email);
	if(u.isEmpty()) {
		return null;
	}
	return u.get();
}

//registration process
public User register(User newUser, BindingResult result) {
	//Check the email existance in the DB
	if(findByEmail(newUser.getEmail())!= null) {
		result.rejectValue("email", "email duplication", "Email already exist");
	}
	//Check the password and the confirm
	if(!newUser.getPassword().equals(newUser.getConfirm())) {
		result.rejectValue("confirm", "Not Much", "Password doesn't much");
	}
	if(result.hasErrors()) {
		return null;
	}
	
	//hash the password 
	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	newUser.setPassword(hashed);
	userRepo.save(newUser);
	return newUser;
}

//login process
public User login(LoginUser newLogin, BindingResult result) {
	//Check the email existance
	User user = findByEmail(newLogin.getEmail());
	if(user == null) {
		result.rejectValue("email", "Does not exist", "The is no email in the db!!");
	}
	if(result.hasErrors()) {
		return null;
	}
	
	//Check the password and the hashed one
	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
		result.rejectValue("password", "Not Much", "Wrong password");
	}
	if(result.hasErrors()) {
		return null;
	}
	return user;
	
}

//Create user
public User createUser(User user) {
	return userRepo.save(user);
}
}
