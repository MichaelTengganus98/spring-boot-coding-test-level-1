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
	private final PersonalInformationRepository personalInformationRepository;

	@Autowired
	public PersonalInformationServiceImpl(
			PersonalInformationRepository personalInformationRepository
	){
		this.personalInformationRepository = personalInformationRepository;
	}
	
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
	public List<PersonalInformationDTO> populte() {
		List<PersonalInformation> idols = new ArrayList<>();
		for(int i = 2; i < 7; ++i){
			PersonalInformation idol = new PersonalInformation();
			idol.setRealName(String.format("realName%d",i));
			idol.setIdolName(String.format("idolName%d",i));
			idol.setAddress(String.format("address%d",i));
			idol.setIdolStatus(i%2==0?"ACTIVE":"IN-ACTIVE");
			idols.add(idol);
		}

		List<PersonalInformationDTO> idolDtos = new ArrayList<>();
		personalInformationRepository.saveAll(idols);
		for (PersonalInformation idol : idols) {
			idolDtos.add(idol.toDto());
		}

		return idolDtos;
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
	@Transactional
	public PersonalInformationDTO delete(long id) {
		PersonalInformation idol = personalInformationRepository.findById(id);
		personalInformationRepository.deleteById(id);
		return idol.toDto();
	}
}
