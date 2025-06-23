package com.Spring.Practice.Config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class Wiremock_Config {
    public static final int mocker_port = 8081;
    public static final WireMockConfiguration wireMockConfiguration = WireMockConfiguration.wireMockConfig()
            .port(mocker_port);
//            .extensions(new ExampleTransformer()); // Add your custom transformer here
    public static final WireMockServer staticwiremockserver = new WireMockServer(wireMockConfiguration);
    static {
        WireMock.configureFor("localhost", mocker_port);
        staticwiremockserver.start();
    }
}

