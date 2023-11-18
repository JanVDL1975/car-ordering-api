package com.project.dev.carorderingproject.controller;

import com.project.dev.carorderingproject.entity.Customer;
import com.project.dev.carorderingproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        boolean valInDB = (customerService.findCustomerByEmail(customer.getEmail()).isPresent() &&
                (customerService.findCustomerByEmail(customer.getEmail()).get()).getEmail().contentEquals(customer.getEmail()));
        if(valInDB != true){
            Customer returnVal = customerService.saveCustomer(customer);
            return returnVal;
        }
        else {
            throw new RuntimeException("Customer with e-mail " + customer.getEmail() + " found! Person already exists.");
        }
    }

    @PostMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        return customerService.getCustomerById(customerId)
                .map(customer -> {
                    customer.setFirstName(updatedCustomer.getFirstName());
                    customer.setLastName(updatedCustomer.getLastName());
                    String newMail = updatedCustomer.getEmail();
                    customer.setEmail(newMail);
                    return customerService.saveCustomer(customer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        if(customer.isPresent()) {
            customerService.deleteCustomer(customerId);
        }
    }
}

