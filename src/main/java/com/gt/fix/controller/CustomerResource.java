package com.gt.fix.controller;

import com.gt.fix.model.Customer;
import com.gt.fix.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {

    @Autowired
    private CustomerService cs;

    @PostMapping(value = {"","/"})
    public Customer addCustomer(@RequestBody Customer customer){

        return cs.addCustomer(customer);
    }


    @GetMapping
    public List<Customer> getCustomerList(){
        return cs.getCustomerList();
    }


    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId){
        return cs.getCustomer(customerId);

    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody  Customer customer){
        return cs.updateCustomer(customerId,customer);
    }

    @DeleteMapping(value = "/{customerId}")
    public Customer deleteCustomer(@PathVariable("customerId") int customerId){
        return  cs.deleteCustomer(customerId);
    }

}

