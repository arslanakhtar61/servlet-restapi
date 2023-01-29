package com.camel.servlet.servletrestapi.route.seda;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerNewOrder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("seda:customerNewOrder")
                .log("receive post request for customerNewOrder")
                .transform(simple("customerNewOrder: ${body}", String.class))
        .end();
    }
}
