package com.vyawpiy.spring_boot_rest.service;

import com.vyawpiy.spring_boot_rest.model.JobPost;
import com.vyawpiy.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAllByOrderByPostIdAsc();
    }

    public JobPost getJobPost(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(
                        101,
                        "Software Engineer",
                        "Responsible for developing and maintaining software applications.",
                        3,
                        Arrays.asList("Java", "Spring", "SpringBoot", "Hibernate")
                ),
                new JobPost(
                        102,
                        "Frontend Developer",
                        "Develop user-facing features for web applications.",
                        2,
                        Arrays.asList("JavaScript", "React", "CSS")
                ),
                new JobPost(
                        103,
                        "Backend Developer",
                        "Build and maintain the server-side of web applications.",
                        4,
                        Arrays.asList("Python", "Django", "REST APIs")
                ),
                new JobPost(
                        104,
                        "Full Stack Developer",
                        "Work on both frontend and backend of web applications.",
                        5,
                        Arrays.asList("JavaScript", "Node.js", "Express", "MongoDB")
                ),
                new JobPost(
                        105,
                        "DevOps Engineer",
                        "Manage and automate development and operations workflows.",
                        3,
                        Arrays.asList("Docker", "Kubernetes", "Jenkins")
                )
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> searchByKeyword(String keyword) {
        return repo.findByPostProfileContainingOrPostDescriptionContaining(keyword, keyword);
    }
}
