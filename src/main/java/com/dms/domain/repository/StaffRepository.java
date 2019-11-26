package com.dms.domain.repository;

import com.dms.domain.models.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface StaffRepository extends MongoRepository<Staff,String> {}
