package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Customer;

public interface CustomerService {
	
	 List<Customer> getCustomerList();

	 void saveCustomer(Customer c);

	 List<Customer> getCustomerListByName(String job);

}
