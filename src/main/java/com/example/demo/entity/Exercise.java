package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise_records")
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "user_id")
	private Integer userId;
	private Integer eventId;
	private Date date;
	private Integer time;
	private Integer burn_calorie;
	private String memo;

	public Exercise() {
	}

	public Exercise(Integer id, Integer userId, Integer eventId, Date date, Integer time, Integer burn_calorie,
			String memo) {
		this.id = id;
		this.userId = userId;
		this.eventId = eventId;
		this.date = date;
		this.time = time;
		this.burn_calorie = burn_calorie;
		this.memo = memo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getBurn_calorie() {
		return burn_calorie;
	}

	public void setBurn_calorie(Integer burn_calorie) {
		this.burn_calorie = burn_calorie;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
