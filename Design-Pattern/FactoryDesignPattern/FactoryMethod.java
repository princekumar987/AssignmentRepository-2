// Burger interface

import java.util.Scanner;

interface Burger{
    void prepare();
}

// concrete burger implementation

class BasicBurger implements Burger{

    @Override
    public void prepare() {
       System.out.println("BasicBurger Ready");
    }
    
}

class StandardBurger implements Burger{

    @Override
    public void prepare() {
       System.out.println("StandardBurger Ready");
    }
    
}



class PremimumBurger implements Burger{

    @Override
    public void prepare() {
       System.out.println("PremiumBurger Ready");
    }
    
}

class BasicWheatBurger implements Burger{

    @Override
    public void prepare() {
       System.out.println("BasicWheatBurger Ready");
    }
    
}

class StandardWheatdBurger implements Burger{

    @Override
    public void prepare() {
       System.out.println("StandardWheatBurger Ready");
    }
    
}

class PremimumWheatBurger implements Burger{

    @Override
    public void prepare() {
       System.out.println("PremiumWheatBurger Ready");
    }
    
}

// Factory interface

interface BergerFactory{
      Burger createBurger(String type);
}

class SinghBurgerFactory implements BergerFactory{

    @Override
    public Burger createBurger(String type) {
        if(type.equalsIgnoreCase("Basic")){
                return new BasicBurger();
             }
             else if(type.equalsIgnoreCase("Standard")){
                return new StandardBurger();
             }
             else if(type.equalsIgnoreCase("Premium")){
                return new PremimumBurger();
             }
             else{
                System.out.println("Invalid Burger Type!");
                return null;
             }
    }

}

class KingBurgerFactory implements BergerFactory{

    @Override
    public Burger createBurger(String type) {
        if(type.equalsIgnoreCase("Basic")){
                return new BasicWheatBurger();
             }
             else if(type.equalsIgnoreCase("Standard")){
                return new StandardWheatdBurger();
             }
             else if(type.equalsIgnoreCase("Premium")){
                return new PremimumWheatBurger();
             }
             else{
                System.out.println("Invalid Burger Type!");
                return null;
             }
    }

}


public class FactoryMethod {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        String type=sc.next();

        BergerFactory bf =new KingBurgerFactory();

        Burger b=bf.createBurger(type);

        if(b!=null){
            b.prepare();
        }

    }
    
}