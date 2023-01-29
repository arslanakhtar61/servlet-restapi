package com.camel.servlet.servletrestapi.route.seda;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrders extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("seda:customerOrders")
                .log("receive get request for customerOrders")
                .transform(simple("customerOrders -> id: ${header.id}, verbose: ${header.verbose}, indicator: ${header.indicator}", String.class))
        .end();
    }
}
