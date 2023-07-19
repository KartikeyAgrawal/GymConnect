package com.usa.gym.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.usa.gym.Enum.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private long phoneNumber;

	private String gender;

	private String email;

	private String password;

	private String gymId;

	private LocalDateTime dateOfBirth = LocalDateTime.now();

	private LocalDateTime lastUpdated = LocalDateTime.now();

	private LocalDateTime createdDate = LocalDateTime.now();

	private int coin;

	private int level;

	private Role role;

	// private Package package;

	// private String packageStartDate;

	// private String packageEndDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Workout> workoutList;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Progress> progressList;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Attendance> attendance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGymId() {
		return gymId;
	}

	public void setGymId(String gymId) {
		this.gymId = gymId;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Workout> getWorkoutList() {
		return workoutList;
	}

	public void setWorkoutList(List<Workout> workoutList) {
		this.workoutList = workoutList;
	}

	public List<Progress> getProgressList() {
		return progressList;
	}

	public void setProgressList(List<Progress> progressList) {
		this.progressList = progressList;
	}
	
	public void addProgress(Progress userNewProgress) {
		if(progressList.isEmpty())
		{
			progressList = new ArrayList<>();
		}
		
		progressList.add(userNewProgress);
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}
	
	public void addAttendance(Attendance newAttendance) {
		if(attendance.isEmpty())
		{
			attendance = new ArrayList<>();
		}
		
		attendance.add(newAttendance);
	}
}
