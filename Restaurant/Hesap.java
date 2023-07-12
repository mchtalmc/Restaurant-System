package day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hesap {
    private ArrayList<Order> orders = new ArrayList<>();//  [1001, 1002, 1003, 1004]

    public void addOrder(Order order) {
        orders.add(order);
    }
    public double getTotalAmount(){//toplam siparis tutari
        return orders.//[1001, 1002, 1003, 1004]
                stream().
                mapToDouble(Order ::getTotalAmount).
                sum();
    }

    public void printHesap(){
        System.out.println("********************* HESAP FISI *****************************");
//
        for (Order order :orders ) {//[1001, 1002, 1003, 1004]
            System.out.println("Siparis kodu : "+order.getOrderCode());
            System.out.print("Yiyecekler : ");
            HashMap<MenuItem,Integer> items = order.getItems();

            for (Map.Entry <MenuItem, Integer> entry : items.entrySet()) {//items  {Hamburger,2}
                MenuItem item= entry.getKey();//item==> Hamburger
                int adet =entry.getValue();//adet ==>2
                System.out.printf("%-20s  %d x   %.2f TL ",
                        item.getName(),adet,item.getPrice());//formatli yazdirir
                //% formatli olarak yazdirir -  sola yasla 20 karakter ayir s==>String data
                // d==> tamsayi  %.2==> virgulden sonra 2 basamak yazdir  f ==> ondalikli sayilar icin
            }
            System.out.println(order.getTotalAmount());
        }//for each tum yiyecekler
        System.out.println(getTotalAmount());



    }
}
