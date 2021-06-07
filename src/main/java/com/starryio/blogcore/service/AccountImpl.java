package com.starryio.blogcore.service;

import com.starryio.blogcore.dao.AccountMapper;
import com.starryio.blogcore.entity.Account;
import com.starryio.blogcore.entity.examples.AccountExample;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountImpl implements IAccountService{

    private final AccountMapper accountMapper;

    @Autowired
    public AccountImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

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
