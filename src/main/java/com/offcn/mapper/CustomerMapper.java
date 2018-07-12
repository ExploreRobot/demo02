package com.offcn.mapper;

import java.util.List;

import com.offcn.pojo.Customer;

public interface CustomerMapper {
	 List<Customer> getCustomerList();
	
	 void saveCustomer(Customer c);

	 List<Customer> getCustomerListByName(String job);
}
