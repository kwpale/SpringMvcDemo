package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration for Services
 *
 * @version Revision History
 * <pre>
 * Author   Version     Date            Changes
 * pankplee  1.0         9/21/2017         Created
 * </pre>
 * @since 1.0
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = {com.demo.service.PackageMarker.class})
public class ServiceConfig {
}
