package com.Zenuk;

public class Shield extends Droid{
    Shield(){
        Name="";
        ClassNumber=0;
        maxHp=300;
        hp=maxHp;
        shield=-1;
        maxDamage=15;
        minDamage=10;
        weakness=-1;
        life=true;
        technical=true;
        healing=false;
        Class="Щитоносець";
    }

    public void Info(){
        System.out.println("Опис дій дроїда");
        System.out.println("Дія 1: атакує ворожого дроїда");
        System.out.println("Дія 2: захищає свого союзника");
    }

    public void Attack(Droid X, int n){
        if(n==-1) {
            double k = Math.abs(0.5 - Math.random()) / 10;
            int x = this.minDamage;
            x += (this.maxDamage - this.minDamage) * k;
            x += x * X.weakness / 10;
            X.hp -= x;
            Message(X.Name, x);
        }
        else Protect(X,n);
    }

    public void Protect(Droid X, int n){
        X.shield=n;
        Message2(X.Name);

    }

    public void EndOfGame(){
        hp=maxHp;
        healing=false;
        weakness=-2;
    }

    public void EndOfMove(){
        if(healing)healing=false;
        else if(hp>maxHp)hp=maxHp;
        if(weakness>-2)weakness--;
    }

    public void Message2(String X){
        System.out.println("Захищає дроїда: "+X);
    }

} 