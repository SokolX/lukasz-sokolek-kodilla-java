package com.kodilla.hibernate.manytomany.facade;

public class CompanyException extends Exception {

    public static String ERR_NO_SUCH_COMPANY = "No such company";
    public static String ERR_NO_SUCH_EMPLOYEE = "No such employee";

    public CompanyException(String message) {
        super(message);
    }
}
