package com.generate.rewards.service;

import com.generate.rewards.model.Customer;
import com.generate.rewards.model.Transaction;
import com.generate.rewards.repository.TransactionRepository;
import com.generate.rewards.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RewardsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Double getTotalRewardsByUserId(Long userId) {
        double rewards=0;
        double tempPurchaseAmout=0;
       Optional<Customer> user  =  userRepository.findById(userId);
        List<Transaction> transactions  = transactionRepository.findByCustomerId(userId);

        double purchaseAmount = transactions.stream().mapToDouble(Transaction::getTransactionAmount).sum();
        if(purchaseAmount>50){
            if(purchaseAmount>100){
                tempPurchaseAmout= 100;
                rewards= (tempPurchaseAmout-50)*1;
            }
            else
            rewards= (purchaseAmount-50)*1;
        }

        if(purchaseAmount>100){
            rewards+= (purchaseAmount-100)*2;
        }
        return rewards;
    }


    public Double getLastMonthRewardsByUserId(Long userId, LocalDate date) {
        double rewards=0;
        double tempPurchaseAmout=0;
        Optional<Customer> user  =  userRepository.findById(userId);
        List<Transaction> transactions  = transactionRepository.findByCustomerIdAndTransactionDateBefore(userId,date);
        double purchaseAmount = transactions.stream().mapToDouble(Transaction::getTransactionAmount).sum();
        if(purchaseAmount>50){
            if(purchaseAmount>100){
                tempPurchaseAmout= 100;
                rewards= (tempPurchaseAmout-50)*1;
            }
            else
                rewards= (purchaseAmount-50)*1;
        }

        if(purchaseAmount>100){
            rewards+= (purchaseAmount-100)*2;
        }
        return rewards;
    }
}


