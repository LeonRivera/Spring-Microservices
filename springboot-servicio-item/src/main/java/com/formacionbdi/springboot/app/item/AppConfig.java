package com.formacionbdi.springboot.app.item;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@Configuration
public class AppConfig {
    
    @Bean("clienteRest")
    @LoadBalanced
    public RestTemplate registrarRestTemplate(){
        return new RestTemplate();
    }


    // Themes
    // Timeout the timeout ocurrs first than the slowcall config
    // SlowCalls register each slow call and then of limited calls throw CB

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer(){
        return factory -> factory.configureDefault(id -> {
            //al cb by default if we no specify
            return new Resilience4JConfigBuilder(id)
            .circuitBreakerConfig(CircuitBreakerConfig.custom()
                // quantity of errors before enter CB
                .slidingWindowSize(5)
                // failure rate 50%
                .failureRateThreshold(50)
                // Duration of the open state 
                .waitDurationInOpenState(Duration.ofSeconds(10L))
                .permittedNumberOfCallsInHalfOpenState(5)
                // Percentage thrwshol of slowCall
                .slowCallRateThreshold(50)
                // max time that a request is considerated slow call
                .slowCallDurationThreshold(Duration.ofSeconds(2L))
                .build())
            // .timeLimiterConfig(TimeLimiterConfig.ofDefaults())
            // timeout duration of each request, with 5 timeout exc(slidingWindows) OPEN the Circuit Breaker
            // and the duration without requests is 10 seconds 
            .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(6l)).build())
            .build();
        });
    }
}
