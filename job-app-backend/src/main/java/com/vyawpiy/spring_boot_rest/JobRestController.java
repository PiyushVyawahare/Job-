package com.vyawpiy.spring_boot_rest;

import com.vyawpiy.spring_boot_rest.model.JobPost;
import com.vyawpiy.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(path="jobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJobPost(@PathVariable int postId) {
        return service.getJobPost(postId);
    }

    @GetMapping("jobPost/search/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword) {
        return service.searchByKeyword(keyword);
    }

    @PostMapping(path="jobPost", consumes={"application/json"})
    public JobPost addJobPost(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJobPost(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJobPost(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJobPost(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJobPost(@PathVariable int postId) {
        service.deleteJob(postId);
        return "Deleted!!!!";
    }

    @GetMapping("load")
    public String loadData() {
        service.load();
        return "success";
    }

}
