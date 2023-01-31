package com.codejam.demo.model;
import javax.persistence.*;

import com.codejam.demo.dto.PersonalInformationDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERSONAL_INFORMATION")
public class PersonalInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Setter
	@Getter
	@Column(name = "real_name")
	private String realName;

	@Setter
	@Getter
	@Column(name = "idol_name")
	private String idolName;

	@Setter
	@Getter
	@Column(name = "address")
	private String address;

	@Setter
	@Getter
	@Column(name = "idol_status")
	private String idolStatus;
	
	public PersonalInformationDTO toDto() {
		return new PersonalInformationDTO(
				(int) this.id,
				this.realName, 
				this.idolName, 
				this.address, 
				this.idolStatus);
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

	public String getIdolName() {
		return idolName;
	}

	public String getAddress() {
		return address;
	}

	public String getIdolStatus() {
		return idolStatus;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public void setIdolName(String idolName) {
		this.idolName = idolName;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setIdolStatus(String idolStatus) {
		this.idolStatus = idolStatus;
	}
}