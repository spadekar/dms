package com.dms.domain.service;

import com.dms.domain.models.Staff;
import com.dms.domain.repository.StaffRepository;
import com.dms.domain.vo.StaffRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff update(String id, StaffRequest staffRequest){
        final Staff staff = this.staffRepository.findById(id).get();

        staff.setName(staffRequest.getName());
        staff.setDayOfDuty(staffRequest.getDayOfDuty());
        staff.setPhoneNumber(staffRequest.getPhoneNumber());
        staff.setEmail(staffRequest.getEmail());

        return this.staffRepository.save(staff);
    }

    public Staff create(StaffRequest staffRequest){
        Staff staff = new Staff();

        staff.setId(UUID.randomUUID().toString());
        staff.setName(staffRequest.getName());
        staff.setDayOfDuty(staffRequest.getDayOfDuty());
        staff.setPhoneNumber(staffRequest.getPhoneNumber());
        staff.setEmail(staffRequest.getEmail());

        return this.staffRepository.save(staff);
    }

    public void delete(String id){
        final Staff staff = this.staffRepository.findById(id).get();
        this.staffRepository.delete(staff);
    }

    public Iterable<Staff> findAll(){
        return this.staffRepository.findAll();
    }

    public Staff findOne(String id){
        return this.staffRepository.findById(id).get();
    }
}
