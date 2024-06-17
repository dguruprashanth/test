package com.generate.rewards.controller;

import com.generate.rewards.repository.UserRepository;
import com.generate.rewards.service.RewardsService;
import com.generate.rewards.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping(("/users"))
public class RewardsController {

  @Autowired
  private RewardsService rewardsService;

  @Autowired
  private UserService userService;


  @GetMapping("/{userId}/rewardsPerMonth")
    public Double  getRewards(@PathVariable Long userId){
    return rewardsService.getLastMonthRewardsByUserId(userId, LocalDate.now().minusDays(30));
    }

  @GetMapping("/{userId}/rewardsTotal")
  public Double  getRewardsTotal(@PathVariable Long userId){
    return rewardsService.getTotalRewardsByUserId(userId);
  }
}
