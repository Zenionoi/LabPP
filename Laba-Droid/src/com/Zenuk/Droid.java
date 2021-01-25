package com.Zenuk;

public class Droid{
    protected int maxHp,shield,hp,maxDamage,weakness,minDamage,ClassNumber;
    protected String Name, Class;
    protected boolean technical,healing,life;

    Droid(){
        ClassNumber=2;
        Name="";
        shield=-1;
        maxHp=125;
        hp=maxHp;
        maxDamage=30;
        minDamage=15;
        weakness=0;
        life=true;
        technical=false;
        healing=false;
        Class="Дроїд";
    }

    public void Naming(String a){
        Name=a;
    }

    public void Write(){
        System.out.println("Дроїд класу: "+Class);
        System.out.println("Ім'я дроїда: "+Name);
        System.out.println("Максимальне здоров'я: "+maxHp);
        System.out.println("Максимальна урон: "+maxDamage);
        System.out.println("\n");
    }

    public void Print(){
        System.out.println("Дроїд класу: "+Class);
        System.out.println("Ім'я дроїда: "+Name);
        System.out.println("Здоров'я: "+maxHp);
        System.out.println("\n");
        Info();
    }

    public void Info(){
        System.out.println("Опис дій дроїда");
        System.out.println("Дія 1: атакує ворожого дроїда");
        System.out.println("Дія 2: замінює захисну пластину. Одну за хід");
    }

    public void Attack(Droid X, int n){
        double k=Math.abs(0.5-Math.random())/10;
        int x=this.minDamage;
        x+=(this.maxDamage-this.minDamage)*k;
        x+=x*X.weakness/10;
        X.hp-=x;
        Message(X.Name,x);
    }

    public void Protect(Droid X){
        if((this.hp+15)>(this.maxHp))this.hp=this.maxHp;
        else this.hp+=15;
        Message2(this.hp);
    }

    public void EndOfMove(){
        if(healing)healing=false;
        else if(hp>maxHp)hp=maxHp;
        if(weakness>0)weakness--;
        shield=-1;
    }

    public void Death(){
        life=false;
    }

    public void EndOfGame(){
        hp=maxHp;
        healing=false;
        weakness=0;
        shield=-1;
    }

    public void Message(String X,int x){
        System.out.println(this.Name+" наніс "+x+" урону по " +X);
    }

    public void Message2(int x){
        System.out.println("Відновив здоров'я до рівня "+x);
    }
} 