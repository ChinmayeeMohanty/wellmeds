package com.cm.med_app.config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.cm.med_app.model.Role;
import com.cm.med_app.model.User;
import com.cm.med_app.repository.UserRepository;

@Configuration
public class DataIntializer {


	@Value("${app.security.admin.username}")
	private String adminUserName;
	@Value("${app.security.admin.password}")
	private String adminUserPassword;
	
	@Value("${app.security.patient.username}")
	private String patientName;
	@Value("${app.security.patient.password}")
	private String patientPassword;
	
	@Value("${app.security.doctor.username}")
	private String doctorName;
	@Value("${app.security.doctor.password}")
	private String doctorPassword;
	
	@Value("${app.security.pharmacist.username}")
	private String pharmacistName;
	@Value("${app.security.pharmacist.password}")
	private String pharmacistPassword;
   

	@Bean
	CommandLineRunner initUser(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder)
	{
		return args->{
			if(userRepo.findByUserName(adminUserName).isEmpty()) {
				
				User admin=new User();
				admin.setUserName(adminUserName);
				admin.setPassword(passwordEncoder.encode(adminUserPassword));
				admin.setRoles(Set.of(Role.ROLE_ADMIN));
				admin.setEnabled(true);
				userRepo.save(admin);
			}
			if(userRepo.findByUserName(patientName).isEmpty()) {
				
				User patient=new User();
				patient.setUserName(patientName);
				patient.setPassword(passwordEncoder.encode(patientPassword));
				patient.setRoles(Set.of(Role.ROLE_PATIENT));
				patient.setEnabled(true);
				userRepo.save(patient);
			}
			if(userRepo.findByUserName(doctorName).isEmpty()) {
				
				User doctor=new User();
				doctor.setUserName(doctorName);
				doctor.setPassword(passwordEncoder.encode(doctorPassword));
				doctor.setRoles(Set.of(Role.ROLE_DOCTOR));
				doctor.setEnabled(true);
				userRepo.save(doctor);
			}
			if(userRepo.findByUserName(pharmacistName).isEmpty()) {
				
				User pharmacist=new User();
				pharmacist.setUserName(pharmacistName);
				pharmacist.setPassword(passwordEncoder.encode(pharmacistPassword));
				pharmacist.setRoles(Set.of(Role.ROLE_PHARMACIST));
				pharmacist.setEnabled(true);
				userRepo.save(pharmacist);
			}
		};
	}
	
}
