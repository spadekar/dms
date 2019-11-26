package com.dms;

import com.dms.domain.repository.AppointmentRepository;
import com.dms.domain.repository.PatientRepository;
import com.dms.domain.repository.StaffRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class DentalmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalmanagementsystemApplication.class, args);
	}

}
