package com.workintech.s18d4_part.service;

import com.workintech.s18d4_part.entity.Account;
import com.workintech.s18d4_part.entity.Customer;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

public interface CustomerService {


    List<Customer> findAll();


    Customer find(long id);


    Customer save(Customer  customer);


    Customer delete (long id);

}
