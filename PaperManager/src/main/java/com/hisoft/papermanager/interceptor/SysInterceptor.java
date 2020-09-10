package com.hisoft.papermanager.interceptor;

import com.hisoft.papermanager.pojo.User;
import com.hisoft.papermanager.util.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-07 09:21:46
 **/
public class SysInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute(Constants.USER_SESSION);
        if (user == null){
            response.sendRedirect(request.getContextPath()+"/error.jsp");
            return false;
        }
        return true;
    }
}
