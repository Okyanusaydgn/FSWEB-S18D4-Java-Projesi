package com.workintech.s18d4_part.repository;

import com.workintech.s18d4_part.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
