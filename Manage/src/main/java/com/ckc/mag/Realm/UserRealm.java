package com.ckc.mag.Realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 1、把AuthenticationToken转换为UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        // 2、从UsernamePasswordToken中获取username
        String username = usernamePasswordToken.getUsername();

        // 3、调用数据库的方法，从数据库中查询username对应的用户记录
        System.out.println("从数据库中查询");

        // 4、若用户不存在，则抛出UnknownAccountException异常
        if (null == username) {
            throw new UnknownAccountException("用户不存在");
        }

        // 5、根据用户信息情况，决定是否需要抛出其他的AuthenticationException异常
        if ("else".equals(username)) {
            throw new LockedAccountException("用户被锁定");
        }

        // 6、根据用户的情况，来构建AuthenticationInfo对象返回，通常使用的实现类为：SimpleAuthenticationInfo
        // 以下信息是从数据库中获取的
        // 参数 ： principal ---> 认证的实体信息，可以是username，也可以是数据表对应的用户实体类对象
        Object principal = username;
        // 参数 ：credentials ---> 密码
        Object credentials = "123456";
        // 参数 ： realmName ---> 当前realm对象的name。调用父类的getName()方法即可
        String realmName = this.getName();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
