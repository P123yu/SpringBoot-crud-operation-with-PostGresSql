package com.job.service;


import com.job.model.JobModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    // getAllJob
    List<JobModel> getAllJob();

    // getJobById
    JobModel getByJobId(Long jobId);

    // createJob
    JobModel createJob(JobModel jobModel);

    // updateJob
    JobModel updateJob(Long jobId,JobModel jobModel);

    // deleteJobById
    void deleteJobById(Long jobId);


}
