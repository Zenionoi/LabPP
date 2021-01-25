package com.company.command;

import com.company.Customers;

public class SortBeginningDayCommand implements Command {

    Customers customers;

    public SortBeginningDayCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.SortBeginningDay();
    }
}