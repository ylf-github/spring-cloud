//package com.ylf.gateway;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: ylf
// * @Time: 2019/6/26 下午3:22
// * @Description:全局过滤器，所有路由中都起作用
// */
//@Component
//public class GetRoute {
//    @Bean  //把我们的过滤器注入到route中
//    public RouteLocator customerRouterLocator(RouteLocatorBuilder builder){
//        return  builder.routes()
//                .route(r->r.path("/hi").
//                        filters(f->f.filter(new RequestTimeFilter()).
//                                addRequestHeader("hello","world"))
//                        .uri("http://localhost:8762/").order(0)
//                        .id("customer_filter_route")
//                ).build();
//    }
//}
