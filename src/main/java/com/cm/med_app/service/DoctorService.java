package com.cm.med_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.med_app.model.Doctor;
import com.cm.med_app.repository.DoctorRepository;

@Service
public class DoctorService {

	
	@Autowired
	private DoctorRepository doctorRepo;
	
	
	public List<Doctor> getAvailableDoctor()
	{
		return doctorRepo.findByAvailableTrue();
	}
}
