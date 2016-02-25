package com.splitwise.testdata.dto;

import java.util.List;

public class UserDetailsDTO {

    private String userName;

    private String password;

//    private List<String> orderCenter;

    public String getUserName() {
        return userName;
    }//end getUserName

    public String getPassword() {
        return password;
    }//end getPassword

//    public List<String> getOrderCenter() {
//        return orderCenter;
//    }
//
//    public void setOrderCenter(final List<String> orderCenter) {
//        this.orderCenter = orderCenter;
//    }

    public void setUserName(final String un) {
        this.userName = un;
    }

    public void setPassword(final String pwd) {
        this.password = pwd;
    }
}//end UserDetailsDTO
