package com.Zenuk;

public class RPG_Droid extends Droid{
    RPG_Droid(){
        ClassNumber=3;
        shield=-1;
        Name="";
        maxHp=50;
        hp=maxHp;
        maxDamage=150;
        minDamage=125;
        weakness=0;
        technical=false;
        healing=false;
        life=true;
        Class="РПГ-дроїд";
    }
    public void Info(){
        System.out.println("Опис дії дроїда");
        System.out.println("Атака: атакує ворожого дроїда");
        System.out.println("Наносить урон не лише по ворогу, але і по собі");
    }

    public void Attack(Droid X,int n){
        double k=Math.abs(0.5-Math.random())/10;
        int x=this.minDamage;
        x+=(this.maxDamage-this.minDamage)*k;
        x+=x*X.weakness/10;
        Message(X.Name,x);
        X.hp-=x;
        k=Math.abs(0.5-Math.random())/10;
        int c=hp;
        hp*=k;
        c-=hp;
        Message2(c);
        if(hp==0)Death();
    }

    public void Message2(int x){
        System.out.println(Name+" наніс собі " +x+ " урону ");
    }

} 