package com.dms.domain.vo;

import lombok.Data;

@Data
public class PatientRequest {
    String name;
    String gender;
    String dateOfBirth;
    String phoneNumber;
    String email;
    String address;
    String notes;
}
