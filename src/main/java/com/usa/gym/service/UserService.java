package com.usa.gym.service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.gym.dto.Attendance;
import com.usa.gym.dto.Progress;
import com.usa.gym.dto.User;
import com.usa.gym.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void addAttendance(int userId) {
		Optional<User> user = userRepository.findById(userId);
		Attendance attendance = new Attendance();
		if (user.isPresent()) {
			user.get().addAttendance(attendance);
			sort(user.get().getAttendance());
			userRepository.save(user.get());
		}
		
	}
	
	

	private void sort(List<Attendance> attendance) {
		
		attendance.sort((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()));
	}

	public List<Attendance> getUserAttendance(int userId) {
		Optional<User> userOpt = userRepository.findById(userId);
		if (userOpt.isPresent()) {
			DayOfWeek DayOfWeek = userOpt.get().getDateOfBirth().getDayOfWeek();
			
			return userOpt.get().getAttendance();
		}
		return null;
	}

	public void addUserProgress(int userId,Progress progress) {
		Optional<User> userOpt = userRepository.findById(userId);
		if (userOpt.isPresent()) {
			userOpt.get().addProgress(progress);
			userRepository.save(userOpt.get());
		}
		else
		{
			//throw error user not found
		}
	}
	
	
	public void fetchContinuousness(int userId)
	{
		Optional<User> userOpt = userRepository.findById(userId);
		
		userOpt.get().getAttendance().forEach(at -> {
			System.out.println(at.getDateTime());
		});
		userOpt.get().getAttendance().sort((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime()));
		
		System.out.println("After \t");
		
		userOpt.get().getAttendance().forEach(at -> {
			System.out.println(at.getDateTime());
		});
	}
}