
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

// Burger Factory

class BurgerFactory{
     
    public Burger createBurger(String type){
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



public class SimpleFactory {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        String type=sc.next();

        BurgerFactory bf=new BurgerFactory();
        Burger b=bf.createBurger(type);

        if(b!=null){
            b.prepare();
        }
         
    }
    
}
