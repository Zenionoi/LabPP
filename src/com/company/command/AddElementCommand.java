package com.company.command;

import com.company.Customers;

public class AddElementCommand implements Command {

    Customers customers;

    public AddElementCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.AddElement();
    }
}