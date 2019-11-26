package com.dms.domain.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "staffs")
public class Staff {
    @Id
    String id;
    String name;
    String dayOfDuty;
    String phoneNumber;
    String email;
}
