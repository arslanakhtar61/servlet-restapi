package com.camel.servlet.servletrestapi.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RestConfig extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        restConfiguration()
//                .component("servlet")
//                .bindingMode(RestBindingMode.json)
//                .dataFormatProperty("prettyPrint", "true")
//                .enableCORS(true)
//                .contextPath("/servlet-restapi/v1")
//                .apiComponent("swagger ")
//        ;
    }
}
