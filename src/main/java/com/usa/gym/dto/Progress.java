package com.usa.gym.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProgressDetails")
public class Progress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private LocalDateTime dateTime;
	
	private String weight;
	
	private String fat;
	
	private String water;
	
	private String protein;
	
	private String calories;

}
