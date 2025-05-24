package com.prajeshav.spring_mcp.config;

import com.prajeshav.spring_mcp.service.CourseService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by Prajesh AV
 * Date: 24/5/2025
 */

@Configuration
public class MCPCOnfig {

    /**
     * Creates a list of tool callbacks for the Course Service.
     * This bean configures the integration between Spring AI and the Course Service,
     * enabling the service's methods annotated with @Tool to be accessible.
     *
     * @param courseService the course service instance to create callbacks from
     * @return a list of tool callbacks wrapping the course service methods
     */
    @Bean
    public List<ToolCallback> prajeshTools(CourseService courseService) {
        return List.of(ToolCallbacks.from(courseService));
    }
}