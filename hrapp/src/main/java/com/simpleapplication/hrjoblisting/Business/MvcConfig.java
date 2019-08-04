package com.simpleapplication.hrjoblisting.Business;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/joblist").setViewName("joblist");
        registry.addViewController("/joblistdetail").setViewName("joblistdetail");
        registry.addViewController("/newjoblist").setViewName("newjoblist");
        registry.addViewController("/listing").setViewName("listing");
        registry.addViewController("/editjoblist").setViewName("editjoblist");
        registry.addViewController("/fileud").setViewName("fileud");
        registry.addViewController("/jobapplication").setViewName("jobapplication");
        registry.addViewController("/application").setViewName("application");
        registry.addViewController("/applicationlist").setViewName("applicationlist");
        registry.addViewController("/applicationlistbyjoblist").setViewName("applicationlistbyjoblist");
    }

}