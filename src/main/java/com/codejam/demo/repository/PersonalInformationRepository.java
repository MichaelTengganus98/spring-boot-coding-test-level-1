package com.codejam.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codejam.demo.model.PersonalInformation;

@Repository
public interface PersonalInformationRepository extends CrudRepository<PersonalInformation, Long> {
	PersonalInformation findById(long id);
}