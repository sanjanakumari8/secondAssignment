import java.util.*;


class PurchaseCarProject {
    public static void main(String[] args) {
        ArrayList<Customer> list = new ArrayList<Customer>();
        Scanner obj = new Scanner(System.in);

        int num;
        do {
            System.out.println("Select your option:  1: for add customer 2: display Customer 3 : check customer By Id 4:Add car to existing customer 5:sorted customer list 6:Generate random price for existing customer  0:exit");
            num = obj.nextInt();
            switch (num) {

                case 1:
                    list.add(new Customer());
                    break;
                case 2:
                    for (int i = 0; i < list.size(); i++) {

                        System.out.println("Customer Id: " + list.get(i).getCustomerId() + "  customer Name: " + list.get(i).getCustomerName());
                        for (Car car : list.get(i).getCarlist()) {
                            System.out.println(car.getCarId());
                            System.out.println(car.getCarName());
                            System.out.println(car.getCarPrice());
                            System.out.println(car.getResalePrice());


                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter Id of Customer");
                    Scanner obj3 = new Scanner(System.in);
                    int id = obj3.nextInt();
                    for (int i = 0; i < list.size(); i++) {

                        if (list.get(i).getCustomerId() == id) {

                            System.out.println("Customer Id: " + list.get(i).getCustomerId() + "  customer Name: " + list.get(i).getCustomerName());
                        } else {

                            System.out.println("Customer id not existed");
                        }

                    }break;
                case 4:
                    Scanner check = new Scanner(System.in);
                    System.out.println("Enter customer id");

                    int input = check.nextInt();

                    System.out.println("1 for Maruti");
                    System.out.println("2 for Tyota");
                    System.out.println("3 for Hyundai");
                    System.out.println("enter car type");
                    int carProvider=check.nextInt();
                 //   int carId=0;
                    Scanner provide=new Scanner(System.in);

                    System.out.println("Enter the car Id,  car model,car price");
                    int carId=(new Scanner(System.in)).nextInt();
                    String carName=(new Scanner(System.in)).nextLine();
                    int carPrice=(new Scanner(System.in)).nextInt();


                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getCustomerId() == input) {
                            Customer customer = list.get(i);
                            ArrayList<Car> cars = customer.getCarlist()
;
                            Car newCar=null;
                            
                            if(carProvider==1)
                            {newCar=new Maruti(carId,carName,carPrice);}
                            else if(carProvider==2)
                            {newCar=new Tyota(carId,carName,carPrice);}
                            else if(carProvider==3)
                            {newCar=new Hyundai(carId,carName,carPrice);}
                            cars.add(newCar);
                            customer.setCarlist(cars);
                        }
                    }break;
                case 5:
                    Collections.sort(list);
                    for (int i = 0; i < list.size(); i++) {

                        System.out.println("Customer Id: " + list.get(i).getCustomerId() + "  customer Name: " + list.get(i).getCustomerName());
                        for(Car car : list.get(i).getCarlist()){
                            System.out.println(car.getCarId());
                            System.out.println(car.getCarName());
                            System.out.println(car.getCarPrice());


                        }
                    }break;
                case 6:
            Random rand=new Random();
                    System.out.println("Enter your three choices according to your own");
                    int num1=obj.nextInt();
                    int num2=obj.nextInt();
                    int num3=obj.nextInt();
                    int a[]=new int[6];
                    for(int i=0;i<list.size();i++){
                        int index=rand.nextInt(list.size());
                        a[i]=list.get(index).getCustomerId();
                    }
                    for(int i=0;i<list.size();i++){
                        if(a[i]==1){
                            System.out.println("Lucky one is:"+ num1);
                            break;
                        }
                        if(a[i]==2){
                            System.out.println("Lucky one is:"+ num2);
                            break;
                        }
                        if(a[i]==3){
                            System.out.println("Lucky one is:"+ num3);
                            break;
                        }
                    }

            }

        } while (num != 0);
    }
}

 class Customer implements Comparable<Customer>{
    int customerId;
    String customerName;

    ArrayList<Car> carlist;

    public Customer() {

        Scanner obj1 = new Scanner(System.in);
        Scanner obj2 = new Scanner(System.in);
        System.out.println("Enter id and name:");
        customerId = obj1.nextInt();
        customerName = obj2.next();
        this.carlist = new ArrayList<Car>();

    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Car> getCarlist() {
        return carlist;
    }

    public void setCarlist(ArrayList<Car> carlist) {
        this.carlist = carlist;
    }

    public int compareTo(Customer o) {
        int compareInt = this.customerName.compareTo(o.customerName);
        if (compareInt < 0)
        {
            return -1;
        } if (compareInt > 0)
        {   return 1;}
        return 0;


    }
}

abstract class Car{
    int carId;
    String  carName;
    int carPrice;
    public Car(){

    }

    public int getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPrice() {
        return carPrice;
    }

    abstract int getResalePrice();
} class Maruti extends Car{

    public Maruti(final int carId, final String carName, final int carPrice ){
        this.carId=carId;
        this.carName=carName;
        this.carPrice=carPrice;
    }
    @ Override
    int getResalePrice() {
        return (int) (carPrice*0.80);
    }

}
 class Tyota extends Car{

     public Tyota(final int carId, final String carName, final int carPrice ){
        this.carId=carId;
        this.carName=carName;
        this.carPrice=carPrice;
        }
            @ Override
                    int getResalePrice() {
                        return (int) (carPrice*0.60);
                    }

}
 class Hyundai extends Car{

     public Hyundai(final int carId, final String carName, final int carPrice ){
        this.carId=carId;
        this.carName=carName;
        this.carPrice=carPrice;
        }
        @ Override
            int getResalePrice() {
                    return (int) (carPrice*0.40);
                    }

}

