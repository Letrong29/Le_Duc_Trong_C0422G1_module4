package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> findById(){
        List<Customer> customers = this.iCustomerService.findAll();

        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Customer> findById(@RequestParam int id){

        Optional<Customer> customer = this.iCustomerService.findById(id);

        if (!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(this.iCustomerService.save(customer),
                HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Customer> updateCustomer(@RequestParam int id, @RequestBody Customer customer) {

        Optional<Customer> customerOptional = iCustomerService.findById(id);

        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customer.setId(customerOptional.get().getId());

        return new ResponseEntity<>(this.iCustomerService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Customer> deleteCustomer(@RequestParam int id) {

        Optional<Customer> customerOptional = this.iCustomerService.findById(id);

        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.iCustomerService.remove(id);

        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
