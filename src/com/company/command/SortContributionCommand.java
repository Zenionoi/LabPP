package com.company.command;

import com.company.Customers;

public class SortContributionCommand implements Command {

    Customers customers;

    public SortContributionCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.SortContribution();
    }
}