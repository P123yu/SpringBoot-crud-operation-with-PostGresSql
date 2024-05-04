package com.job.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class JobModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String jobTitle;
    private String jobLocation;
    private String salary;

}
