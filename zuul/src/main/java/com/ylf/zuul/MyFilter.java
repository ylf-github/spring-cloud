package com.ylf.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;

/**
 * @Author: ylf
 * @Time: 2019/6/23 下午9:21
 * @Description:
 */
@Component
public class MyFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return "pre";   //pre 路由之前，routing 路由时，post 路由之后，error 发生错误时调用
    }

    @Override
    public int filterOrder() {
        return 0;      // Filter优先级
    }

    @Override
    public boolean shouldFilter() {
        return true;   //是否过滤，可写逻辑判断，true代表永远过滤
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        log.info(String.format("%s >>> %s",request.getMethod().toString(),request.getRequestURI().toString()));
        Object accessToken=request.getParameter("token");
        if(accessToken==null){
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                PrintWriter out=ctx.getResponse().getWriter();
                out.write("token is empty!");
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok!");
        ctx.setSendZuulResponse(false);
        try{
            PrintWriter out=ctx.getResponse().getWriter();
            out.write("ok!");
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
