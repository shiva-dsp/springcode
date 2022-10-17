package com.springboot.springcode.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import firstspring.springcode.EmployeeService;

public class Employee {
	public static final Employee Employee = null;
	public Object model;

	@Controller
	public class MyController {
		@Autowired
		EmployeeService service;
		
		
		@RequestMapping("/display")
	public  String showhomePage(Model model) {
			System.out.println("Display is called");
		List<Employee> list= service.displayData();
		System.out.println(list);
		for(Employee product : list)
		{
			System.out.println(product.getId()+ " "+product.getName());
		}
		model.addAttribute("abc", list);
		return "show";
	}
	@RequestMapping("/addData")
	public String newData(Model model)
	{
		Employee employe= new Employee();
		model.addAttribute("product", employe);
		return "add_pro";
	}
	@RequestMapping(value =  "/save" , method = RequestMethod.POST)
	public String saveData(@ModelAttribute("employe") Employee employee)
	{
		service.delete(0);
		return "redirect:/";
	}
	

	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable(name = "id") int id)
	{
		service.delete(id);
		return "redirect:/";
	}


	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


}
