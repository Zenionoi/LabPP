package com.Zenuk;
import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        System.setProperty("console.encoding","Cp1251");
        Scanner reader = new Scanner(System.in);
        int i = 0;
        System.out.println("Вітаємо у Битві дроїдів!");
        System.out.println("Як вас звати?");
        System.out.println("Будь ласка, введіть ваше ім'я");
        String Name1 =reader.nextLine();
        System.out.println("З ким ви хочете грати?");
        System.out.println("Якщо з другом, введіть '/friend'");
        System.out.println("Якщо без нього, то просто натисніть Enter");
        String command =reader.nextLine();
        String Name2 ="AI";
        boolean comp=true;
        if(command.equals("/friend")){
            System.out.println("Введіть його ім'я, будь ласка");
            Name2 =reader.nextLine();
            comp=false;
        }
        System.out.println("Що ви бажаєте зробити? \nДля початку раджу вам створити вашу команду");
        System.out.println("Ось це є меню цієї гри.");

        Droid []list=new Droid[15];
        while (i != -1) {

            System.out.println("Меню\nДля активації дії вам потрібно ввести команду зліва");
            System.out.println("'/info' - для інформації про класи дроїдів");
            System.out.println("'/create' - для створення дроїда");
            System.out.println("'/delete' - для видалення дроїда");
            System.out.println("'/list' - для показу списку створених дроїдів");
            System.out.println("'/versus' - для початку бою 1 на 1");
            System.out.println("'/battle' - для початку бою команда на команду");
            System.out.println("'/end' - для завершення гри");
            command =reader.nextLine();

            if(command.equals("/end")){
                i=-1;
                System.out.println("Дякую за те, що ви пограли в цю гру");
                System.out.println("До зустрічі і щасти вам!");
                break;
            }
            else
            if(command.equals("/info")) {
                char c;
                System.out.println("А тепер виберіть дроїда про якого хочете знати. Серед варіантів є: \nДроїд(1), РПГ-дроїд(2), Снайпер(3), Щитоносець(4), Інженер(5) і Підривник(6). \nДля детальної інформації введіть номер класу, або 0 щоб пропустити.");
                while ((c = reader.next().charAt(0)) != '0') {
                    String info = "";
                    Droid Y=new Droid();
                    if (c == '1') {
                        info = "Просто дроїд. Простий клас бойових дроїдів. \nЗдоров'я 125, максимальна заподіяна шкода 30. Здатен відновлювати своє здоров'я.\n";
                        Y=new Droid();
                    }
                    if (c == '2'){
                        info = "РПГ-Дроїд. Здоров'я рівне 50, а наносить 150 урона. \nНа жаль, цей дроід працює як ОПОЛЧЄНІЄ ДАНБАССА, тому шанс того, що він виживе після свого ходу дуже малий\n";
                        Y=new RPG_Droid();
                    }
                    if (c == '3'){
                        info = "Снайпер. Дроїд з покращеним прицілом, але з погіршеною пересувною здатністю.\nЦей дроїд може ослабити ворога, або повністю убити його. Шкода 50, Здоров'я 150\n";
                        Y=new Sniper();
                    }
                    if (c == '4'){
                        info = "Щитоносець. Цей дроїд найсміливіший серед усіх інших.\nВін здатен узяти усю лють ворога на себе і не дати їй задіти важливих дроїдів. \nНе хвилюйтеся, ви ще можете врятувати його від такої безглуздої смерті, просто замінюйте його пластини.\nКількість очок здоров'я 300\n";
                        Y=new Shield();
                    }
                    if (c == '5'){
                        info = "Інженер. А це незамінний дроїд для поля битви. Саме він допомагає дроїдам прожити ще довше на полі бою. \nВін ремонтує усі неполадки, перестановлює віндовс та змащує деталі.\nЗдоров'я 150\n";
                        Y=new Engineer();
                    }
                    if (c == '6'){
                        info = "Підривник.\nЦей дроїд, не просто запалює седця жінок та деяких чоловіків, а ще й розриває їх на шматки. \nВ обоймі 5 набоїв шкодою близько 30 одиниць кожен, мало що витримає таку вибухову силу. Здоров'я 200\n";
                        Y=new BomberDroid();
                    }
                    else {
                        System.out.println("Помилка введення, повторіть знову");
                    }
                    System.out.println(info);
                    Y.Info();
                    System.out.println("Якщо вам потрібно інформацію ще про якийсь клас, то ведіть його номер, якщо ні, то введіть 0.");
                    System.out.println("Дроїд - 1, Броньована машина - 2, Снайпер - 3,");
                    System.out.println("Щитоносець - 4, Інженер - 5, Підривник - 6");
                }
            }
            else
            if(command.equals("/create")){
                boolean  j=true;
                System.out.println("Запускаємо створення вашого дроїда");
                while(j) {
                    list[i] = Create();
                    i++;
                    System.out.println("Дроїда було створено");
                    System.out.println("Не бажаєте створити ще одного?");
                    System.out.println("Введіть 'Yes' якщо так, та 'No' якщо ні");
                    command =reader.nextLine();
                    if(command.equals("Yes"))System.out.println("Тоді продовжуємо!");
                    else j=false;
                }
            }
            else
            if(command.equals("/versus")){
                if(i==0) {
                    System.out.println("У вас ще немає створених дроїдів");
                    Stop();
                }
                else {
                    System.out.println("Для початку битви вам слід вибрати дроїдів які будуть змагатися");
                    System.out.println("Це список ваших дроїдів");
                    PrintList(list, i);
                    int n=0,m=0;
                    while(n==0){
                        System.out.println("Вкажіть номер дроїда, якого долучити до гри");
                        n=reader.nextInt();
                        if(n>i){
                            System.out.println("Під вказаним номером не існує дроїда");
                            n=0;
                        }
                    }
                    while(m==0){
                        System.out.println("Вкажіть номер дроїда, з яким буде змагатися перший");
                        m=reader.nextInt();
                        if(m>i){
                            System.out.println("Під вказаним номером не існує дроїда");
                            m=0;
                        }
                        if(m==n){
                            System.out.println("Дроїд не може битися сам з собою, виберіть іншого");
                            m=0;
                        }
                    }
                    One(list[n-1],list[m-1],Name1,Name2,comp);
                }
            }
            else
            if(command.equals("/battle")){
                Droid[] Hero=new Droid[5];
                Droid[] Evil=new Droid[5];
                int j=0;
                int n;
                while(j<5){
                    System.out.println("Вкажіть номер дроїда, якого долучити до першої команди");
                    n=reader.nextInt();
                    if(n>i)
                        System.out.println("Під вказаним номером не існує дроїда");
                    else Hero[j]=list[n-1];
                    j++;
                }
                bubbleSort(Hero);
                PrintList(Hero,5);
                j=0;
                while(j<5){
                    System.out.println("Вкажіть номер дроїда, якого долучити до іншої команди");
                    n=reader.nextInt();
                    if(n>i)
                        System.out.println("Під вказаним номером не існує дроїда");
                    else Evil[j]=list[n-1];
                    j++;
                }
                bubbleSort(Evil);
                PrintList(Evil,5);
                Team(Hero,Evil,Name1,Name2,comp);
            }
            else
            if(command.equals("/list")){
                PrintList(list,i);
                Stop();
            }
            else
            if(command.equals("/delete")){
                PrintList(list,i);
                System.out.println("Введіть номер дроїда, якого хочете видалити");
                System.out.println("Введіть '0' для скасування дії");
                int m=reader.nextInt();
                if(m!=0) {
                    m--;
                    Delete(list, i, m);
                    i--;
                }else System.out.println("Дію скасовано");
                Stop();
            }
            else
                System.out.println("Помилка введення\nПеревірте правильність введення");


        }
        System.out.println("Завершення програми");
    }

    public static void One(Droid Hero, Droid Evil, String Name1, String Name2,boolean comp){
        System.out.println("Початок бою");
        System.out.println("Справа "+Hero.Name);
        System.out.println("Зліва "+Evil.Name);
        int j=0;
        while(Hero.hp*Evil.hp!=0){
            System.out.println("Хід гравця:"+Name1);
            AttackOne(Hero,Evil,false);
            System.out.println("Хід гравця:"+Name2);
            AttackOne(Evil,Hero,comp);
            Hero.EndOfMove();
            Evil.EndOfMove();
            j++;
            System.out.println("Здоров'я дроїда "+Hero.Name+ " рівна "+Hero.hp);
            System.out.println("Здоров'я дроїда "+Evil.Name+ " рівна "+Evil.hp);
            Stop();
        }
        System.out.println("Битва завершена");
        if(!Hero.life)System.out.println("Переміг гравець:"+Name2);
        else System.out.println("Переміг гравець:"+Name1);
        System.out.println("Битва заняла "+j+" ходи");
        Stop();
        Hero.EndOfGame();
        Evil.EndOfGame();
    }

    public static void AttackOne(Droid Hero, Droid Evil,boolean comp) {
        Hero.Info();
        String command;
        Scanner reader = new Scanner(System.in);
        if (Hero.ClassNumber == 2) {
            if (comp) {
                if (Hero.hp + 15 < Hero.maxHp) {
                    double k = Math.random() * 10;
                    int n = (int) k;
                    if (k <= 5) Hero.Protect(Hero);
                } else
                    Hero.Attack(Evil, 0);
            } else {
                System.out.println("Для атаки введіть '/attack' для іншої дії введіть '/protect'");
                command = reader.nextLine();
                if (command.equals("/attack")) Hero.Attack(Evil, 0);
                else Hero.Protect(Hero);
            }
        }
        else if (Hero.ClassNumber == 5) {
            if (comp) {
                double k = Math.abs(0.5 - Math.random()) * 100;
                int n = (int) k;
                if (n % 7 <= 3) Hero.Attack(Evil, 1);
                else if (n % 7 <= 5) Hero.Attack(Evil, 2);
                else
                    Hero.Attack(Evil, 3);
            } else {
                System.out.println("Для атаки першого типу введіть '/attack1'");
                System.out.println("Для атаки другого типу введіть '/attack2'");
                System.out.println("Для атаки третього типу введіть '/attack3'");
                command = reader.nextLine();
                if (command.equals("/attack1")) Hero.Attack(Evil, 1);
                else if (command.equals("/attack2")) Hero.Attack(Evil, 2);
                else
                    Hero.Attack(Evil, 3);
            }
        }
        else if (Hero.ClassNumber == 3) Hero.Attack(Evil, 0);
        else if (Hero.ClassNumber == 0) Hero.Attack(Evil, -1);
        else if (Hero.ClassNumber == 4) Hero.Attack(Evil, 0);
        else if (Hero.ClassNumber == 1) {
            if (comp) {
                if (Hero.hp + 15 < Hero.maxHp) {
                    double k = Math.abs(0.5 - Math.random()) * 10;
                    int n = (int) k;
                    if (k <= 5) Hero.Protect(Hero);
                } else
                    Hero.Attack(Evil, 0);
            } else {
                System.out.println("Для атаки введіть '/attack' для іншої дії введіть '/protect'");
                command = reader.nextLine();
                if (command.equals("/attack")) Hero.Attack(Evil, 0);
                else Hero.Protect(Hero);
            }
        }
        if(Hero.hp<0)Hero.hp=0;
        if(Evil.hp<=0)Evil.hp=0;
    }

    public static void Stop(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Натисніть Enter щоб продовжити");
        String c=reader.nextLine();
    }

    public static void PrintList(Droid []list, int n){
        if(n==0)System.out.println("У вас ще немає створених дроїдів");
        for(int j=0;j<n;j++)list[j].Write();
    }

    public static Droid Create(){
        Droid X=new Droid();
        Scanner reader = new Scanner(System.in);
        System.out.println("Для вибору вашого персонажа напишіть цифру, яка йому відповідає");
        System.out.println("Дроїд - 1, РПГ-Дроїд - 2");
        System.out.println("Снайпер - 3, Щитоносець - 4");
        System.out.println("Інженер - 5, Підривник - 6");
        char c=reader.next().charAt(0);
        if (c=='1') X=new Droid();
        if (c=='2')X=new RPG_Droid();
        if (c=='3')X=new Sniper();
        if (c=='4')X=new Shield();
        if (c=='5')X=new Engineer();
        if (c=='6')X=new BomberDroid();
        double m=(int) 4*Math.random();
        int n=(int)m;
        if (n==0)System.out.println("Тепер назвіть дроїда\n");
        if (n==1)System.out.println("Найважливіша частина! Дайте дроїду ім'я!\n");
        if (n==2)System.out.println("Як ви човен назвете, так він і попливе.\n Назвіть дроїда\n");
        if (n==3)System.out.println("Кожен дроїд чекає на цей момент.\nМомент в який у нього з'являєтся ім'я. Назвіть його\n");
        String name =reader.nextLine();
        name =reader.nextLine();
        X.Naming(name);
        return X;
    }

    public static void Team(Droid[] Hero,Droid[] Evil,String Name1,String Name2,boolean comp){
        System.out.println("Початок бою");
        System.out.println("Справа "+Name1);
        System.out.println("Зліва "+Name2);
        int j=0;
        while(SumHp(Hero,5)*SumHp(Evil,5)!=0){
            for(int i=0;i<5;i++) {
                System.out.println("Хід гравця:" + Name1);
                System.out.println("Дроїд:" + Hero[i].Name);
                if(Hero[i].life){
                    if(Hero[i].ClassNumber<3)AttackTeam2(Hero[i], Hero,Evil, false,i);
                    else
                        AttackTeam(Hero[i], Evil, false);
                } else System.out.println("На жаль, "+Hero[i].Name+" загинув");
                if(Evil[i].life) {
                    System.out.println("Хід гравця:" + Name2);
                    System.out.println("Дроїд:" + Hero[i].Name);
                    if (Evil[i].ClassNumber < 3) AttackTeam2(Evil[i], Evil, Hero, comp,i);
                    else
                        AttackTeam(Evil[i], Hero, comp);
                } else System.out.println("На жаль, "+Evil[i].Name+" загинув");
            }
            for(int i=0;i<5;i++){
                System.out.println("Здоров'я дроїда "+Hero[i].Name+ " рівна "+Hero[i].hp);
            }
            System.out.println(" ");
            for(int i=0;i<5;i++){
                System.out.println("Здоров'я дроїда "+Evil[i].Name+ " рівна "+Evil[i].hp);
            }
        }
        System.out.println("Битва завершена");
        if(SumHp(Hero,5)==0)System.out.println("Переміг гравець:"+Name2);
        else System.out.println("Переміг гравець:"+Name1);
        System.out.println("Битва заняла "+j+" ходи");
        Stop();
        for(int i=0;i<5;i++) {
            Hero[i].EndOfGame();
            Evil[i].EndOfGame();
        }
    }

    public static void AttackTeam(Droid Hero,Droid Evil[],boolean comp) {
        Hero.Info();
        String command;
        Scanner reader = new Scanner(System.in);
        Droid X=Random(Evil,5);
        if (Hero.ClassNumber == 3) {
            if(comp){
                double k=Math.random()*100;
                int x=(int)k;
                if(x%2==1)X=SmallestHp(Evil,5);
            } else
                X=Who(Evil);
            if(X.shield!=-1){
                System.out.println(X.Name+"захищено щитом");
                X=Evil[X.shield];
            }
            Hero.Attack(X,0);
        }
        else
        if (Hero.ClassNumber == 5) {
            if(comp){
                double k=Math.random()*100;
                int x=(int)k;
                if(x%2==1)X=SmallestHp(Evil,5);
                if(X.shield!=-1){
                    System.out.println(X.Name+"захищено щитом");
                    X=Evil[X.shield];
                }
                if(x%10<5)Hero.Attack(X,1);
                else
                if(x%10<8)Hero.Attack(X,2);
                else
                if(x%10<9)Hero.Attack(X,3);
            } else {
                X=Who(Evil);
                System.out.println("Для атаки першого типу введіть '/attack1'");
                System.out.println("Для атаки другого типу введіть '/attack2'");
                System.out.println("Для атаки третього типу введіть '/attack3'");
                command = reader.nextLine();
                if(X.shield!=-1){
                    System.out.println(X.Name+"захищено щитом");
                    X=Evil[X.shield];
                    if (command.equals("/attack1")) Hero.Attack(X, 1);
                    else if (command.equals("/attack2")) Hero.Attack(X, 2);
                    else
                        Hero.Attack(X, 3);
                }
            }
        }
        else
        if (Hero.ClassNumber == 4){
            if(comp) {
                double k = Math.random() * 100;
                int x = (int) k;
                if (x % 2 == 1) X = SmallestHp(Evil, 5);
                if (x % 10 < 7){
                    if (X.shield != -1) {
                        System.out.println(X.Name + "захищено щитом");
                        X = Evil[X.shield];
                        X.Attack(X, 1);
                    }
                } else{
                    for(int i=0;i<5;i++) {
                        if (Evil[i].life) {
                            X = Evil[i];
                            if (X.shield != -1) {
                                System.out.println(X.Name + "захищено щитом");
                                X = Evil[X.shield];
                            }
                            X.Attack(X, 5);
                        }
                    }
                }
            } else
            {
                System.out.println("Для атаки першого типу введіть '/attack1'");
                System.out.println("Для атаки другого типу введіть '/attack2'");
                command = reader.nextLine();
                if (command.equals("/attack1")) {
                    X=Who(Evil);
                    if (X.shield != -1) {
                        System.out.println(X.Name + "захищено щитом");
                        X = Evil[X.shield];
                    }
                    Hero.Attack(X, 1);
                }
                else if (command.equals("/attack2"))
                    for(int i=0;i<5;i++) {
                        if (Evil[i].life) {
                            X = Evil[i];
                            if (X.shield != -1) {
                                System.out.println(X.Name + "захищено щитом");
                                X = Evil[X.shield];
                            }
                            X.Attack(X, 5);
                        }
                    }
            }
        }
        for(int i=0;i<5;i++)
            if(Evil[i].hp<=0){
                Evil[i].hp=0;
                Evil[i].Death();
            }
    }

    public static void AttackTeam2(Droid h,Droid[] Hero,Droid[] Evil,boolean comp,int n){
        h.Info();
        String command;
        Scanner reader = new Scanner(System.in);
        Droid X=Random(Evil,5);
        if (h.ClassNumber == 0){
            if(!comp) {
                System.out.println("Для атаки введіть '/attack'");
                System.out.println("Для захисту введіть '/protect'");
                command = reader.nextLine();
                if (command.equals("/attack")) {
                    X = Who(Evil);
                    if (X.shield != -1) {
                        System.out.println(X.Name + "захищено щитом");
                        X = Evil[X.shield];
                    }
                    h.Attack(X, -1);
                } else {
                    X=Whom(Hero);
                    h.Attack(X, n);
                }
            }
            else{
                double k=Math.random()*100;
                int x=(int)k;
                if(x%3==1){
                    if(x%2==1)X=SmallestHp(Hero,5);
                    else X=Random(Hero,5);
                    h.Attack(X, n);
                }
                else {
                    if(x%2==0)X=SmallestHp(Evil,5);
                    else X=Random(Evil,5);
                    h.Attack(X, -1);}

            }
        } else
        if (h.ClassNumber == 2){
            if(!comp) {
                System.out.println("Для атаки введіть '/attack'");
                System.out.println("Для зміни броньованої пластини '/protect'");
                command = reader.nextLine();
                if (command.equals("/attack")) {
                    X = Who(Evil);
                    if (X.shield != -1) {
                        System.out.println(X.Name + "захищено щитом");
                        X = Evil[X.shield];
                    }
                    h.Attack(X, -1);
                } else {
                    X=Whom(Hero);
                    h.Protect(X);
                }
            }else{
                double k=Math.random()*100;
                int x=(int)k;
                if(x%3==1){
                    if(x%2==1)X=SmallestHp(Hero,5);
                    else X=Random(Hero,5);
                    h.Attack(X, 5);
                }
                else {
                    if(x%2==0)X=SmallestHp(Hero,5);
                    else X=Random(Hero,5);
                    h.Attack(X, 5);}
            }
        }
        else if (h.ClassNumber == 1){
            if(!comp) {
                System.out.println("Для атаки введіть '/attack'");
                System.out.println("Для відноілення витривалості введіть '/protect'");
                System.out.println("Для відновлення витривалості команди введіть '/heal'");
                command = reader.nextLine();
                if (command.equals("/attack")) {
                    X = Who(Evil);
                    if (X.shield != -1) {
                        System.out.println(X.Name + "захищено щитом");
                        X = Evil[X.shield];
                    }
                    h.Attack(X, -1);
                } else if (command.equals("/protect")){
                    X = Whom(Hero);
                    h.Protect(X);
                } else
                    for(int i=0;i<5;i++){
                        if(Hero[i].life) h.Attack(Hero[i],5);
                    }
            }
            else {
                double k = Math.random() * 100;
                int x = (int) k;
                if (x % 2 == 1) {
                    k = Math.random() * 100;
                    x = (int) k;
                    if (x % 6 <1)
                        for(int i=0;i<5;i++){
                            if(Hero[i].life) h.Attack(Hero[i],5);
                        }
                    else if (x % 6 <4) {
                        if (x % 2 ==1) X = SmallestHp(Hero, 5);
                        else X = Random(Hero, 5);
                        h.Protect(X);
                    } else{
                        if (x % 2 ==1) X = SmallestHp(Evil, 5);
                        else X = Random(Evil, 5);
                        h.Attack(X,0);
                    }

                }
            }
        }
        for(int i=0;i<5;i++)
            if(Evil[i].hp<=0)
            {
                Evil[i].hp=0;
                Evil[i].Death();
            }
    }

    public static Droid SmallestHp(Droid[] X, int n){
        Droid min=new Droid();
        min.hp=200;
        for(int i=1;i<n;i++)
            if(X[i].hp>0)
                if(min.hp>X[i].hp)min=X[i];

        return min;
    }

    public static Droid Random(Droid[] X, int n){
        Droid m=X[0];
        double k=Math.random()*100;
        int x=(int)k;
        if(x<20)m=X[4];
        else
        if(x<40)m=X[3];
        else
        if(x<60)m=X[2];
        else
        if(x<80)m=X[1];
        return m;
    }

    public static void bubbleSort(Droid[] array) {
        boolean sorted = false;
        Droid temp=new Droid();
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < 5 - 1; i++) {
                if (array[i].ClassNumber > array[i+1].ClassNumber) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static int SumHp(Droid[] X,int n){
        int sum=0;
        for(int i=0;i<n;i++)sum+=X[i].hp;
        return sum;
    }

    public static Droid Who(Droid[] X){
        String command;
        Scanner reader = new Scanner(System.in);
        System.out.println("Час вибирати, на кого піде наступна атака");
        System.out.println("Введіть '/random' для атаки на випадкового гравця");
        System.out.println("Введіть '/small' для атаки на гравця з найменшою кількістю витривалості");
        System.out.println("Введіть '/choise' для вибору");
        command =reader.nextLine();
        if(command.equals("/small"))return SmallestHp(X, 5);
        if(command.equals("/random"))return Random(X, 5);
        for(int i=1;i<6;i++)
            System.out.println("Для атаки на " + X[i-1].Name+" введіть "+i);
        int m= reader.nextInt();
        return X[m-1];
    }

    public static Droid Whom(Droid[] X){
        String command;
        Scanner reader = new Scanner(System.in);
        System.out.println("Час вибирати, на кого піде наступна дія");
        System.out.println("Введіть '/random' для дійства над випадковим гравцем");
        System.out.println("Введіть '/small' для дійства над гравцем з найменшою кількістю витривалості");
        System.out.println("Введіть '/choise' для вибору");
        command =reader.nextLine();
        if(command.equals("/small"))return SmallestHp(X, 5);
        if(command.equals("/random"))return Random(X, 5);
        for(int i=1;i<6;i++)
            System.out.println("Для дії над " + X[i-1].Name+" введіть "+i);
        int m= reader.nextInt();
        return X[m-1];
    }

    public static void Delete(Droid[] X,int n,int m){
        for(int i=0;i<n;i++)
            if(i>m)X[i-1]=X[i];
    }
} 