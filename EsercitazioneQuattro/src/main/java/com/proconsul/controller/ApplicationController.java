package com.proconsul.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proconsul.entity.Academy;
import com.proconsul.entity.Student;
import com.proconsul.entity.User;
import com.proconsul.service.AcademyStudentService;
import com.proconsul.service.UserService;

@Controller
public class ApplicationController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AcademyStudentService academyStudentService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		//ModelAndView mav = new ModelAndView("login");
		//mav.addObject("user",new User());
		
		return new ModelAndView("login","email",new User());
	}
	
	@GetMapping("/user")
	public ModelAndView signIn() {
		return new ModelAndView("user","user",new User());
	}
	
	@PostMapping("/users")
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
		return new ModelAndView(userService.saveUser(user));
	}
	
	@PostMapping("/academiesList")
	public ModelAndView showAcademies(@ModelAttribute("email")User user) {
		// academies é il nome del forEatch in academiesList.jsp
		return new ModelAndView(userService.findUserByEmail(user.getEmail()),"academies",academyStudentService.findAllAcademies());
	}
	@GetMapping("/academy")
	public ModelAndView showAcademy() {
		return new ModelAndView("academy","academy",new Academy());	}
	
	@PostMapping("/academies")
	public ModelAndView saveAcademy(@ModelAttribute("academy") Academy academy){
		return new ModelAndView(academyStudentService.saveAcademy(academy),"academies",academyStudentService.findAllAcademies());
	}
	
	@GetMapping("/academies/update/{code}")
	public ModelAndView showAcademyToUpdate(@PathVariable String code) {
		return new ModelAndView("academyUpdate","academyToUpdate",academyStudentService.findAcademyByCode(code));
	}
	
	@PostMapping("/academiesUpdated")
	public ModelAndView updateAcademy(@ModelAttribute("academyToUpdate") Academy academy){
		return new ModelAndView(academyStudentService.updateAcademy(academy),"academies",academyStudentService.findAllAcademies());
	}
	
	@GetMapping("/academies/remove/{code}")
	public ModelAndView removeAcademy(@PathVariable String code) {
		return new ModelAndView(academyStudentService.deleteAcademy(code),"academies",academyStudentService.findAllAcademies());
	}
	
	@GetMapping("/academy/students/show/{code}")
	public ModelAndView showStudents(@PathVariable String code) {
		return new ModelAndView(academyStudentService.checkFindAllStudents(code),"students",academyStudentService.findAllStudentsByAcademy(code));
	}
	
	@GetMapping("/academy/students/add/{code}")
	public ModelAndView addStudent(@PathVariable String code) {
		return new ModelAndView("student","student",academyStudentService.findStudentToAdd(code));
	}
	
	@PostMapping("/students")
	public ModelAndView addNewStudent(@ModelAttribute("student") Student student) {
		return new ModelAndView(academyStudentService.saveStudent(student, student.getAcademy().getCode()),"academies",academyStudentService.findAllAcademies());
	}
	
	@GetMapping("/students/update/{id}")
	public ModelAndView showAcademyToUpdate(@PathVariable int id) {
		return new ModelAndView("studentUpdate","studentToUpdate",academyStudentService.findStudentById(id));
	}
	
	@PostMapping("/students/update")
	public ModelAndView updateStudent(@ModelAttribute("studentToUpdate") Student student){
		return new ModelAndView(academyStudentService.updateStudent(student),"academies",academyStudentService.findAllAcademies());
	}
	
	@GetMapping("/students/remove/{id}")
	public ModelAndView removeStudent(@PathVariable int id) {
		return new ModelAndView(academyStudentService.deleteStudent(id),"academies",academyStudentService.findAllAcademies());
	}
	
	

	
	
	
	
	
	
	
	
	
}	