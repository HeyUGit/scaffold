package cn.bici.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Override
 * @version 1.0
 * @since 2019/11/11 9:47
 */

@Component
@Slf4j
public class MyFilter extends ZuulFilter {

    /**
     * pre: 路由之前
     * routing: 路由之时
     * post:路由之后
     * error:发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里写是否要过滤，也可以写逻辑判断来决定是否要过滤，这里直接写true表示永远过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。可判断该请求有没有后权限进行访问
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取请求上下文（容器），包含了请求数据包和session
        RequestContext ctx = RequestContext.getCurrentContext();
        //从请求上下文中获取请求
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));;
        Object accessTocken = request.getParameter("token");
        if(accessTocken == null){
            System.out.println("token is empty");;
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                return null;
            }

        }

        System.out.println("ok");
        return null;
    }
}
