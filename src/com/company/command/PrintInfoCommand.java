package com.company.command;

import com.company.Customers;

public class PrintInfoCommand implements Command {

    Customers customers;

    public PrintInfoCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.PrintInfo();
    }
}