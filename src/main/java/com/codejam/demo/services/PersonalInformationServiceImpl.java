package com.codejam.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejam.demo.dto.PersonalInformationDTO;
import com.codejam.demo.model.PersonalInformation;
import com.codejam.demo.repository.PersonalInformationRepository;

@Service
public class PersonalInformationServiceImpl {
	@Autowired
	private PersonalInformationRepository personalInformationRepository;
	
	public List<PersonalInformationDTO> getAll() {
		Iterable<PersonalInformation> test = personalInformationRepository.findAll();
		List<PersonalInformation> list = Streamable.of(test).toList();
		List<PersonalInformationDTO> listDto = new ArrayList<PersonalInformationDTO>();
		for(int i=0;i<list.size();i++) {
			listDto.add(list.get(i).toDto());
		}
		return listDto;
	}
	
	@Transactional
	public PersonalInformationDTO create(PersonalInformationDTO dto) {
		PersonalInformation idol = new PersonalInformation();
		idol.setRealName(dto.getRealName());
		idol.setIdolName(dto.getIdolName());
		idol.setAddress(dto.getAddress());
		idol.setIdolStatus(dto.getIdolStatus());
		
		idol = personalInformationRepository.save(idol);
		
		return idol.toDto();
	}

	@Transactional
	public PersonalInformationDTO update(long id, PersonalInformationDTO dto) {

		PersonalInformation idol = personalInformationRepository.findById(id);
		idol.setRealName(dto.getRealName());
		idol.setIdolName(dto.getIdolName());
		idol.setAddress(dto.getAddress());
		idol.setIdolStatus(dto.getIdolStatus());
		
		idol = personalInformationRepository.save(idol);
		
		return idol.toDto();
	}
}
