package com.example.repositoryCourseBatchStd;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entityCourseBatchStd.Batch;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface BatchRepository extends JpaRepository<Batch, Integer> {

	/*
	@Query(value="select * from batch  where courseid=(select cid from course where cname=:cname)",nativeQuery = true)
	List<Batch> getBatches(@Param("cname")String cname);
	*/
	
	@Query(value="select * from Batch  where batch_Id=:batchno",nativeQuery = true)
	Batch getBatch(@Param("batchno")int batchno);
	
	@Query(value="SELECT * FROM Batch WHERE batch_start_date > CURDATE();",nativeQuery=true)
	List<Batch> getUpcomingBatch();
	
	@Query(value="SELECT * FROM Batch WHERE CURDATE() >= batch_start_date AND CURDATE() <= batch_end_date;",nativeQuery=true)
	List<Batch> getCurrentBatch();
	
	@Query(value="SELECT * FROM batch WHERE batch_name LIKE %:batchName%",nativeQuery = true)
	List<Batch> getBatchByName(@Param("batchName")String batchName);
	
	
	
	 @Query(value="SELECT * FROM Batch WHERE CURDATE() >= batch_end_date && CURDATE() >= batch_end_date;",nativeQuery=true)
	 List<Batch> getPastBatch();
	
	 
	 @Query(value="SELECT * FROM Batch WHERE course_id= :courseid",nativeQuery=true)
	 List<Batch> getBatchByCourse_Id(@Param("courseid") int cid);
	
}
