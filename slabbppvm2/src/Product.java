public class Product {
        private int id,Price, Best_before,quantity;
        private String Producer,Name;

        Product(){

        }
        Product(int ID, int price, int bestBF,int qtt, String nm, String prod){
                id=ID;
                Price=price;
                Best_before=bestBF;
                quantity=qtt;
                Name=nm;
                Producer=prod;
        }

        public void Set_Naming(String a){
                this.Name=a;
            }
        public String Get_Naming(){
                return this.Name;
            }

        public void Set_Naming_Producer(String a){
                this.Producer=a;
            }
        public String Get_Naming_Producer(){
                return this.Producer;
            }
            public void Set_Id(int a){
                this.id=a;
            }
            public int Get_Id(){
                return this.id;
            }
            public void Set_Price(int a){
                this.Price=a;
            }
            public int Get_Price(){
                return this.Price;
            }
            public void Set_Best_before(int a){
                this.Best_before=a;
            }
            public int Get_Best_before(){
                return this.Best_before;
            }
            public void Set_quantity(int a){
                this.quantity=a;
            }
            public int Get_quantity(){
                return this.quantity;
            }
            @Override public String toString() {
                    return "Product{" + "id='" + id + "', price='" + Price + "',  Best_before='" +  Best_before + "', quantity='" + quantity  + "', named='" + Name +  "', producer='" +  Producer  + "'}"; 
        }
       
              

}
