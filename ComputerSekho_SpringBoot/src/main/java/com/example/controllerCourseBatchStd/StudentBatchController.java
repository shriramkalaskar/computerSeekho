package com.example.controllerCourseBatchStd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entityCourseBatchStd.StudentBatchDto;
import com.example.servicesCourseBatchStd.StudentBatchService;

@CrossOrigin("*")
@RestController
public class StudentBatchController {

 @Autowired
 private StudentBatchService studentBatchService;

 @GetMapping("/api/student-batch-info/{enquiryId}")
 public ResponseEntity<Object[]> getStudentBatchInfoByEnquiryId(@PathVariable int enquiryId) {
     Object[] studentBatchInfo = studentBatchService.findStudentAndBatchInfoByEnquiryId(enquiryId);

     if (studentBatchInfo != null && studentBatchInfo.length == 3) {
         return ResponseEntity.ok(studentBatchInfo);
     } else {
         return ResponseEntity.notFound().build();
     }
 }

}

