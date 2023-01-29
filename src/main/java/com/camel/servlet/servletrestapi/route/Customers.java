package com.camel.servlet.servletrestapi.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class Customers extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        rest("/customers/")
                .produces(MediaType.APPLICATION_JSON_VALUE)
            .get("/{id}")
                .to("seda:customerDetail")
            .get("/{id}/orders")
                .param().name("verbose").type(RestParamType.query).defaultValue("false").required(false).description("Verbose order details").endParam()
                .param().name("indicator").type(RestParamType.header).defaultValue("disabled").required(false).description("Feature Enabled Indicator").endParam()
                .to("seda:customerOrders")
            .post("/neworder")
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .param()
                    .name("newOrderDto")
                    .type(RestParamType.body)
                    .required(true)
                    .description("new order request")
                .endParam()
                .to("seda:customerNewOrder")
        ;
    }
}
