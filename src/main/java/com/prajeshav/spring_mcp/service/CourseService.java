package com.prajeshav.spring_mcp.service;

import com.prajeshav.spring_mcp.model.Course;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.prajeshav.spring_mcp.constants.MCPConstants.PAV_GET_COURSE;
import static com.prajeshav.spring_mcp.constants.MCPConstants.PAV_GET_COURSES;


/**
 * Created by Prajesh AV
 * Date: 24/5/2025
 */

@Service
@Slf4j
public class CourseService {
    private List<Course> courses = new ArrayList<>();

    @Tool(name = PAV_GET_COURSES, description = "Retrieves all available courses")
    public List<Course> getCourses() {
        return courses;
    }

    @Tool(name = PAV_GET_COURSE, description = "Retrieves a single course by title")
    public Course getCourse(String title) {
        return courses.stream().filter(course -> course.title().equals(title)).findFirst().orElse(null);
    }

    @PostConstruct
    public void init() {
        log.info(">>> Loaded {} courses", 2);
        courses.addAll(List.of(new Course("Spring Boot Fundamentals", "https://example.com/spring-boot"), new Course("Java Programming Masterclass", "https://example.com/java-master")));
    }
}