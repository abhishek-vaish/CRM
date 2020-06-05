/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 03-06-2020
 *   Time: 01:26 PM
 */

package com.example.demo.crudapp.service;

import com.example.demo.crudapp.dao.DAOInterface;
import com.example.demo.crudapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private DAOInterface daoInterface;

    @Autowired
    public CustomerServiceImplementation(DAOInterface daoInterface) {
        this.daoInterface = daoInterface;
    }

    @Override
    @Transactional
    public List<Customer> getCustomer() {
        return daoInterface.getCustomer();
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        daoInterface.addCustomer(customer);
    }

    @Override
    public Customer getById(int id) {
        return daoInterface.getById(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        daoInterface.deleteCustomer(id);
    }
}
