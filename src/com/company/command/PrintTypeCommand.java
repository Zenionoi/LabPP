package com.company.command;

import com.company.Customers;

public class PrintTypeCommand implements Command {

    Customers customers;

    public PrintTypeCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.PrintType();
    }
}