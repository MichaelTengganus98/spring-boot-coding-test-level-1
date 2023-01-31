package com.codejam.demo.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class PersonalInformationDTO implements Serializable {
	
	@JsonProperty("id")
    private long id;
	
	@JsonProperty("realName")
    private String realName;
	
	@JsonProperty("idolName")
    private String idolName;
	
	@JsonProperty("address")
    private String address;
	
	@JsonProperty("idolStatus")
    private String idolStatus;

    public PersonalInformationDTO(long id, String realName, String idolName, String address,String idolStatus) {
    	this.id = id;
        this.realName = realName;
        this.idolName = idolName;
        this.address = address;
        this.idolStatus = idolStatus;
    }
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdolName() {
		return idolName;
	}

	public void setIdolName(String idolName) {
		this.idolName = idolName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdolStatus() {
		return idolStatus;
	}

	public void setIdolStatus(String idolStatus) {
		this.idolStatus = idolStatus;
	}
}
