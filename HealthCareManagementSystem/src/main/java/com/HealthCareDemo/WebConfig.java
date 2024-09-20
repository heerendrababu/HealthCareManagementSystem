package com.HealthCareDemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.HealthCareDemo.Controller"})//ComponentScan scans the controller
public class WebConfig
{

}
