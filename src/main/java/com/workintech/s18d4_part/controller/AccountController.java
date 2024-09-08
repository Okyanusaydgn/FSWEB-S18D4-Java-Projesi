package com.workintech.s18d4_part.controller;

import com.workintech.s18d4_part.dto.AccountResponse;
import com.workintech.s18d4_part.dto.CustomerResponse;
import com.workintech.s18d4_part.entity.Account;
import com.workintech.s18d4_part.entity.Customer;
import com.workintech.s18d4_part.service.AccountService;
import com.workintech.s18d4_part.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class AccountController {


    private final CustomerService customerService;

    private final AccountService accountService;

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")  
    public Account find(@PathVariable long id) throws AccountNotFoundException {
        return accountService.find(id);
    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@RequestBody Account account, @PathVariable long customerId) {
        Customer customer = customerService.find(customerId);
        if (customer != null) {
            customer.getAccounts().add(account);
            account.setCustomer(customer);
            accountService.save(account);
        } else {
            throw new RuntimeException("no customer found!");
        }
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@RequestBody Account account, @PathVariable long customerId) {
        Customer customer = customerService.find(customerId);
        Account foundAccount = null;
        for (Account account1 : customer.getAccounts()) {
            if (account.getId() == account1.getId()) {
                foundAccount = account1;
            }
        }
        if (foundAccount == null) {
            throw new RuntimeException("Account(" + account.getId() + ") not found for this customer: " + customerId);
        }

        int indexOfFound = customer.getAccounts().indexOf(foundAccount);
        customer.getAccounts().set(indexOfFound, account);
        account.setCustomer(customer);
        accountService.save(account);

        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }


    @DeleteMapping("/{id}")
    public AccountResponse remove(@PathVariable long id) {
        Account account = accountService.find(id);
        if (account != null) {
            accountService.delete(id);
            return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                    new CustomerResponse(account.getCustomer().getId(), account.getCustomer().getEmail(), account.getCustomer().getSalary()));
        } else {
            throw new RuntimeException("no account found!");
        }

    }

}
