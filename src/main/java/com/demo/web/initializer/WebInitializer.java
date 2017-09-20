package com.demo.web.initializer;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * The web initializer, used to replace web.xml
 *
 * @version Revision History
 * <pre>
 * Author   Version     Date            Changes
 * pankplee  1.0         9/20/2017         Created
 * </pre>
 * @since 1.0
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {
            com.demo.config.RootConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {
                com.demo.web.config.WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/"
        };
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter charFilter = new CharacterEncodingFilter();
        charFilter.setEncoding("UTF-8");
        charFilter.setForceEncoding(true);
        return new Filter[] {
                new HiddenHttpMethodFilter(), charFilter
        };
    }
}
