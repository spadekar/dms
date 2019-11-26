package com.dms.domain.service;

import com.dms.domain.models.Appointment;
import com.dms.domain.repository.AppointmentRepository;
import com.dms.domain.vo.AppointmentRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment update(String id, AppointmentRequest appointmentRequest){
        final Appointment appointment = this.appointmentRepository.findById(id).get();
        appointment.setDateOfAppointment(appointmentRequest.getDateOfAppointment());
        appointment.setTimeOfAppointment(appointmentRequest.getTimeOfAppointment());
        appointment.setOperatingStaff(appointmentRequest.getOperatingStaff());
        appointment.setCaseDetails(appointmentRequest.getCaseDetails());
        appointment.setTreatment(appointmentRequest.getTreatment());

        return this.appointmentRepository.save(appointment);
    }

    public Appointment create(AppointmentRequest appointmentRequest){
        Appointment appointment = new Appointment();

        appointment.setId(UUID.randomUUID().toString());
        appointment.setDateOfAppointment(appointmentRequest.getDateOfAppointment());
        appointment.setTimeOfAppointment(appointmentRequest.getTimeOfAppointment());
        appointment.setOperatingStaff(appointmentRequest.getOperatingStaff());
        appointment.setCaseDetails(appointmentRequest.getCaseDetails());
        appointment.setTreatment(appointmentRequest.getTreatment());

        return this.appointmentRepository.save(appointment);
    }

    public void delete(String id){
        final Appointment appointment = this.appointmentRepository.findById(id).get();
        this.appointmentRepository.delete(appointment);
    }

    public Iterable<Appointment> findAll(){
        return this.appointmentRepository.findAll();
    }

    public Appointment findOne(String id){
        return this.appointmentRepository.findById(id).get();
    }
}
