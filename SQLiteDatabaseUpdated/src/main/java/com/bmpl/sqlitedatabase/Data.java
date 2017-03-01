package com.bmpl.sqlitedatabase;

public class Data {

   private String firstName;

    Data(){
    }

    Data(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
