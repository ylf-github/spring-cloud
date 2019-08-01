//package com.ylf.gateway;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @Author: ylf
// * @Time: 2019/6/26 下午3:39
// * @Description:
// */
//@Component
//public class TokenFilter implements GlobalFilter,Ordered{
//
//    Logger log= LoggerFactory.getLogger(TokenFilter.class);
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String token=exchange.getRequest().getQueryParams().getFirst("token");
//        if(token==null||!token.equals("123")){
//             log.info("token is not correct");
//             exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//             return exchange.getResponse().setComplete();
//        }
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
