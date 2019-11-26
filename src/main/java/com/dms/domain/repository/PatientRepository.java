package com.dms.domain.repository;

import com.dms.domain.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface PatientRepository extends MongoRepository<Patient,String> {
}
