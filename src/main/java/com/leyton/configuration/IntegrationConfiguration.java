
package com.leyton.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.client.RestTemplate;

import com.leyton.domain.GreetingResponse;

@Configuration
@EnableIntegration
public class IntegrationConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean(
            name = {
                "requestChannel"
            })
    public MessageChannel requestChannel() {
        return MessageChannels.direct("requestChannel").get();
    }

    @Bean(
            name = {
                "filterChannel"
            })
    public MessageChannel filterChannel() {
        return MessageChannels.direct("filterChannel").get();
    }

    @Bean(
            name = {
                "evenChannel"
            })
    public MessageChannel evenChannel() {
        return MessageChannels.direct("evenChannel").get();
    }

    @Bean(
            name = {
                "oddChannel"
            })
    public MessageChannel oddChannel() {
        return MessageChannels.direct("oddChannel").get();
    }

    @Bean(
            name = {
                "endChannel"
            })
    public MessageChannel endChannel() {
        return MessageChannels.direct("endChannel").get();
    }

    @Bean(
            name = {
                "httpRequestChannel"
            })
    public MessageChannel httpRequestChannel() {
        return MessageChannels.direct("httpRequestChannel").get();
    }

    @Bean(
            name = {
                "httpMicroserviceOne"
            })
    public MessageChannel httpMicroserviceOne() {
        return MessageChannels.direct("httpMicroserviceOne").get();
    }

    public IntegrationFlow basicFlow(RestTemplate restTemplate) {
        return IntegrationFlows.from(httpMicroserviceOne())
                .handle(Http.outboundGateway("http://microservice-one/greeting/Will", restTemplate)
                        .httpMethod(HttpMethod.GET).expectedResponseType(GreetingResponse.class))
                .get();
    }
}
