package com.example.repositoryCourseBatchStd;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entityCourseBatchStd.Student;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> 
{
	
	@Query(value = "select * from student p where p.student_name=:name", nativeQuery = true)
	List<Student> listtype(@Param("name") String name);


	@Modifying
	@Query("UPDATE Student s SET s.student_name = :name, s.student_address = :add, s.student_gender = :gender, s.student_dob = :date, s.student_qualification = :qual, s.student_mobile = :mob WHERE s.student_id = :id")
	void updateStudentdata(@Param("name") String name, @Param("add") String add, @Param("gender") String gender,
	        @Param("date") Date date, @Param("qual") String qual, @Param("mob") String mob, @Param("id") int id);

	@Modifying
	@Query(value = "SELECT s.student_id, s.student_name, b.batch_fees " +
            "FROM Student s " +
            "INNER JOIN Batch b ON s.batch_id = b.batch_id " +
            "WHERE s.enquiry_id = :id", nativeQuery = true)
    Object[] findStudentAndBatchInfoByEnquiryId(@Param("id") int id);
	
	@Modifying
	@Query(value = "select * from student p where p.enquiry_id= :id", nativeQuery = true)
	List<Student> getbyenquiry_id(@Param("id") int id);

}