package com.sim.model;


public class Account {
    private String accountid;
    private String name;
    private String password;
    private int cashamount;
    public  Account(String name, String password, String accountid, int cashamount){
        this.name=name;
        this.password=password;
        this.accountid = accountid;
        this.cashamount = cashamount;
    }
    public Account(){}

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public void setCashamount(int cashamount) {
        this.cashamount = cashamount;
    }
    public void setName(String name) {this.name=name;}
    public void setPassword(String password) {this.password=password;}

    public String getAccountid() {
        return accountid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getCashamount() {
        return cashamount;
    }

    @Override
    public String toString(){
        return "Account: {" +
                " AccountID=" + this.accountid +
                " name=" + this.name +
                " password=" + this.password +
                " cashAmount=" + this.cashamount +
                " }";
    }

}
