package com.company.command;

import com.company.Customers;

public class SaveAllCommand implements Command {

    Customers customers;

    public SaveAllCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.SaveAll();
    }
}