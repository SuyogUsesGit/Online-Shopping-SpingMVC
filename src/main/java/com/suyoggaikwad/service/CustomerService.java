package com.suyoggaikwad.service;

import com.suyoggaikwad.dao.CustomerDao;
import com.suyoggaikwad.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerDao dao;

    @Autowired
    public CustomerService(CustomerDao dao) {
        this.dao = dao;
    }

    public boolean registerCustomer(Customer customer) {
        return dao.registerCustomer(customer);
    }

    public int validateCustomer(Customer customer) {
        return dao.validateCustomer(customer);
    }
}
