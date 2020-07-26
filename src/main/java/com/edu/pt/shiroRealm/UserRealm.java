package com.edu.pt.shiroRealm;

import com.edu.pt.entity.user.Permission;
import com.edu.pt.entity.user.Role;
import com.edu.pt.entity.user.User;
import com.edu.pt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    @Lazy
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        List<Role> roles = user.getRole();
        for (Role role : roles){
            info.addRole(role.getRole());
            for (Permission permission : role.getPermses()){
                info.addStringPermission(permission.getPerms());
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        /**
         *
         * 从数据库中查询用户信息
         */
        User user = userService.findByUsername(usernamePasswordToken.getUsername());

        if (null == user){
            return null;
        }

        Subject currentSubject =  SecurityUtils.getSubject();

        Session session = currentSubject.getSession();

        session.setAttribute("loginUser",user);

        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }


}