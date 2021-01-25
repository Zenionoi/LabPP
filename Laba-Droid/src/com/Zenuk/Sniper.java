package com.Zenuk;

public class Sniper extends Droid{
    Sniper(){
        ClassNumber=5;
        Name="";
        shield=-1;
        maxHp=150;
        hp=maxHp;
        maxDamage=50;
        minDamage=25;
        weakness=0;
        technical=false;
        life=true;
        healing=false;
        Class="Снайпер";
    }

    public void Info(){
        System.out.println("Опис дій дроїда");
        System.out.println("Атака1: наносить ворогу урон");
        System.out.println("Атака2: атакує ворожого дроїда");
        System.out.println("А також ослаблює матеріал броні ворога на хід");
        System.out.println("Атака3: ослаблює матеріал броні ворога на 3 ходи, не наносячи по ньому урону");
    }

    public void Attack(Droid X,int n){
        if(n==0)Attack1(X);
        if(n==1)Attack2(X);
        if(n==2)Attack3(X);
    }

    public void Attack1(Droid X){
        int x=this.maxDamage;
        x+=x*X.weakness/10;
        X.hp-=x;
        Message(X.Name,x);
    }

    private void Attack2(Droid X){
        int x=this.minDamage;
        x+=x*X.weakness/10;
        X.hp-=x;
        Message(X.Name,x);
        X.weakness++;
        X.weakness++;
        Message2(X.Name);
    }

    private void Attack3(Droid X){
        X.weakness++;
        X.weakness++;
        Message2(X.Name);
        X.weakness++;
        X.weakness++;
    }

    public void Message2(String X){
        System.out.println("Ослабив матеріал броні дроїда: "+X);
    }
} 