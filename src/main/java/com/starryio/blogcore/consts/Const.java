package com.starryio.blogcore.consts;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * 全局静态常量类
 */
public class Const {

    public static final String CURRENT_USER = "username";

    /*log4j2标记，所有由我们自己发出的日志都会持有此标记*/
    public static final Marker LOG_MARKER = new MarkerManager.Log4jMarker("starryio");

    /*shiro密码加密算法*/
    public static final String ALGORITHM_NAME = "sha-256";

    /*shiro进行密码加密的次数*/
    public static final int HashIterations = 2;

    public static final String SALT="za102nb";

    public static final String KEYSTR="知行102";

//    public static String getCurrentUsername(){
//        Subject subject = SecurityUtils.getSubject();
//        return (String) subject.getSession().getAttribute(CURRENT_USER);
//    }
//
//    public static char[] encodePassword(String salt, char[] password){
//        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
//        SimpleHash encodedPassword = new SimpleHash(
//                Const.ALGORITHM_NAME, password, credentialsSalt, Const.HashIterations);
//        return encodedPassword.toString().toCharArray();
//    }

}
