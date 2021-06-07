package com.starryio.blogcore.shiro.filter;

import com.starryio.blogcore.consts.ResponseCode;
import com.starryio.blogcore.utils.RedirectUtil;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class MyRolesAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            //no roles specified, so nothing to check - allow access.
            return true;
        }
        //只要有一个就返回true,原来的是hasAllRoles
        Set<String> roles = CollectionUtils.asSet(rolesArray);
        for (String role :
                roles) {
            if (subject.hasRole(role)){
                return true;
            }
        }
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        RedirectUtil.setFailAndOutput(httpServletResponse, ResponseCode.e403);
        return false;
    }
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        return false;
    }
}
