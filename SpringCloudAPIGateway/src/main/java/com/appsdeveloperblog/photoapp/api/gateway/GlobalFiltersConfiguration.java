package com.appsdeveloperblog.photoapp.api.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class GlobalFiltersConfiguration {

    @Order(1)
    @Bean
    public GlobalFilter secondPreFilter() {
        return (exchange, chain) -> {
            log.info("2 PREFILTER");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("3 POSTFILTER");
            }));
        };
    }

    @Order(2)
    @Bean
    public GlobalFilter thirdPreFilter() {
        return (exchange, chain) -> {
            log.info("3 PREFILTER");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("2 POSTFILTER");
            }));
        };
    }

    @Order(3)
    @Bean
    public GlobalFilter fourthPreFilter() {
        return (exchange, chain) -> {
            log.info("4 PREFILTER");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("1 POSTFILTER");
            }));
        };
    }

}
