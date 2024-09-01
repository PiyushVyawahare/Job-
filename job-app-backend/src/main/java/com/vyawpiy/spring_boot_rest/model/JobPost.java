package com.vyawpiy.spring_boot_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Controller
@Entity
public class JobPost {
    @Id
    private int postId;
    private String postProfile;
    private String postDescription;
    private int requiredExperience;
    private List<String> techStack;
}
