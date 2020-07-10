package com.rodrigo.poc.mvc.dao;

import com.rodrigo.poc.mvc.entity.Customer;

import java.util.List;

public interface ICustomerDao {

    List<Customer> getCostumers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
