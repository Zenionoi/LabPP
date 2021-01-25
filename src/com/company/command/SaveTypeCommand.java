package com.company.command;

import com.company.Customers;

public class SaveTypeCommand implements Command {

    Customers customers;

    public SaveTypeCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.SaveType();
    }
}