package com.workintech.s18d4_part.service;


import com.workintech.s18d4_part.entity.Customer;
import com.workintech.s18d4_part.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;



    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer find(long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        }
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(long id) {
        Customer customer = find(id);
        if (customer != null) {
            customerRepository.delete(customer);
            return customer;
        }
        return null;
    }

}