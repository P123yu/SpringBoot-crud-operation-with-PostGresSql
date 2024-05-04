package com.job.controller;

import com.job.model.JobModel;
import com.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    //getAllJob
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllJob(){
        List<JobModel> allJob=jobService.getAllJob();
        if(!allJob.isEmpty()){
            return ResponseEntity.ok(allJob);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not fetched all job info");
        }
    }

    // getByJobId
    @GetMapping("/getById/{id}")
    public ResponseEntity<?>getByJobId(@PathVariable("id") Long jobId){
        JobModel job=jobService.getByJobId(jobId);
        if(job!=null){
            return ResponseEntity.ok(job);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not fetched job info based on given id");
        }
    }

    // createJob
    @PostMapping("/post")
    public ResponseEntity<?>createJob(@RequestBody JobModel jobModel){
        JobModel job=jobService.createJob(jobModel);
        if(job!=null){
            return ResponseEntity.ok("created successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not created");
        }
    }

    // updateJob
    @PutMapping("/modify/{id}")
    public ResponseEntity<?>updateJob(@PathVariable("id") Long jobId,@RequestBody JobModel jobModel){
        JobModel job=jobService.updateJob(jobId,jobModel);
        if(job!=null){
            return ResponseEntity.ok(job);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not updated");
        }
    }

    // deleteCompanyById
    @DeleteMapping("del/{id}")
    public ResponseEntity<?>deleteByJobId(@PathVariable("id") Long jobId){
        try{
            jobService.deleteJobById(jobId);
            return ResponseEntity.ok("job deleted successfully based on id");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not deleted job based on given id");
        }
    }



}
