package com.luv2code.DAO;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //Need to inject session factory
    private SessionFactory sessionFactory;

    public CustomerDAOImpl() {
    }

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        //Get the current Hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        //Create a query
        Query<Customer> customerQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
        //Execute query and get the result list
        List<Customer> customers = customerQuery.getResultList();
        //Return retrieved list of customers
        return customers;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(customer);
        return customer;
    }
}
