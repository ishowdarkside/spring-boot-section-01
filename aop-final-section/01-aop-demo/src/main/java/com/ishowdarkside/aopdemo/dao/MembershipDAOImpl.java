package com.ishowdarkside.aopdemo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println("DOING MY DB WORK ADD A MEMBERSHIP ACCOUNT");
    }
}
