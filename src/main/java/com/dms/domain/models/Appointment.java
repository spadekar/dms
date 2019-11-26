package com.dms.domain.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "appointments")
public class Appointment {
    @Id
    String id;
    String dateOfAppointment;
    String timeOfAppointment;
    String operatingStaff;
    String caseDetails;
    String treatment;
}
