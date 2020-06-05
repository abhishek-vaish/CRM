/*
 * Created by IntelliJ IDEA Ultimate, 2020
 *   User: Abhishek
 *   Date: 03-06-2020
 *   Time: 10:36 AM
 */


package com.example.demo.crudapp.dao;

import com.example.demo.crudapp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DAOImplementation implements DAOInterface {

    private EntityManager entityManager;

    @Autowired
    public DAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Customer> getCustomer() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> query = currentSession.createQuery("select c from Customer c", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);
    }

    @Override
    @Transactional
    public Customer getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
    }

}
