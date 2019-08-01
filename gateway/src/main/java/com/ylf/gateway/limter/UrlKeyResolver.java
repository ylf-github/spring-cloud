package com.ylf.gateway.limter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: ylf
 * @Time: 2019/6/27 上午10:29
 * @Description:
 */
@Component
public class UrlKeyResolver implements KeyResolver{
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getURI().getPath());
    }
}
