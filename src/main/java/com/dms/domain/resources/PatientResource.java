package com.dms.domain.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dms.domain.service.PatientService;
import com.dms.domain.vo.PatientRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dms.domain.models.Patient;


@RestController
@RequestMapping("/api/patient")
@Api(tags = "patient", description = "Patient API")
public class PatientResource {

    private final PatientService patientService;

    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find patient",notes = "Find the Patient by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Patient found"),
            @ApiResponse(code = 404,message = "Patient not found"),
    })
    public ResponseEntity<Patient> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(new Patient());
    }

    @GetMapping
    @ApiOperation(value = "List patients",notes = "List all patients")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Patient found"),
            @ApiResponse(code = 404,message = "Patient not found")
    })
    public List<Patient> findAll(){
        List<Patient> target = new ArrayList<>();
        this.patientService.findAll().forEach(target::add);
        return target;
    }

    @PostMapping
    @ApiOperation(value = "Create patient",notes = "It permits to create a new patient")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Patient created successfully"),
            @ApiResponse(code = 400,message = "Invalid request")
    })
    public ResponseEntity<Patient> newPatient(@RequestBody PatientRequest patient){
        return new ResponseEntity<>(this.patientService.create(patient), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove patient",notes = "It permits to remove a patient")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Patient removed successfully"),
            @ApiResponse(code = 404,message = "Patient not found")
    })
    public void removePatient(@PathVariable("id") String id){
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update patient",notes = "It permits to update a patient")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Patient update successfully"),
            @ApiResponse(code = 404,message = "Patient not found"),
            @ApiResponse(code = 400,message = "Invalid request")
    })
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") String id,PatientRequest patient){
        return new ResponseEntity<>(new Patient(), HttpStatus.OK);
    }

}
