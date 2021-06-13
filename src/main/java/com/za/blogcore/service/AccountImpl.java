package com.za.blogcore.service;

import com.za.blogcore.dao.AccountMapper;
import com.za.blogcore.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountImpl implements IAccountService{

    @Autowired
    private AccountMapper accountMapper;

//    @Autowired
//    public AccountImpl(AccountMapper accountMapper) {
//        this.accountMapper = accountMapper;
//    }

    @Override
    public Account login(String UserName, String Password) {
        Account account = accountMapper.selectByUserName(UserName);
        if (account.getPassword().equals(Password)){
            account.setPassword(null);
            return account;
        }
        return null;
    }

    @Override
    public Account getOneUserByUsername(String UserName) {
        return accountMapper.selectByUserName(UserName);
    }
}
