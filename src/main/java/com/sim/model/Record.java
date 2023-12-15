package com.sim.model;

public class Record {
    private String accountID;
    private String recordID;
    private String recordType;
    private String recordBody;

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public void setRecordBody(String recordBody) {
        this.recordBody = recordBody;
    }

    public String getRecordID() {
        return recordID;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getRecordBody() {
        return recordBody;
    }

    public String getRecordType() {
        return recordType;
    }
    @Override
    public String toString(){
        return "Record={" +
                "accountID=" + accountID +
                ",recordID=" + recordID +
                ",recordType=" + recordType +
                ",recordBody=" + recordBody +
                "}";
    }
}
