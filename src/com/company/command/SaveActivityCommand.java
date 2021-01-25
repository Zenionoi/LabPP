package com.company.command;

import com.company.Customers;

public class SaveActivityCommand implements Command {

    Customers customers;

    public SaveActivityCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.SaveActivity();
    }
}