package com.dms.domain.service;

import com.dms.domain.models.Patient;
import com.dms.domain.repository.PatientRepository;
import com.dms.domain.vo.PatientRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient update(String id, PatientRequest patientRequest){
        final Patient patient = this.patientRepository.findById(id).get();

        patient.setName(patientRequest.getName());
        patient.setGender(patientRequest.getGender());
        patient.setPhoneNumber(patientRequest.getPhoneNumber());
        patient.setEmail(patientRequest.getEmail());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        patient.setAddress(patientRequest.getAddress());
        patient.setNotes(patientRequest.getNotes());

        return this.patientRepository.save(patient);
    }

    public Patient create(PatientRequest patientRequest){
        Patient patient = new Patient();

        patient.setId(UUID.randomUUID().toString());
        patient.setName(patientRequest.getName());
        patient.setGender(patientRequest.getGender());
        patient.setPhoneNumber(patientRequest.getPhoneNumber());
        patient.setEmail(patientRequest.getEmail());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        patient.setAddress(patientRequest.getAddress());
        patient.setNotes(patientRequest.getNotes());

        return this.patientRepository.save(patient);
    }

    public void delete(String id){
        final Patient patient = this.patientRepository.findById(id).get();
        this.patientRepository.delete(patient);
    }

    public Iterable<Patient> findAll(){
        return this.patientRepository.findAll();
    }

    public Patient findOne(String id){
        return this.patientRepository.findById(id).get();
    }
}
