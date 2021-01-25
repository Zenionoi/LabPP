package com.company.command;

import com.company.Customers;

public class DeleteElementCommand implements Command {

    Customers customers;

    public DeleteElementCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.DeleteElement();
    }
}