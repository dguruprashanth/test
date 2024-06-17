package com.generate.rewards.repository;

import com.generate.rewards.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
        List<Transaction> findByCustomerIdAndTransactionDateBefore(Long userId, LocalDate date);

        List<Transaction>findByCustomerId(Long userId);

}
