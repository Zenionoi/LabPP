package com;
import java.util.Scanner;
public class App {
public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Hello світ!");

        Class_1 mal;
   mal= new Class_1();
   System.out.println(mal.Classint);
   System.out.println(mal.Classchar);
   int int1 =reader.nextInt();
   int int2 =reader.nextInt();
   int int3 =reader.nextInt();
   System.out.printf("%d\t%d\t%d\t\n",int1,int2,int3);
   System.out.println("Введіть межі інтервалу");
   int a=reader.nextInt(),b=reader.nextInt();;
int sumNP=0,sumP=0;
int i, bigNP,bigP;
for (i = a; i <= b; ++i) {
        if((i%2)==1){
        System.out.print(i);System.out.print('\t');
        sumNP+=i;
        }
      }
      System.out.print("\nСума непарних - ");
      System.out.println(sumNP);
      for (i = b; i >= a; --i) {
        if((i%2)==0){
        System.out.print(i);System.out.print('\t');
        sumP+=i;
        }
      }
      System.out.print("\nСума парних - ");
      System.out.println(sumP);
      if((b%2)==1){
              bigNP=b;
              bigP=b-1;
      }else{
        bigNP=b-1;
        bigP=b;
      }
      System.out.println("Введіть довжину ряду");
   int l=reader.nextInt();
   int f1=bigNP,f2=bigP,fNP=1,fP=1;
   System.out.printf("%d %d\n",bigNP,bigP);
   for (i = 3; i <= l; i++) {
        if((i%2)==1)
        {
           f1+=f2;
           if((f1%2)==1)
                   fNP++;
                   else fP++;
           System.out.printf("%d ",f1);
        }
        else{
           f2+=f1;
           System.out.printf(" %d\n",f2);
           if((f2%2)==1)
                   fNP++;
                   else fP++;
        }
                }
   double NP=(100.*fNP)/l,P=(100.*fP)/l;
   System.out.println();
        System.out.print("парних - ");
        System.out.println(P);
        System.out.print("непарних - ");
        System.out.println(NP);
}
}
