package CustomerJSP.model;

import java.util.LinkedList;
import java.util.List;

import CustomerJSP.repository.CustomerRepository;

public class CustomerService {
	private List<Customer> customers;
	private CustomerRepository repository;
	
	public List<Customer> findAllCustomer() {
		return repository.findAllCustomer();
	}
	
	public CustomerService() {
		repository = new CustomerRepository();
		customers = new LinkedList<Customer>();
		
		customers.add(new Customer(1, "Hải", "87 BCD", "tungochai69@gmail.com"));
		customers.add(new Customer(2, "Bi", "87 BCD", "bi210299@gmail.com"));
	}
	
	public Customer findCustomerByCode(int code) {
		return repository.findCustomerByCode(code);
	}
	
	public int deleteCustomerByCode(int code) {
		return repository.deleteCustomerByCode(code);
		
	}
	
	public int addNewCustomer(Customer customer)
	{
		return repository.addNewCustomer(customer);
	}
	
	public int update(Customer cus, int code) {
		return repository.update(cus, code);
	}
}
