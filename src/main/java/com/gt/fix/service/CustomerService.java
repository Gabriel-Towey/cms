package com.gt.fix.service;

import com.gt.fix.dao.CustomerDAO;
import com.gt.fix.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDao;
    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();




    public List<Customer> getCustomerList(){
        return customerDao.findAll();
        //return this.customerList;
    }

    public Customer addCustomer(Customer customer){
        /*customer.setCustomerID(customerIdCount);
        customerList.add(customer);
        customerIdCount++;*/
        return customerDao.save(customer);
        /*return customer;*/
    }

    public Customer getCustomer(int customerId) {
        /*return customerList
                .stream()
                .filter(c -> c.getCustomerID() == customerId)
                .findFirst()
                .get();*/
        return customerDao.findById(customerId).get();
    }

    public Customer updateCustomer(int customerId, Customer customer){
        customer.setCustomerID(customerId);
        /*customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerID() == customerId){
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });

        return customerList.stream()
                .filter( c -> c.getCustomerID() == customerId)
                .findFirst()
                .get();*/

        return customerDao.save(customer);


    }

    public Customer deleteCustomer(int customerId){
        /*Customer toDelete = customerList
                            .stream()
                            .filter( c -> c.getCustomerID() == customerId)
                            .findFirst()
                            .get();*/

        Customer toDelete = customerDao.findById(customerId).get();
        /*customerList
                .stream()
                .forEach( c -> {
                    if(c.getCustomerID() == customerId){
                        customerList.remove(c);
                    }

                });*/
        customerDao.deleteById(customerId);
        return toDelete;


    }


}
