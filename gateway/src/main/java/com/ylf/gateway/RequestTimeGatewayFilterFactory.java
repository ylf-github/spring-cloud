package com.ylf.gateway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @Author: ylf
 * @Time: 2019/6/26 下午4:53
 * @Description:
 */
@Component
public class RequestTimeGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    private static final Log log = LogFactory.getLog(RequestTimeGatewayFilterFactory.class);
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange, chain) -> {
            exchange.getAttributes().put("startTime", System.currentTimeMillis());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute("startTime");
                        if (startTime != null) {
                            StringBuilder sb = new StringBuilder(exchange.getRequest().getURI().getRawPath())
                                    .append(": ")
                                    .append(System.currentTimeMillis() - startTime)
                                    .append("ms");
                                    sb.append(" config:").append(config.getName()+" "+config.getValue());
                            log.info(sb.toString());
                        }
                    })
            );
        };
    }

}
