package com.generate.rewards.repository;

import com.generate.rewards.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository <Customer, Long>{

}
