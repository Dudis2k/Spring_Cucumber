package com.Spring.Practice.Config;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
//import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformerV2;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;

//public class ExampleTransformer implements ResponseDefinitionTransformerV2 {
//
//    @Override
//    public ResponseDefinition transform(ServeEvent serveEvent) {
//        return new ResponseDefinitionBuilder()
//                .withHeader("MyHeader", "Transformed")
//                .withStatus(200)
//                .withBody("Transformed body")
//                .build();
//    }
//
//    @Override
//    public String getName() {
//        return "example";
//    }
//}