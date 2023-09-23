package com.example.repositoryStaffEnquiry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entityStaffEnquiry.*;

public interface FollowupRepository extends JpaRepository<Followup, Integer> {

	@Query(value="select * from enquiry",nativeQuery=true)
	public List<Enquiry> getAll();
	
	@Query(value="select * from enquiry where staff_id=:staff_id",nativeQuery = true)
	public List<Enquiry> getBystaffId(@Param("staff_id")int staffid);
}
