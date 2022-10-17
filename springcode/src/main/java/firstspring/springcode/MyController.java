package firstspring.springcode;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
	@SuppressWarnings("rawtypes")
	@Autowired
	EmployeeService service;
	
	
	@RequestMapping("/display")
public  String showhomePage(Model model) {
		System.out.println("Display is called");
	Collection<firstspring.springcode.Employee> list=service.displayData();
	System.out.println(list);
	for(firstspring.springcode.Employee product : list)
	{
		System.out.println(product.getId()+ " "+product.getName());
	}
	model.addAttribute("abc", list);
	return "show";
}
@RequestMapping("/addData")
public String newData(Model model)
{
	Employee product= new Employee();
	model.addAttribute("product", product);
	return "add_pro";
}
@RequestMapping(value =  "/save" , method = RequestMethod.POST)
public String saveData(@ModelAttribute("product") Employee product)
{
	service.saveEmployee(false);
	return "redirect:/";
}
@RequestMapping("/edit/{id}")
public ModelAndView editData(@PathVariable(name = "id") int id)
{
	ModelAndView view = new ModelAndView("edit_data");
	Employee product = service.getProd(id);
	view.addObject("employee", product);
	return view;
}

@RequestMapping("/delete/{id}")
public String deleteData(@PathVariable(name = "id") int id)
{
	service.delete(id);
	return "redirect:/";
}


}

