package com.example.repositoryStaffEnquiry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entityStaffEnquiry.Staff;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface StaffRepository extends JpaRepository<Staff,Integer>{
	 
	@Modifying
	@Query("update Staff s set s.staff_name = :name, s.photo_url= :photo, s.staff_mobile = :mobile, s.staff_email = :email, s.staff_username = :uname, s.staff_password = :pass, s.staff_role = :role, s.staff_isactive = :status where s.staff_id = :id" )
	void updateStaff(@Param("name") String name, @Param("photo") String photo,@Param("mobile") String mobile, @Param("email") String email, @Param("uname") String uname, @Param("pass") String pass, @Param("role") String role, @Param("status") boolean staus,@Param("id") int id);
	
	@Query(value="SELECT * FROM Staff s WHERE s.staff_username = :username",nativeQuery=true)
    Optional<Staff> findByUsername(@Param("username") String username);
	
	}

