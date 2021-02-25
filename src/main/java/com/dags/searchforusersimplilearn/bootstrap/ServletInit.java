package com.dags.searchforusersimplilearn.bootstrap;

import com.dags.searchforusersimplilearn.SearchForUserSimplilearnApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInit extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
        return springApplicationBuilder.sources(SearchForUserSimplilearnApplication.class);
    }
}
