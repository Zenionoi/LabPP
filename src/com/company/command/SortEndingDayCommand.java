package com.company.command;

import com.company.Customers;

public class SortEndingDayCommand implements Command {

    Customers customers;

    public SortEndingDayCommand(Customers customers){
        this.customers=customers;
    }

    public void execute(){
        customers.SortEndingDay();
    }
}