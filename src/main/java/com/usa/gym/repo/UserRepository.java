package com.usa.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.gym.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
