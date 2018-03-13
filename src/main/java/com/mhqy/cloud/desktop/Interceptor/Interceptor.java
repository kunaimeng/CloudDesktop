package com.mhqy.cloud.desktop.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @PACKAGE_NAME:com.mhqy.cloud.desktop.Interceptor
 * @ClassName: Interceptor
 * @Description:登录窗台拦截
 * @author: peiqiankun
 * @date: 2018-03-13 9:43
 * @mail: peiqiankun@jd.com
 * @version: v1.0
 */
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession(true);
        //判断用户ID是否存在，不存在就跳转到登录界面
        if (session.getAttribute("Uid") == null) {
            if (httpServletRequest.getHeader("x-requested-with") != null
                    && httpServletRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                //是ajax请求，则返回个消息给前台
                PrintWriter printWriter = httpServletResponse.getWriter();
                printWriter.print("{sessionState:timeout}");
                printWriter.flush();
                printWriter.close();
            } else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
