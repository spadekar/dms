package com.dms.domain.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "patients")
public class Patient {
    @Id
    String id;
    String name;
    String gender;
    String dateOfBirth;
    String phoneNumber;
    String email;
    String address;
    String notes;
}
