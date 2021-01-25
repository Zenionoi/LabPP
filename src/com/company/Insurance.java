package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Insurance {

    protected double risk,contribution,payment;
    protected int type,duration;
    protected String name,info;
    protected boolean activity;
    protected Calendar beginningDay,endingDay;

    Insurance(){
        risk=0;
        contribution=0;
        payment=0;
        duration=0;
        type=0;
        name=" ";
        info=" ";
        activity=true;
    }

    public void SetRisk(double risk){
        this.risk=risk;
    }

    public void SetContribution(double contribution){
        this.contribution=contribution;
        SetPayment(Payment(this.duration,this.type, this.risk,this.contribution));
    }

    public void SetPayment(double payment){
        this.payment=payment;
    }

    public void SetDuration(int duration){
        this.duration=duration;
        SetContribution(Contribution(this.duration,this.type,this.risk));
    }

    public void SetBeginningDay(Calendar beginningDay){
        this.beginningDay=beginningDay;
    }

    public void SetEndingDay(Calendar endingDay){
        this.endingDay=endingDay;
        SetActivity(Activity(this.endingDay));
    }

    public void SetName(String name){
        this.name=name;
    }

    public void SetInfo(String info){
        this.info=info;
    }

    public void SetType(int type){
        this.type=type;
    }

    public void SetActivity(boolean activity){
        this.activity=activity;
    }

    public boolean Activity(Calendar endingDay){
        boolean activity=true;
        Calendar currentDay=new GregorianCalendar();
        currentDay.getTime();
        activity=endingDay.before(currentDay);
        return activity;
    }

    public void Info(){
        if(type==0)System.out.println("Страхування майнове");
        else if(type==1)System.out.println("Страхування особисте");
        else System.out.println("Страхування відповідальності");
        System.out.println("Ризик "+risk);
        System.out.println("Внесок "+contribution);
        System.out.println("Виплата "+payment);
        DateFormat df = new SimpleDateFormat("dd MMM yyy");
        System.out.println("Дата початку дії: ");
        System.out.println(df.format(beginningDay.getTime()));
        System.out.println("Дата завершення дії");
        System.out.println(df.format(endingDay.getTime()));
        System.out.println("Тривалість "+duration);
        System.out.println("Відповідальна особа "+name);
        System.out.println("Додаткова інформація "+info);
        if (activity)  System.out.println("Страхування ще активне");
        else System.out.println("Страхування більше не активне");
    }

    public double Contribution(int duration, int type, double risk){
        double contribution=duration;
        if(type==0)contribution*=500*risk;
        else if(type==1)contribution*=300*risk;
        else contribution*=1000*risk;
        contribution/=4;
        return contribution;
    }

    public double Payment(int duration, int type, double risk, double contribution){
        double payment=(1-risk);
        if(type==0)payment*=30*contribution;
        else if(type==1)payment*=20*contribution;
        else payment*=50*contribution;
        return payment;
    }

}
