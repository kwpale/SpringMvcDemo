package com.demo.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * The web configuration file
 *
 * @version Revision History
 * <pre>
 * Author   Version     Date            Changes
 * pankplee  1.0         9/20/2017         Created
 * </pre>
 * @since 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {com.demo.web.controller.HomeController.class})
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * {@inheritDoc}
     * <p>This implementation is empty.
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        resolver.setRequestContextAttribute("requestContext");
        return resolver;
    }
}
