package com.cm.med_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="appointment")
public class Appointment {

	@Id
	private String id;
	private String patientName;
	private String patientEmail;
	private Integer age;
	private String gender;
	private String doctorName;
	private String appointmentDate;
	private String symptoms;
	
}
