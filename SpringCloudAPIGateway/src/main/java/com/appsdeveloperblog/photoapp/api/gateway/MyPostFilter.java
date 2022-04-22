package com.appsdeveloperblog.photoapp.api.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyPostFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            String requestPath = exchange.getRequest().getPath().toString();
            log.info("POSTFILTER -----> Request path = {}", requestPath);
            HttpHeaders headers = exchange.getRequest().getHeaders();
            headers.forEach((k, v) -> {
                System.out.println(k + " : " + v);
            });
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
