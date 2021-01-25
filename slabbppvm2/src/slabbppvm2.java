import java.util.Scanner; 
public class slabbppvm2 {
    /*Варіант 19-10=9
    *Product: id, Найменування, Виробник, Ціна, Термін зберігання,Кількість.
*Скласти масив об'єктів. Вивести:
*a) список товарів для заданого найменування;
*b) список товарів для заданого найменування, ціна яких не перевищує задану;
*c) список товарів, термін зберігання яких більше заданого.
    */

    public static void getProductByName(Product[] arr, int elem)
     {
        System.out.println("\n\tВивід за найменуванням товару"); 
        Scanner scan=new Scanner(System.in); 
        boolean m=false;
        System.out.println("Введіть найменування товару: "); 
        String name=scan.nextLine();
        for(int i=0;i<elem;++i)
        { 
            if(arr[i].Get_Naming().equals(name)) 
        {
            System.out.println(arr[i].toString()); 
            m=true;
        }
    }
        if (m!=true)
        System.out.println("Товарів, що підходять до вказаних параметрів не виявлено");
}
    
            public static void getProductsByPrice(Product[] arr, int elem) 
            {
                System.out.println("\n\tВивід за найменуванням товару та ціною "); 
                 Scanner scan=new Scanner(System.in);
                 System.out.println("Введіть найменування товару: "); 
                 String name=scan.nextLine();
                 boolean m=false;
                 System.out.println("Введіть ціну товару: "); 
                 int price=scan.nextInt();
                 for(int i=0;i<elem;++i)
                     if(arr[i].Get_Naming().equals(name) && arr[i].Get_Price()<=price) 
                     {
                     System.out.println(arr[i].toString()); 
                     m=true;
                    }                  
                if (m!=true)
                System.out.println("Товарів, що підходять до вказаних параметрів не виявлено"); 
            }

            public static void getProductsByBestBefore(Product[] arr, int elem)
                        {
                            System.out.println("\n\tВивід за терміном придатності "); 
                              Scanner scan=new Scanner(System.in); 
                              boolean m=false;
                              System.out.println("Введіть термін: "); 
                              int Best_before=scan.nextInt(); 
                              for(int i=0;i<elem;++i){ 
                                  if(arr[i].Get_Best_before()>=Best_before)
                                   System.out.println(arr[i].toString());
                                  m=true;
                    }                  
                if (m!=true)
                System.out.println("Товарів, що підходять до вказаних параметрів не виявлено"); 
                }

                              public static void main(String[] args) { 
                                  int elem; 
                                  System.out.println("Введіть к-сть товарів: ");
                                  Scanner scan=new Scanner(System.in); 
                                  elem=scan.nextInt(); 
                                  Product[] arr = new Product[elem]; 
                                  for(int i=0;i<elem;i++){
                                       int ID, price, bestBF, qtt;
                                        String nm, prod;
                                        System.out.println("Введіть Id: "); 
                                        ID= scan.nextInt(); scan.nextLine(); 
                                        System.out.println("Введіть Найменування: "); 
                                        nm=scan.nextLine(); 
                                        System.out.println("Введіть виробника: "); 
                                        prod=scan.nextLine(); 
                                        System.out.println("Введіть ціну: "); 
                                        price=scan.nextInt(); scan.nextLine(); 
                                        System.out.println("Введіть термін зберігання(не змінюйте одиниці часу протягом виконання програми(дні/місяці/роки)): "); 
                                        bestBF=scan.nextInt(); scan.nextLine(); 
                                        System.out.println("Введіть кількість: "); 
                                        qtt=scan.nextInt();  scan.nextLine(); 
                                        arr[i]=new Product(ID, price, bestBF, qtt, nm,prod); 
                                        System.out.println(arr[i].toString()); 
                                    } 
                                    getProductByName(arr,elem); 
                                    getProductsByPrice(arr, elem); 
                                    getProductsByBestBefore(arr,elem); 
                                }
}
