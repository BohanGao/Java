package com.bohangao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.bohangao.annotation"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
