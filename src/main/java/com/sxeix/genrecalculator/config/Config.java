package com.sxeix.genrecalculator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Config for aspectJ
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.sxeix.genrecalculator")
public class Config {
}
