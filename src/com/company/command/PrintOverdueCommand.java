package com.company.command;

import com.company.Customers;

public class PrintOverdueCommand implements Command {

    Customers customers;

    public PrintOverdueCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.PrintOverdue();
    }
}