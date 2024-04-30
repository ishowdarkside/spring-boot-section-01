package com.ishowdarkside.aopdemo.dao;

import com.ishowdarkside.aopdemo.Account;

public interface DemoDAO {

    void addAccount(Account acc,boolean vipFlag);

    String addSillyMember();

    boolean doWork();
}
