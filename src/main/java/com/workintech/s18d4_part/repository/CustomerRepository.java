package com.workintech.s18d4_part.repository;

import com.workintech.s18d4_part.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
