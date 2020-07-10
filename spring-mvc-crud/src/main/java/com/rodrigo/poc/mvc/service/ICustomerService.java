package com.rodrigo.poc.mvc.service;

import com.rodrigo.poc.mvc.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
