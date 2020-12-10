package com.wf.training.bootapp.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wf.training.bootapp.model.Employee;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//dashboard for employee
	// @RequestMapping("/home")  // /employee/home
	// multiple url can be mapped
	@RequestMapping(value= {"/home","/dashboard","/index"})  // /employee/home
	public String home(Principal principal) { // info of currently logged in user
		// business logic
	
		return "employee-home";
	}
	
	// default mapping for parent url
	@RequestMapping()
	public String defaultResponse() {
		// return "employee-base";
		return "redirect:/employee/home";// ~sendRedirect()
	}
	
	// fallback url mapping
	/*@RequestMapping("*")
	public String fallback() {
		// return "employee-error";
		return "redirect:/employee/home";// ~sendRedirect()
	}*/
	
	
	
	// receive the form info
	// servlet-way 
	/*@RequestMapping("/profile-save")
	public String saveProfile(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		System.out.println(name + " | " + email + " | " + contact);
		return "profile-confirm";
	}*/
	
	// spring-way
	// can accept any verb request
	// @RequestMapping("/profile-save")
	// accept a particular type of http verb
	// @RequestMapping(value = { "/profile-save" }, method = RequestMethod.POST)
	// verb specific annotation
	/*@PostMapping("/profile-save")
	public String saveProfile(@RequestParam("name") String empName, 
							  @RequestParam String email, 
							  @RequestParam(value = "contact", required = false, defaultValue = "1111111") String contact) {
		System.out.println("POST DATA : " + empName + " | " + email + " | " + contact);
		return "profile-confirm";
	}*/
	
	// spring abstract way : form values can be mapped directly with Model class
	// need to share employee info with JSP page : model object
	/*@PostMapping("/profile-save")
	public String saveProfile(Employee employee, Model model) {
		// System.out.println("POST DATA : " + employee.getName() + " | " + employee.getEmail() + " | " + employee.getContact());
		// put data in model container
		model.addAttribute("employee", employee);
		return "profile-confirm";
	}*/
	
	// ModelAndView : clubbed object 
	/*@PostMapping("/profile-save")
	public ModelAndView saveProfile(Employee employee) {
		ModelAndView mv = new ModelAndView("profile-confirm");
		// mv.setViewName("");
		// put data in model container
		mv.addObject("employee",employee);
		return mv;
	}*/
	
	// respond back profile-entry form
	@RequestMapping("/profile-entry") // /employee/profile-entry
	public String profileEntry(Model model) {
		// share a blank/empty employee object with jsp to map with spring form
		Employee employee = new Employee();
		employee.setCountry("IN");
		String[] languages = new String[] {"Python","C#"};
		employee.setFavoriteLanguages(languages);
		model.addAttribute("employee", employee);
		return "employee-profile-entry";
	}
	
	// auto add param value to model container
	// we want to validation : @Valid
	@PostMapping("/profile-save")
	public String saveProfile(@Valid @ModelAttribute Employee employee, 
							  BindingResult result) {
		if(result.hasErrors()) {
			// revert back the entry form
			return "employee-profile-entry";
		}
		
		return "profile-confirm";
	}
	
	
	// @RequestMapping(value = { "/profile-save" }, method = RequestMethod.GET)
	@GetMapping("/profile-save")
	public String saveProfilePro(String name, String email, String contact) {
		System.out.println("GET DATA : " + name + " | " + email + " | " + contact);
		return "profile-confirm";
	}
	
}














