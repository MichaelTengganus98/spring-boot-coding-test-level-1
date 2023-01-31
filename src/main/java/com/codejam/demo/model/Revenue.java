package com.codejam.demo.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "REVENUE")
public class Revenue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Setter
	@Getter
	@Column(name = "monthly_rate")
	private String monthlyRate;

	@Setter
	@Getter
	@Column(name = "event_name")
	private String eventName;

	@Setter
	@Getter
	@Column(name = "date_time")
	private String dateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(String monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
