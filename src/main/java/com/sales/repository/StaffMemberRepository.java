package com.sales.repository;

import com.sales.model.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaffMemberRepository extends JpaRepository<StaffMember, UUID> {

}
