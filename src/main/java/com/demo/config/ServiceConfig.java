package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * //TODO change your class description
 *
 * @version Revision History
 * <pre>
 * Author   Version     Date            Changes
 * pankplee  1.0         9/21/2017         Created
 * </pre>
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackageClasses = {com.demo.service.PackageMarker.class})
public class ServiceConfig {
}
