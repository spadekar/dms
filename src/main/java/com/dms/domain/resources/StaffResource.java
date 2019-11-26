package com.dms.domain.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dms.domain.service.StaffService;
import com.dms.domain.vo.StaffRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dms.domain.models.Staff;


/**
 * @author claudioed on 29/10/17. Project cms
 */
@RestController
@RequestMapping("/api/staff")
@Api(tags = "staff", description = "Staff API")
public class StaffResource {

    private final StaffService staffService;

    public StaffResource(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find staff",notes = "Find the Staff by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Staff found"),
            @ApiResponse(code = 404,message = "Staff not found"),
    })
    public ResponseEntity<Staff> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(new Staff());
    }

    @GetMapping
    @ApiOperation(value = "List staff",notes = "List all staff")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Staff found"),
            @ApiResponse(code = 404,message = "Staff not found")
    })
    public List<Staff> findAll(){
        List<Staff> target = new ArrayList<>();
        this.staffService.findAll().forEach(target::add);
        return target;
    }

    @PostMapping
    @ApiOperation(value = "Create staff",notes = "It permits to create a new staff")
    @ApiResponses(value = {
      @ApiResponse(code = 201,message = "Staff created successfully"),
      @ApiResponse(code = 400,message = "Invalid request")
    })
    public ResponseEntity<Staff> newStaff(@RequestBody StaffRequest staff){
        return new ResponseEntity<>(this.staffService.create(staff), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove staff",notes = "It permits to remove a staff")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Staff removed successfully"),
            @ApiResponse(code = 404,message = "Staff not found")
    })
    public void removeStaff(@PathVariable("id") String id){
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update staff",notes = "It permits to update a staff")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Staff update successfully"),
            @ApiResponse(code = 404,message = "Staff not found"),
            @ApiResponse(code = 400,message = "Invalid request")
    })
    public ResponseEntity<Staff> updateStaff(@PathVariable("id") String id,StaffRequest staff){
        return new ResponseEntity<>(new Staff(), HttpStatus.OK);
    }

}
