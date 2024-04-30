package com.ishowdarkside.aopdemo.dao;


import com.ishowdarkside.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO implements DemoDAO{

    @Override
    public void addAccount(Account account,boolean vipFlag) {

        if(vipFlag) System.out.println("THIS PERSON IS VIP  - - - Very important!");
        System.out.println(account.getName());
        System.out.println(this.getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");


    }

    @Override
    public String addSillyMember() {
        System.out.println("ADDING SILLY MEMBER iN HERE");
        return  null;
    }

    @Override
    public boolean doWork() {
        System.out.println("DO WORK FUNKCIJA  - VRACA FALSE (BOOLEAN)");
        return false;
    }
}
