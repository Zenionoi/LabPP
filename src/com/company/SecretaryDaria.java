package com.company;

import com.company.command.Command;

public class SecretaryDaria {

    Command addelement;
    Command deleteement;
    Command printinfo;
    Command sortrisc;
    Command sortcontribution;
    Command sortpayment;
    Command sortbeginningday;
    Command sortendingday;
    Command printname;
    Command printtype;
    Command printactivity;
    Command printoverdue;
    Command saveall;
    Command savetype;
    Command saveactivity;

    public SecretaryDaria(Command addelement, Command deleteement, Command printinfo, Command sortrisc, Command sortcontribution, Command sortpayment, Command sortbeginningday, Command sortendingday, Command printname, Command printtype, Command printactivity, Command printoverdue, Command saveall, Command savetype, Command saveactivity){
        this.addelement=addelement;
        this.deleteement=deleteement;
        this.printinfo=printinfo;
        this.sortrisc=sortrisc;
        this.sortcontribution=sortcontribution;
        this.sortpayment=sortpayment;
        this.sortbeginningday=sortbeginningday;
        this.sortendingday=sortendingday;
        this.printname=printname;
        this.printtype=printtype;
        this.printactivity=printactivity;
        this.printoverdue=printoverdue;
        this.saveall=saveall;
        this.savetype=savetype;
        this.saveactivity=saveactivity;
    }

    public void addelementRecord(){
        addelement.execute();
    }

    public void deleteementRecord(){
        deleteement.execute();
    }

    public void printinfoRecord(){
        printinfo.execute();
    }

    public void sortriscRecord(){
        sortrisc.execute();
    }

    public void sortcontributionRecord(){
        sortcontribution.execute();
    }

    public void sortpaymentRecord(){
        sortpayment.execute();
    }

    public void sortbeginningdayRecord(){
        sortbeginningday.execute();
    }

    public void sortendingdayRecord(){
        sortendingday.execute();
    }

    public void printnameRecord(){
        printname.execute();
    }

    public void printtypeRecord(){
        printtype.execute();
    }

    public void printactivityRecord(){
        printactivity.execute();
    }

    public void printoverdueRecord(){
        printoverdue.execute();
    }

    public void saveallRecord(){
        saveall.execute();
    }

    public void savetypeRecord(){
        savetype.execute();
    }

    public void saveactivityRecord(){
        saveactivity.execute();
    }
}
