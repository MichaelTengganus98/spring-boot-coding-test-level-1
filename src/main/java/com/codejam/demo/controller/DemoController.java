package com.codejam.demo.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codejam.demo.dto.PersonalInformationDTO;
import com.codejam.demo.model.PersonalInformation;
import com.codejam.demo.services.PersonalInformationServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class DemoController {
	@Autowired
	private final PersonalInformationServiceImpl personalInformationService = new PersonalInformationServiceImpl();

	  
	@GetMapping(path = "/unit-test")
	ResponseEntity<Integer> getUnitTestResult() throws Exception {
		return null;
	}

	@GetMapping
	ResponseEntity<PersonalInformationDTO> getAll() throws Exception {
		return new ResponseEntity(personalInformationService.getAll(),HttpStatus.OK);
	}
	
	@PostMapping(path = "/{id}")
	ResponseEntity<PersonalInformationDTO> update(
			@PathVariable long id,
			@RequestBody PersonalInformationDTO dto) throws Exception {
		return new ResponseEntity(personalInformationService.update(dto),HttpStatus.OK);
	}

}
