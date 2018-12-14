package oop39;

import java.util.Scanner;

public class OOP39 {
    public static void main(String[] args)
    {
        Scanner scanner= new Scanner(System.in);
        products();
        while(true)
        {
            System.out.print("Enter product no. you want to buy or enter 0 calculate total:: ");
            byte pN= scanner.nextByte();
            if(pN==0)
            {
                System.out.println("Total: "+Product.vat+"$");
                break;
            }
            if(pN>6)
            {
                System.out.println("Wrong choice::");
                continue;
            }
            System.out.print("Enter price:: ");
            int price = scanner.nextInt();
            System.out.println("Enter quantity:: ");
            short quantity= scanner.nextShort();
            Product product = new Product(pN,price,quantity);
        }
    }
    static void products()
    {
        System.out.println("Products available in category 1(vat: 20%): ");
        System.out.println("1. Rice");
        System.out.println("2. Egg");
        System.out.println("Products available in category 2(vat: 25%): ");
        System.out.println("3. Bat");
        System.out.println("4. Ball");
        System.out.println("Products available in category 3(vat: 30%): ");
        System.out.println("5. Cake");
        System.out.println("6. Biscuit");
    }
}
final class Product {
    private int price;
    private short amount;
    private byte productId;
    public static double vat;
    public Product(byte productId,int price, short amount)
    {
        this.price = price;
        this.amount = amount;
        this.productId=productId;
        calculateVat();
    }
    public void calculateVat()
    {
        int vatP=0;
        if(this.productId==1||this.productId==2)vatP=20;
        if(this.productId==3||this.productId==4)vatP=25;
        if(this.productId==5||this.productId==6)vatP=30;
        
        double am=this.price*this.amount*vatP/100;
        Product.vat+=am;
    }
}
