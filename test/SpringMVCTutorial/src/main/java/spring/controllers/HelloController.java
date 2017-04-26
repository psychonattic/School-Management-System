package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.database.DatabaseCaller;
import spring.model.Student;

@Controller
public class HelloController 
{
	
	@Autowired
	DatabaseCaller stu;
	
	@GetMapping("/hello")
	public String hello(Model model) 
	{
		Student stew = (Student) stu.getStudentService().findByName("Dimitri");
		model.addAttribute("name", stew.getName());
		model.addAttribute("username", stew.getUserName());

		return "hello";
	}

}