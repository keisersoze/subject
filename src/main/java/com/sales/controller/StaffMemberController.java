package com.sales.controller;

import com.sales.service.StaffMemberService;
import com.sales.service.dto.StaffMemberDto;
import com.sales.service.dto.StaffMemberNoIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/staff-members")
public class StaffMemberController {

    private final StaffMemberService staffMemberService;

    @Autowired
    public StaffMemberController(StaffMemberService staffMemberService) {
        this.staffMemberService = staffMemberService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffMemberDto> getStaffMemberById(@PathVariable UUID id) {
        Optional<StaffMemberDto> staffMemberDto = staffMemberService.getStaffMemberById(id);
        return staffMemberDto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<StaffMemberDto> createStaffMember(@RequestBody StaffMemberNoIdDto staffMemberDto) {
        StaffMemberDto createdStaffMember = staffMemberService.createStaffMember(staffMemberDto);
        return new ResponseEntity<>(createdStaffMember, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffMemberDto> updateStaffMember(@PathVariable UUID id, @RequestBody StaffMemberNoIdDto staffMemberDto) {
        StaffMemberDto updatedStaffMember = staffMemberService.updateStaffMember(id, staffMemberDto);
        return updatedStaffMember != null ?
                new ResponseEntity<>(updatedStaffMember, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaffMember(@PathVariable UUID id) {
        staffMemberService.deleteStaffMember(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}