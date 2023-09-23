package com.example.repositoryPlacement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entityPlacement.Placement;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PlacementRepository extends JpaRepository<Placement,Integer>{

	/*@Query(value="select * from Student  where student_Id in(select sid from phone where phone_number=:phonenumber)",nativeQuery = true)
	Student getStudent(@Param("phonenumber")String phonenumber);*/
	
	@Modifying
    @Query(value="UPDATE placement p SET p.coursename = :course, p.batchid = :batch, p.placedstudents = :pst, p.total_student = :tst WHERE p.placemetid = :id",nativeQuery=true)
    void update(@Param("course") String course, @Param("batch") int batch, @Param("pst") int pst, @Param("tst") int tst, @Param("id") int id);}

