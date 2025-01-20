package com.playlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.playlist.models.LoginUser;
import com.playlist.models.Song;
import com.playlist.models.User;
import com.playlist.services.SongService;
import com.playlist.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
@Autowired
UserService userServ;
@Autowired 
SongService songServ;

// get index page (authentication)
@GetMapping("/")
public String index(Model model) {
	model.addAttribute("newUser",new User());
	model.addAttribute("newLogin",new LoginUser());
	return "index";
}
// registration process 
@PostMapping("/register")
public String register(@Valid @ModelAttribute("newUser") User newUser,
		             BindingResult result,
		             HttpSession session,
		             Model model) {
User user = userServ.register(newUser, result);
	
    if(result.hasErrors()) {
        //  send in the empty LoginUser before re-rendering the page.
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }
    
    session.setAttribute("userId", user.getId());
    session.setAttribute("connectedUser", user);
    return "redirect:/home";
	
}

// login process
@PostMapping("/login")
public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin,
		 BindingResult result,
         HttpSession session,
         Model model) {
	User user = userServ.login(newLogin, result);
	 
    if(result.hasErrors() || user==null) {
    	//set the new user to empty and redirect to index
        model.addAttribute("newUser", new User());
        return "index";
    }
     //redirect to home page
    session.setAttribute("userId", user.getId());
    session.setAttribute("connectedUser", user);
 
    return "redirect:/home";
}

// get home Page 
@GetMapping("/home")
public String getHome(HttpSession session,
		Model model) {
	//Route Garding to be added in each getMapping
	Long userId = (Long) session.getAttribute("userId");
	if(userId == null) {
		return "redirect:/logout";
	}
	User connectedUser = userServ.getUserById((Long) session.getAttribute("userId"));
	model.addAttribute("user", connectedUser);
	model.addAttribute("songs",songServ.getAllSongs());
	return "home";
}
// logOut
@GetMapping("/logout")
public String logout(HttpSession session) {
	
		session.invalidate();
	     
	    return "redirect:/";
}

// user playList
@GetMapping("/playlist")
public String playList(Model model,HttpSession session) {
	model.addAttribute("playlist",userServ.getUserById((Long) session.getAttribute("userId")).getPlayList());
	return "myplaylist";
	
}

//// remove song from playList in user view playList
@GetMapping("/remove/{songId}/playlist")
public String removeFromPlayList(@PathVariable("songId")Long songId,
		                    HttpSession session) {
	// we will get the connected user
	User connectedUser = userServ.getUserById((Long) session.getAttribute("userId"));
	// we will get the song by id 
	Song song=songServ.findById(songId);
	
	// we will add the song to the user playList
	connectedUser.getPlayList().remove(song);
	System.out.println(connectedUser.getPlayList());
	userServ.updateUser(connectedUser);
	
	return "redirect:/playlist";
}


}
