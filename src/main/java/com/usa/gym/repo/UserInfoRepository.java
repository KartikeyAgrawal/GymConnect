package com.usa.gym.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.gym.dto.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	Optional<UserInfo> findByName(String username);
}
