package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Customers {

    Insurance[]list=new Insurance[40];
    int n;

    Customers(){
        n=0;
    }

    public void AddElement(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Додавання страхування");
        System.out.println("Введіть тип страхування:");
        System.out.println("'property'-майнове, 'personal'-особисте або 'responsibility'-відповідальність");
        String command = reader.nextLine();
        int type;
        if(command.equals("property"))type=0;
        else if(command.equals("personal"))type=1;
        else type=2;
        System.out.println("Введіть ім'я особи");
        String name = reader.nextLine();
        System.out.println("Введіть ризик");
        double risk=reader.nextDouble();
        Calendar beginningDay=new GregorianCalendar();
        System.out.println("Введіть рік початку");
        int year=reader.nextInt();
        System.out.println("Введіть номер місяця початку");
        int month=reader.nextInt();
        System.out.println("Введіть день початку");
        int day=reader.nextInt();
        beginningDay.set(year,month-1,day);
        System.out.println("Введіть тривалість страхування у днях");
        int duration=reader.nextInt();
        Calendar endingDay=new GregorianCalendar();
        endingDay.set(year,month-1,day+duration);
        System.out.println("Введіть додаткову інформацію");
        String info = reader.nextLine();
        info = reader.nextLine();
        list[n]=Add(name,type,risk,beginningDay,duration,endingDay,info);
    }

    public Insurance Add(String name, int type, double risk, Calendar beginningDay,int duration,Calendar endingDay,String info){
        Insurance element=new Insurance();
        element.SetType(type);
        element.SetName(name);
        element.SetInfo(info);
        element.SetRisk(risk);
        element.SetBeginningDay(beginningDay);
        element.SetDuration(duration);
        element.SetEndingDay(endingDay);
        n++;
        return element;
    }

    public void DeleteElement(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Видалення елемента");
        System.out.println("Введіть номер елемента який потрібно видалити");
        System.out.println("Загально: " +n+" угод");
        int m=reader.nextInt();
        m--;
        for(int i=0;i<n;i++)
            if(i>m)list[i-1]=list[i];
        n--;
    }

    public void PrintInfo(){
        System.out.println("Виведення усіх елементів");
        for(int i=0;i<n;i++){
            list[i].Info();
        }
    }

    public void SortRisc(){
        System.out.println("Сортувати за ризиком");
        boolean sorted = false;
        Insurance temp=new Insurance();
        System.out.println("Введіть '+' для сортування за зростанням");
        System.out.println("Введіть '-' для сортування за спаданням");
        Scanner reader = new Scanner(System.in);
        String command = reader.nextLine();
        if (command.equals("+")) {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].risk > list[i+1].risk) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        else {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].risk < list[i+1].risk) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        PrintInfo();
    }

    public void SortContribution(){
        System.out.println("Сортувати за вхідною оплатою");
        boolean sorted = false;
        Insurance temp=new Insurance();
        System.out.println("Введіть '+' для сортування за зростанням");
        System.out.println("Введіть '-' для сортування за спаданням");
        Scanner reader = new Scanner(System.in);
        String command = reader.nextLine();
        if (command.equals("+")) {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].contribution > list[i+1].contribution) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        else {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].contribution < list[i+1].contribution) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        PrintInfo();
    }

    public void SortPayment(){
        System.out.println("Сортувати за виплатою");
        boolean sorted = false;
        Insurance temp=new Insurance();
        System.out.println("Введіть '+' для сортування за зростанням");
        System.out.println("Введіть '-' для сортування за спаданням");
        Scanner reader = new Scanner(System.in);
        String command = reader.nextLine();
        if (command.equals("+")) {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].payment > list[i+1].payment) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        else {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].payment < list[i+1].payment) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
    }

    public void SortBeginningDay(){
        System.out.println("Сортувати за днем початку дії");
        boolean sorted = false;
        Insurance temp=new Insurance();
        System.out.println("Введіть '+' для сортування за зростанням");
        System.out.println("Введіть '-' для сортування за спаданням");
        Scanner reader = new Scanner(System.in);
        String command = reader.nextLine();
        if (command.equals("+")) {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].beginningDay.before(list[i+1].beginningDay) ) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        else {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].beginningDay.after(list[i+1].beginningDay)) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        PrintInfo();
    }

    public void SortEndingDay(){
        System.out.println("Сортувати за днем завершення дії");
        boolean sorted = false;
        Insurance temp=new Insurance();
        System.out.println("Введіть '+' для сортування за зростанням");
        System.out.println("Введіть '-' для сортування за спаданням");
        Scanner reader = new Scanner(System.in);
        String command = reader.nextLine();
        if (command.equals("+")) {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].endingDay.before(list[i+1].endingDay) ) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        else {
            while(!sorted) {
                sorted = true;
                for (int i = 0; i < n - 1; i++) {
                    if (list[i].endingDay.after(list[i+1].endingDay)) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        sorted = false;
                    }
                }
            }
        }
        PrintInfo();
    }

    public void PrintName(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Введіть ім'я");
        String name = reader.nextLine();
        for(int i=0;i<n;i++){
            if(name.equals(list[i].name))list[i].Info();
        }
    }

    public void PrintType(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Видіть тип");
        System.out.println("'property'-майнове, 'personal'-особисте або 'responsibility'-відповідальність");
        String command = reader.nextLine();
        int type;
        if(command.equals("property"))type=0;
        else if(command.equals("personal"))type=1;
        else type=2;
        for(int i=0;i<n;i++){
            if(type==list[i].type)list[i].Info();
        }
    }

    public void PrintActivity(){
        for(int i=0;i<n;i++){
            if(list[i].activity)list[i].Info();
        }
    }

    public void PrintOverdue(){
        for(int i=0;i<n;i++){
            if(!list[i].activity)list[i].Info();
        }
    }

    public void SaveAll(){
        File file = new File("EpicFail.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<n;i++) {
            if(list[i].type==0)pw.println("Страхування майнове");
            else if(list[i].type==1)pw.println("Страхування особисте");
            else pw.println("Страхування відповідальності");
            pw.println("Ризик "+list[i].risk);
            DateFormat df = new SimpleDateFormat("dd MMM yyy");
            pw.println("Дата початку дії: ");
            pw.println(df.format(list[i].beginningDay.getTime()));
            pw.println("Дата завершення дії:");
            pw.println(df.format(list[i].endingDay.getTime()));
            pw.println("Тривалість "+list[i].duration);
            pw.println("Відповідальна особа "+list[i].name);
            pw.println("Додаткова інформація "+list[i].info);
            if (list[i].activity)  pw.println("Страхування ще активне");
            else pw.println("Страхування більше не активне");
            pw.println("______________________________________");
        }
        pw.close();
    }

    public void SaveType(){
        System.out.println("Зберегти тип");
        Scanner reader = new Scanner(System.in);
        System.out.println("Видіть тип");
        System.out.println("'property'-майнове, 'personal'-особисте або 'responsibility'-відповідальність");
        String command = reader.nextLine();
        int type;
        if(command.equals("property"))type=0;
        else if(command.equals("personal"))type=1;
        else type=2;
        File file = new File(command+".txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<n;i++) {
            if(type==list[i].type) {
                if (list[i].type == 0) pw.println("Страхування майнове");
                else if (list[i].type == 1) pw.println("Страхування особисте");
                else pw.println("Страхування відповідальності");
                pw.println("Ризик " + list[i].risk);
                pw.println("Внесок " + list[i].contribution);
                pw.println("Виплата " + list[i].payment);
                DateFormat df = new SimpleDateFormat("dd MMM yyy");
                pw.println("Дата початку дії: ");
                pw.println(df.format(list[i].beginningDay));
                pw.println("Дата завершення дії:");
                pw.println(df.format(list[i].endingDay));
                pw.println("Тривалість " + list[i].duration);
                pw.println("Відповідальна особа " + list[i].name);
                pw.println("Додаткова інформація " + list[i].info);
                if (list[i].activity) pw.println("Страхування ще активне");
                else pw.println("Страхування більше не активне");
                pw.println("______________________________________");
            }
        }
        pw.close();
    }

    public void SaveActivity(){
        System.out.println("Зберегти активність");
        File file = new File("Active.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<n;i++) {
            if (list[i].activity) {
                if (list[i].type == 0) pw.println("Страхування майнове");
                else if (list[i].type == 1) pw.println("Страхування особисте");
                else pw.println("Страхування відповідальності");
                pw.println("Ризик " + list[i].risk);
                pw.println("Внесок " + list[i].contribution);
                pw.println("Виплата " + list[i].payment);
                DateFormat df = new SimpleDateFormat("dd MMM yyy");
                pw.println("Дата початку дії: ");
                pw.println(df.format(list[i].beginningDay));
                pw.println("Дата завершення дії:");
                pw.println(df.format(list[i].endingDay));
                pw.println("Тривалість " + list[i].duration);
                pw.println("Відповідальна особа " + list[i].name);
                pw.println("Додаткова інформація " + list[i].info);
                if (list[i].activity) pw.println("Страхування ще активне");
                else pw.println("Страхування більше не активне");
                pw.println("______________________________________");
            }
        }
        pw.close();
    }
}
