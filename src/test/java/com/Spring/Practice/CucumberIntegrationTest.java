package com.Spring.Practice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.suite.api.*;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import static io.cucumber.core.options.Constants.*;
import static io.cucumber.junit.platform.engine.Constants.JUNIT_PLATFORM_NAMING_STRATEGY_PROPERTY_NAME;

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources", glue = "com.Spring.Practice", monochrome = true)
@Suite
@IncludeEngines("cucumber")
@SelectPackages("io.cucumber.skeleton")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.Spring.Practice")
public class CucumberIntegrationTest {
}