package com.ylf.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: ylf
 * @Time: 2019/6/26 下午2:37
 * @Description:
 */
@Component
public class RequestTimeFilter implements GatewayFilter,Ordered{
    private static final Log log = LogFactory.getLog(GatewayFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("requestBeginTime",System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            Long startTime=exchange.getAttribute("requestBeginTime");
            if(startTime!=null){
                log.info(exchange.getRequest().getURI().getRawPath()+":"+(System.currentTimeMillis()-startTime)+"ms");
            }
        }));
    }

    @Override      //设置过滤器优先级
    public int getOrder() {
        return 0;
    }


}
