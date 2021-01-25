package com.Zenuk;

public class Engineer extends Droid{
    protected int minHealing,maxHealing;
    Engineer(){
        ClassNumber=1;
        Name="";
        shield=-1;
        maxHp=150;
        minDamage=5;
        maxDamage=15;
        minHealing=25;
        maxHealing=150;
        hp=maxHp;
        weakness=0;
        life=true;
        technical=false;
        healing=false;
        Class="Інженер";
    }

    public void Info() {
        System.out.println("Опис дій дроїда");
        System.out.println("Дія 1: атакує ворожого дроїда");
        System.out.println("Дія 2: відновлює здоров'я союзнику, та збільшує його вище максимальної на цей та наступний ходи");
        System.out.println("Дія 3: відновлює усім живим союзникам трохи здоров'я");
    }

    public void Attack(Droid X,int n) {
        if (n != 5) {
            double k = Math.abs(0.5 - Math.random()) / 10;
            int x = this.minDamage;
            x += (this.maxDamage - this.minDamage) * k;
            x += x * X.weakness / 10;
            X.hp -= x;
            Message(X.Name, x);
        }
        else HealAll(X);
    }

    public void Protect(Droid X){
        X.hp+=this.maxHealing;
        if(X.hp>X.maxHp+25)X.hp=X.maxHp;
        X.healing=true;
        X.weakness=0;
        if(X.ClassNumber==0)X.weakness=-2;
        Message2(X.Name,X.hp);
    }

    private void HealAll(Droid X){
        X.hp+=this.minHealing;
        if(X.hp>X.maxHp)X.hp=X.maxHp;
        Message2(X.Name,X.hp);
    }

    public void Message2(String X,int x){
        System.out.println("Відновив дроїду:"+X+ " здоров'я до рівня "+x);
    }
} 