
package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class DaikichiController {

	@RequestMapping("/daikichi")
	public String welcome() {
		return "Welcome ! ";
	}
	@RequestMapping("/daikichi/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/daikichi/tomorow")
	public String tomorow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/daikichi/travel/{countryname}")
	public String travelcountry(@PathVariable("countryname") String countryname) {
		return "Congratulations! You will soon travel to "+countryname;
	}
	@RequestMapping("/daikichi/lotto/{number}")
	public String lotto(@PathVariable("number") int number) {
		if (number %2==0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers"; 
		}
		else 
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends " ;
				
	}
}