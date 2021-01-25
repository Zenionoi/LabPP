package com.Zenuk;

public class BomberDroid extends Droid{
    BomberDroid(){
        ClassNumber=4;
        Name="";
        maxHp=200;
        hp=maxHp;
        shield=-1;
        maxDamage=30;
        minDamage=5;
        weakness=0;
        technical=false;
        healing=false;
        Class="Підривник";
        life=true;
    }

    public void Info() {
        System.out.println("Опис атак дроїда");
        System.out.println("Атака 1: вистрілює чергу бомб у одного ворога");
        System.out.println("Атака 2: атакує усіх ворогів(навіть мертвих) чергою бомб");
        System.out.println("У черзі містится 5 бомб");
    }

    public void Attack(Droid X,int n){
        if(n!=5)
            for(int i=0;i<5;i++) {
                double k = Math.random() / 10;
                int x=(int)(this.maxDamage * k);
                x += x*X.weakness/10;
                X.hp-=x;
                Message(X.Name,x);
            }
        else Kill(X);
    }

    private void Kill(Droid X){
        double k = Math.abs(0.5 - Math.random()) / 10;
        int x=(int)(this.maxDamage * k + this.minDamage);
        X.hp -= x*weakness;
        Message(X.Name,X.hp);
    }

} 