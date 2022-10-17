package firstspring.springcode;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService<Myrepo> {
	@Autowired
	Myrepo repo;
	public Collection<Employee> displayData()
	{
		
	return ((Object) repo).findAll();
		
	}

public Employee getProd(long id, com.springboot.springcode.model.Employee product) {
	return repo.save(saveProduct(product));
}

public void delete(int id) {
	repo.deleteById((int) id);
	
}
public Employee getProd(int id) {
	
	return null;
}

public void saveEmployee(boolean equals) {
	// TODO Auto-generated method stub
	
}

public void saveProduct(com.springboot.springcode.model.Employee product) {
	// TODO Auto-generated method stub
	
}
}

