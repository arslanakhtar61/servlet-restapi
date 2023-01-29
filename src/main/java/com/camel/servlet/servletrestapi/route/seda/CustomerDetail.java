package com.camel.servlet.servletrestapi.route.seda;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetail extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("seda:customerDetail")
                .log("receive get request for customerDetail")
                .transform(simple("customerDetail: id: ${header.id}", String.class))
        .end();
    }
}
