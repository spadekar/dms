package com.dms.domain.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dms.domain.service.AppointmentService;
import com.dms.domain.vo.AppointmentRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dms.domain.models.Appointment;


@RestController
@RequestMapping("/api/appointment")
@Api(tags = "appointment", description = "Appointment API")
public class AppointmentResource {

    private final AppointmentService appointmentService;

    public AppointmentResource(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find appointment",notes = "Find the Appointment by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Appointment found"),
            @ApiResponse(code = 404,message = "Appointment not found"),
    })
    public ResponseEntity<Appointment> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(new Appointment());
    }

    @GetMapping
    @ApiOperation(value = "List Appointments",notes = "List all Appointments")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Appointment found"),
            @ApiResponse(code = 404,message = "Appointment not found")
    })
    public List<Appointment> findAll(){
        List<Appointment> target = new ArrayList<>();
        this.appointmentService.findAll().forEach(target::add);
        return target;
    }

    @PostMapping
    @ApiOperation(value = "Create Appointment",notes = "It permits to create a new Appointment")
    @ApiResponses(value = {
      @ApiResponse(code = 201,message = "Appointment created successfully"),
      @ApiResponse(code = 400,message = "Invalid request")
    })
    public ResponseEntity<Appointment> newAppointment(@RequestBody AppointmentRequest appointment){
        return new ResponseEntity<>(this.appointmentService.create(appointment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove Appointment",notes = "It permits to remove a appointment")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Appointment removed successfully"),
            @ApiResponse(code = 404,message = "Appointment not found")
    })
    public void removeAppointment(@PathVariable("id") String id){
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") String id,AppointmentRequest appointment){
        return new ResponseEntity<>(new Appointment(), HttpStatus.OK);
    }

}
