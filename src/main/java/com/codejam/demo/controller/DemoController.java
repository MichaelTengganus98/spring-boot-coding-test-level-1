package com.codejam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codejam.demo.dto.PersonalInformationDTO;
import com.codejam.demo.services.PersonalInformationServiceImpl;

@RestController
@RequestMapping(path = "demo")
public class DemoController {
	@Autowired
	private final PersonalInformationServiceImpl personalInformationService;

	@Autowired
	public DemoController(PersonalInformationServiceImpl personalInformationService){
		this.personalInformationService = personalInformationService;
	}
	  
	@GetMapping(path = "/unit-test")
	ResponseEntity<Integer> getUnitTestResult() throws Exception {
		return null;
	}

	@GetMapping
	ResponseEntity<PersonalInformationDTO> getAll() throws Exception {
		return new ResponseEntity(personalInformationService.getAll(),HttpStatus.OK);
	}

	@PostMapping
	ResponseEntity<PersonalInformationDTO> create(
			@RequestBody PersonalInformationDTO dto) throws Exception {
		return new ResponseEntity(personalInformationService.create(dto), HttpStatus.OK);
	}
	@PostMapping(path = "/populate")
	ResponseEntity<PersonalInformationDTO> populate() throws Exception {
		return new ResponseEntity(personalInformationService.populte(), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	ResponseEntity<PersonalInformationDTO> update(
			@PathVariable long id,
			@RequestBody PersonalInformationDTO dto) throws Exception {
		return new ResponseEntity(personalInformationService.update(id, dto),HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	ResponseEntity<PersonalInformationDTO> delete(
			@PathVariable long id) throws Exception {
		return new ResponseEntity(personalInformationService.delete(id),HttpStatus.OK);
	}
}
