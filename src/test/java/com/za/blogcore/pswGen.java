package com.za.blogcore;

import com.za.blogcore.consts.Const;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class pswGen {
    public static void main(String[] args) {
        String[] username = {"admin", "root"};
        String psw = "123";
        for (String name : username) {
            ByteSource credentialsSalt = ByteSource.Util.bytes(name);
            System.out.println(name);
            System.out.println(new SimpleHash(Const.ALGORITHM_NAME, psw, credentialsSalt, Const.HashIterations));
            System.out.println("===============");
        }
    }
}
