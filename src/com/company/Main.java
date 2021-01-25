package com.company;

import com.company.command.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Customers customers;
        customers = new Customers();
        boolean end=false;

        Scanner reader = new Scanner(System.in);

        SecretaryDaria secretary = new SecretaryDaria(
                new AddElementCommand(customers),
                new DeleteElementCommand(customers),
                new PrintInfoCommand(customers),
                new SortRiscCommand(customers),
                new SortContributionCommand(customers),
                new SortPaymentCommand(customers),
                new SortBeginningDayCommand(customers),
                new SortEndingDayCommand(customers),
                new PrintNameCommand(customers),
                new PrintTypeCommand(customers),
                new PrintActivityCommand(customers),
                new PrintOverdueCommand(customers),
                new SaveAllCommand(customers),
                new SaveTypeCommand(customers),
                new SaveActivityCommand(customers)
        );

        while (end == false) {
            System.out.println("Меню\nДля активації дії вам потрібно ввести команду зліва");
            System.out.println("'/add' - додає угоду");
            System.out.println("'/delete' - видаляє угоду");
            System.out.println("'/sort' - сортує угоди за певною ознакою");
            System.out.println("'/print' - виводить страхування");
            System.out.println("'/save' - зберігає угоди у файлах");
            System.out.println("'/end' - для завершення програми");
            String command = reader.nextLine();
            if (command.equals("/add")) {
                secretary.addelementRecord();
            }
            else if (command.equals("/end"))end=true;
            else if (command.equals("/delete")){
                secretary.deleteementRecord();
            }
            else if (command.equals("/sort")){
                System.out.println("'/risk' - сортує за ризиком");
                System.out.println("'/payment' - сортує за виплатою");
                System.out.println("'/contribution' - сортує за внеском");
                System.out.println("'/beginning' - сортує за днем початку");
                System.out.println("'/ending' - сортує за днем кінця");
                command = reader.nextLine();
                if (command.equals("/risk")) {
                    secretary.sortriscRecord();
                } else if (command.equals("/payment")) {
                    secretary.sortpaymentRecord();
                } else if (command.equals("/contribution")) {
                    secretary.sortcontributionRecord();
                } else if (command.equals("/beginning")) {
                    secretary.sortbeginningdayRecord();
                }
                else secretary.sortendingdayRecord();
            }
            else if (command.equals("/print")){
                System.out.println("'/all' - вивести усе");
                System.out.println("'/name' - вивести тільки на цю людину");
                System.out.println("'/type' - вивести тільки цього типу");
                System.out.println("'/activity' - вивести тільки активні");
                System.out.println("'/overdue' - вивести тільки не активні");
                command = reader.nextLine();
                if (command.equals("/all")) {
                    secretary.printinfoRecord();
                } else if (command.equals("/name")) {
                    secretary.printnameRecord();
                } else if (command.equals("/type")) {
                    secretary.printtypeRecord();
                } else if (command.equals("/overdue")) {
                    secretary.printoverdueRecord();
                }
                else secretary.printactivityRecord();
            } else {
                System.out.println("'/all' - зберегти усе");
                System.out.println("'/type' - зберегти тільки цього типу");
                System.out.println("'/activity' - зберегти тільки активні");
                command = reader.nextLine();
                if (command.equals("/all")) {
                    secretary.saveallRecord();
                } else if (command.equals("/type")) {
                    secretary.savetypeRecord();
                }
                else  secretary.saveactivityRecord();
            }
            Stop();
        }
        System.out.println("Завершення програми");
    }
    public static void Stop(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Натисніть Enter щоб продовжити");
        String c=reader.nextLine();
    }
}
