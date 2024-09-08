package com.workintech.s18d4_part.service;

import com.workintech.s18d4_part.entity.Account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AccountService {

    List<Account> findAll();


    Account find(long id);


    Account save(Account  account);

    Account delete (long id);

}
