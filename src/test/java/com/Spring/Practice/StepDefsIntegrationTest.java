package com.Spring.Practice;

import com.Spring.Practice.dto.Member;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.hamcrest.Matchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

import static com.Spring.Practice.Config.Wiremock_Config.staticwiremockserver;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class StepDefsIntegrationTest {

    @DataTableType
    public Member memberEntry(Map<String, String> entry) {
        return new Member(
                Integer.parseInt(entry.get("id")),
                entry.get("name"),
                entry.get("member_status")
        );
    }
    @Mock
    private RestTemplate restTemplate;

    public static final WireMockServer wireMockServer = staticwiremockserver;

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

    @Given("^the client is ready to add a new member$")
    public void the_client_is_ready_to_add_a_member() throws Throwable {
        wireMockServer.stubFor(post(urlEqualTo("/add-member"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                ));
//                        .withBody("{\"id\":1,\"name\":\"John Doe\",\"member_status\":true}")));
        // This step can be used to set up any preconditions needed before adding a member
    }

    @When("^the client calls hits /add-member endpoint$")
    public void the_client_addition(Member member) throws Throwable {
        executePost("http://localhost:8081/add-member", member);
    }

    private void executeGet(String url) throws IOException{
        if(restTemplate==null){
            restTemplate = new RestTemplate();
        }
        results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
    }

    private void executePost(String url, Member member) throws IOException{
        if(restTemplate==null){
            restTemplate = new RestTemplate();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/json");
        headers.add("Content-Type","application/json");
        HttpEntity<Member> request = new HttpEntity<>(member,headers);
        results = restTemplate.exchange(url, HttpMethod.POST, null, String.class);
    }

}
