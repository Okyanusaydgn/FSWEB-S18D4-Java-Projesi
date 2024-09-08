package com.workintech.s18d4_part.controller;

import com.workintech.s18d4_part.dto.CustomerResponse;
import com.workintech.s18d4_part.entity.Customer;
import com.workintech.s18d4_part.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer){
        Customer saved = this.customerService.save(customer);
        return new CustomerResponse(saved.getId(), saved.getEmail(), saved.getSalary());
    }

}
