package com.dms.domain.vo;

import lombok.Data;

@Data
public class AppointmentRequest {
    String dateOfAppointment;
    String timeOfAppointment;
    String operatingStaff;
    String caseDetails;
    String treatment;
}
