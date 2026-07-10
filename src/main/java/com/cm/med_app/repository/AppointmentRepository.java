package com.cm.med_app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cm.med_app.model.Appointment;

public interface AppointmentRepository extends MongoRepository<Appointment,String>{

}
