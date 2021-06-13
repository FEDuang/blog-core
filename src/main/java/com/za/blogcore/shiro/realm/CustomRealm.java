package com.za.blogcore.shiro.realm;

import com.za.blogcore.consts.Const;
import com.za.blogcore.entity.Account;
import com.za.blogcore.service.IAccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private IAccountService accountService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("doGetAuthorizationInfo");
        Subject subject = SecurityUtils.getSubject();
        //如果没登陆，直接就是0身份
        Set<String> roles = (Set<String>) subject.getSession().getAttribute("roles");
        //如果已经查询过了，没必要再次查询
        if (roles == null) {
            //第一次查询身份信息，查询后存储起来
            roles = new HashSet<>();
            roles.add("0");
            subject.getSession().setAttribute("roles", roles);
        }
        return new SimpleAuthorizationInfo(roles);
    }

    /**
     * 提供账户信息返回认证信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws ShiroException {
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //2. 获取 username
        String username = usernamePasswordToken.getUsername();
//            char[] password = Const.encodePassword(username, usernamePasswordToken.getPassword());
        //3. 调用数据库的方法 根据情况, 决定抛出异常.
        Account account = accountService.getOneUserByUsername(username);
        if (account == null) {
            throw new UnknownAccountException();
        }
        //防止传递密码
        Subject subject = SecurityUtils.getSubject();
        String password = account.getPassword();
        System.out.println("account: " + account);
        account.setPassword(null);
        subject.getSession().setAttribute("user", account);
        //仅允许单用户登录
//        SessionDAO sessionDAO = ((DefaultSessionManager) ((DefaultSecurityManager) SecurityUtils
//                .getSecurityManager()).getSessionManager()).getSessionDAO();
//        Collection<Session> sessions = sessionDAO.getActiveSessions();
//        for (Session session : sessions) {
//            if (username.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
//                sessionDAO.delete(session);
//            }
//        }
        //5. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        //1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
        //2). credentials: 密码.
        //3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
        //4). 采用用户名来生成盐(也可以采用 用户名+特定盐 来生成盐)使用盐值后,即使多个用户原始密码相同，它们存在数据库内结果也不同
        ByteSource credentialsSalt = ByteSource.Util.bytes(username + Const.SALT);
        //下面这个类会验证token中用户输入和数据库存的密码是否相同
        //第二个参数请填写正确的密码
        return new SimpleAuthenticationInfo(account.getUsername(), password, credentialsSalt, this.getName());
        //return new SimpleAuthenticationInfo(username,password,this.getName());
    }
}
