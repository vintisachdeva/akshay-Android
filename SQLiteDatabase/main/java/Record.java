package com.bmpl.crudsqlitedatabase;


public class Record {

    private String data;

    Record(){}

    Record(String data)
    {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}