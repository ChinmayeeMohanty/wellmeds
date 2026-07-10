package com.cm.med_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cm.med_app.model.Appointment;
import com.cm.med_app.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public Appointment saveAppointment(Appointment appointment)
	{
		return appointmentRepo.save(appointment);
	}
	
	public void sendAppointmentEmail(Appointment appointment)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(appointment.getPatientEmail());
		message.setSubject("APPOINTMENT CONFIRMATION - MEDAPP");
		String body = 
				"Dear "+ appointment.getPatientName()+ ",\n\n " + 
		        "Your appointment has been book successfully.\n\n" +
				"Appointment Details:\n"+
		        "-------------------\n"+
				"Appointment ID: "+appointment.getId()+"\n"+
				"Doctor: "+appointment.getDoctorName()+"\n"+
				"Date: "+appointment.getAppointmentDate()+"\n"+
				"Symptoms: "+appointment.getSymptoms()+"\n\n"+
				
				"**Thank you for choosing med-app**\n\n"+
				"\t\t\tGet well soon!";
		
		 message.setText(body);  
		 mailSender.send(message);
		        
	}

}
