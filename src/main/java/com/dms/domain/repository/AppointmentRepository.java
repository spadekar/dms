package com.dms.domain.repository;

import com.dms.domain.models.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentRepository extends MongoRepository<Appointment,String> {}
//@Service
//public class AppointmentRepository extends AbstractRepository<Appointment> {}

