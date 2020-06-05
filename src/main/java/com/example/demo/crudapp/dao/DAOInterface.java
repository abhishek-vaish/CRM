/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 03-06-2020
 *   Time: 10:17 AM
 */


package com.example.demo.crudapp.dao;

import com.example.demo.crudapp.entity.Customer;

import java.util.List;

public interface DAOInterface {

    List<Customer> getCustomer();

    void addCustomer(Customer customer);

    Customer getById(int id);

    void deleteCustomer(int id);
}
