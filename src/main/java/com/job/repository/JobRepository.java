package com.job.repository;

import com.job.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobModel,Long> {
}
