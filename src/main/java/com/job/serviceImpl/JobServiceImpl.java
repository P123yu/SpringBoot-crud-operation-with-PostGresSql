package com.job.serviceImpl;
import com.job.model.JobModel;
import com.job.repository.JobRepository;
import com.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<JobModel> getAllJob() {
        List<JobModel>allJob=jobRepository.findAll();
        return allJob;
    }

    @Override
    public JobModel getByJobId(Long jobId) {
        JobModel job =jobRepository.findById(jobId).orElse(null);
        return job;
    }

    @Override
    public JobModel createJob(JobModel jobModel) {
        JobModel job=jobRepository.save(jobModel);
        return job;
    }

    @Override
    public JobModel updateJob(Long jobId, JobModel jobModel) {
        boolean result=jobRepository.existsById(jobId);
        if(result){
            jobModel.setJobId(jobId);
            JobModel job=jobRepository.save(jobModel);
            return job;
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteJobById(Long jobId) {
        boolean result=jobRepository.existsById(jobId);
        if(result){
            jobRepository.deleteById(jobId);
        }
        else{
            throw new NoSuchElementException();
        }
    }
}
