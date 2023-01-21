package jUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import customer.models.Customer;
import static org.junit.Assert.assertEquals;



public class CustomerTest {

	@Test
	public void testGetFullName() {
		Customer customer = new Customer("John", "Doe", "johndoe@email.com", "123-456-7890", "123 Main St", "Male");
		String expected = "John Doe";
		assertEquals(expected, customer.getFullName());
	}

	@Test
	public void testGetCustomers() {
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer("John", "Doe", "johndoe@email.com", "123-456-7890", "123 Main St", "Male"));
		customers.add(new Customer("Jane", "Doe", "janedoe@email.com", "098-765-4321", "456 Park Ave", "Female"));
		assertEquals(customers, new Customer().getCusomers());
	}

	@Test
	public void testGetCustomer() {
		Customer customer = new Customer("John", "Doe", "johndoe@email.com", "123-456-7890", "123 Main St", "Male");
		assertEquals(customer, new Customer().getCustomer("John Doe"));
	}


	 

}
