package com.sales.subject.service;

import com.sales.subject.model.StaffMember;
import com.sales.subject.repository.StaffMemberRepository;
import com.sales.subject.service.dto.StaffMemberDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StaffMemberService {

    private final StaffMemberRepository staffMemberRepository;

    @Autowired
    public StaffMemberService(StaffMemberRepository staffMemberRepository) {
        this.staffMemberRepository = staffMemberRepository;
    }

    public Optional<StaffMemberDto> getStaffMemberById(UUID id) {
        return staffMemberRepository.findById(id)
                .map(this::convertToDto);
    }

    public StaffMemberDto createStaffMember(StaffMemberDto staffMemberDto) {
        StaffMember staffMember = convertToEntity(staffMemberDto);
        StaffMember createdStaffMember = staffMemberRepository.save(staffMember);
        return convertToDto(createdStaffMember);
    }

    public StaffMemberDto updateStaffMember(UUID id, StaffMemberDto staffMemberDto) {
        Optional<StaffMember> optionalStaffMember = staffMemberRepository.findById(id);

        if (optionalStaffMember.isPresent()) {
            StaffMember existingStaffMember = optionalStaffMember.get();
            BeanUtils.copyProperties(staffMemberDto, existingStaffMember);
            StaffMember updatedStaffMember = staffMemberRepository.save(existingStaffMember);
            return convertToDto(updatedStaffMember);
        } else {
            // Handle staff member not found exception
            return null;
        }
    }

    public void deleteStaffMember(UUID id) {
        staffMemberRepository.deleteById(id);
    }

    private StaffMemberDto convertToDto(StaffMember staffMember) {
        StaffMemberDto staffMemberDto = new StaffMemberDto();
        BeanUtils.copyProperties(staffMember, staffMemberDto);
        return staffMemberDto;
    }

    private StaffMember convertToEntity(StaffMemberDto staffMemberDto) {
        StaffMember staffMember = new StaffMember();
        BeanUtils.copyProperties(staffMemberDto, staffMember);
        return staffMember;
    }

}
