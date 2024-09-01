package com.vyawpiy.spring_boot_rest.repo;

import com.vyawpiy.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescriptionContaining(String profileKeyword, String descKeyword);

    List<JobPost> findAllByOrderByPostIdAsc();

//    private List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//            new JobPost(
//                    101,
//                    "Software Engineer",
//                    "Responsible for developing and maintaining software applications.",
//                    3,
//                    Arrays.asList("Java", "Spring", "SpringBoot", "Hibernate")
//            ),
//            new JobPost(
//                    102,
//                    "Frontend Developer",
//                    "Develop user-facing features for web applications.",
//                    2,
//                    Arrays.asList("JavaScript", "React", "CSS")
//            ),
//            new JobPost(
//                    103,
//                    "Backend Developer",
//                    "Build and maintain the server-side of web applications.",
//                    4,
//                    Arrays.asList("Python", "Django", "REST APIs")
//            ),
//            new JobPost(
//                    104,
//                    "Full Stack Developer",
//                    "Work on both frontend and backend of web applications.",
//                    5,
//                    Arrays.asList("JavaScript", "Node.js", "Express", "MongoDB")
//            ),
//            new JobPost(
//                    105,
//                    "DevOps Engineer",
//                    "Manage and automate development and operations workflows.",
//                    3,
//                    Arrays.asList("Docker", "Kubernetes", "Jenkins")
//            )
//    ));
//
//    public void addJob(JobPost jobPost) {
//        jobs.add(jobPost);
//    }
//
//    public List<JobPost> getAllJobs() {
//        return jobs;
//    }
//
//    public JobPost getJobPost(int postId) {
//        for(JobPost job: jobs) {
//            if(job.getPostId() == postId) return job;
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost jobPost) {
//        for(JobPost jobPost1: jobs) {
//            if(jobPost1.getPostId() == jobPost.getPostId()) {
//                jobPost1.setPostProfile(jobPost.getPostProfile());
//                jobPost1.setPostDescription(jobPost.getPostDescription());
//                jobPost1.setRequiredExperience(jobPost.getRequiredExperience());
//                jobPost1.setTechStack(jobPost.getTechStack());
//            }
//        }
//    }
//
//    public void deleteJob(int postId) {
//        for(JobPost jobPost: jobs) {
//            if(jobPost.getPostId() == postId) {
//                jobs.remove(jobPost);
//            }
//        }
//    }
}
