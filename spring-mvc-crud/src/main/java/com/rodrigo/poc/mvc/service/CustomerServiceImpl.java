package com.rodrigo.poc.mvc.service;

import com.rodrigo.poc.mvc.dao.ICustomerDao;
import com.rodrigo.poc.mvc.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao customerDao;

    public CustomerServiceImpl(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional("hibernateTransactionManager")
    public List<Customer> getCustomers() {
        return customerDao.getCostumers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }
}
