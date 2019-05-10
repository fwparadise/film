package com.example.demo.config;
import com.example.demo.filter.corsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class filterConfig {
    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean<corsFilter> registrationBean = new FilterRegistrationBean<>();
        corsFilter filter = new corsFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }
}
