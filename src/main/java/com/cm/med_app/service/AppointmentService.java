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
		message.setSubject("APPOINTMENT CONFIRMATION - WELL MED");
		String body =
		        "Dear " + appointment.getPatientName() + ",\n\n" +

		        "Your appointment has been successfully booked with Well Med.\n\n" +

		        "APPOINTMENT CONFIRMATION\n" +
		        "========================\n\n" +

		        "Appointment ID : " + appointment.getId() + "\n" +
		        "Doctor         : " + appointment.getDoctorName() + "\n" +
		        "Date           : " + appointment.getAppointmentDate() + "\n" +
		        "Symptoms       : " + appointment.getSymptoms() + "\n\n" +

		        "Please arrive at least 15 minutes before your scheduled appointment.\n\n" +

		        "If you have any questions or need to reschedule your appointment, " +
		        "please contact our support team.\n\n" +

		        "Thank you for choosing Med Care.\n" +
		        "We wish you good health and a speedy recovery!\n\n" +

		        "Regards,\n" +
		        "Well Med Team\n" +
		        "Healthcare & Medical Services";
		 message.setText(body);  
		 mailSender.send(message);
		        
	}

}
