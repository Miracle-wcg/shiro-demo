package com.wcg.shiro.core;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @Author: chengang.wu
 * @Date: 2020-04-09 14:40
 */
public class ShiroDemo {
    public static void main(String[] args) {
        login("classpath:shiro.ini");
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection previousPrincipals = subject.getPreviousPrincipals();
        System.out.println(111);
    }

    private static void login(String configFile) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "123");
        subject.login(usernamePasswordToken);
//        Assert.assertEquals(true, subject.isAuthenticated());
//        subject.logout();
    }
}
