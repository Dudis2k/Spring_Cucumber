package com.Spring.Practice;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.hamcrest.Matchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class StepDefsIntegrationTest {

    @Mock
    private RestTemplate restTemplate;

    private ResponseEntity<String> results = null;
    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet("http://localhost:8080/version");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = (HttpStatus) results.getStatusCode();
        assertThat("status code is incorrect : " + results.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(results.getBody(), Matchers.greaterThan(version));
    }

    private void executeGet(String url) throws IOException{
        if(restTemplate==null){
            restTemplate = new RestTemplate();
        }
        results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
    }
}
