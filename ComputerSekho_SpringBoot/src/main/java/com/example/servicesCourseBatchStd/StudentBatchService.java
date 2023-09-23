package com.example.servicesCourseBatchStd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entityCourseBatchStd.Batch;
import com.example.entityCourseBatchStd.Student;
import com.example.entityCourseBatchStd.StudentBatchDto;
import com.example.repositoryCourseBatchStd.BatchRepository;
import com.example.repositoryCourseBatchStd.StudentRepository;
import java.util.*;

//StudentBatchService.java
@Service
public class StudentBatchService {

	    @Autowired
	    private StudentRepository studentRepository;

	    

	    public Object[] findStudentAndBatchInfoByEnquiryId(int enquiryId){
	    	Object[] result = studentRepository.findStudentAndBatchInfoByEnquiryId(enquiryId);
	    	return result;


	        
	    }
	}


