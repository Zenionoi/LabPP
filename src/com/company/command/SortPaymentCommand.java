package com.company.command;

import com.company.Customers;

public class SortPaymentCommand implements Command {

    Customers customers;

    public SortPaymentCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.SortPayment();
    }
}