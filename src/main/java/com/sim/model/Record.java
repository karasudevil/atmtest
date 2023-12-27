package com.sim.model;

public class Record {
    private String accountID;
    private String recordID;
    private String recordType;

    private String data;

    private String amount;

    private String remain;

    private String destination;


    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public void setData(String data){this.data=data; }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAmount() {
        return amount;
    }

    public String getData() {
        return data;
    }

    public String getDestination() {
        return destination;
    }

    public String getRemain() {
        return remain;
    }

    public String getRecordID() {
        return recordID;
    }

    public String getAccountID() {
        return accountID;
    }



    public String getRecordType() {
        return recordType;
    }
    @Override
    public String toString(){
        return "Record: {" +
                " accountID=" + accountID +
                " recordID=" + recordID +
                " recordType=" + recordType +
                " data="  +data +
                " amount=" +amount +
                " remain=" +remain +
                " destination=" +destination +
                " }";
    }
}
