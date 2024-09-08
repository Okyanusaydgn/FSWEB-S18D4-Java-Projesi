package com.workintech.s18d4_part.service;

import com.workintech.s18d4_part.entity.Account;
import com.workintech.s18d4_part.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account find(long id) {

        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        }
        return null;
    }

    /*
    * @Override
    * public Account find(long id) {
    *     return accountRepository.findById(id).orElse(null);
    * }
    *
    * */

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(long id) {
        Account account = find(id);
        if(account != null){
            accountRepository.delete(account);
        }
        return null;
    }
}
