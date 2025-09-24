
class Singleton{

    private static Singleton singleton=null;

    private Singleton(){
        System.out.println("Object are private");
    }

    public static Singleton getInstance(){
          if(singleton==null){
              singleton=new Singleton();
          }
          return singleton;
    }

}

public class SimpleSingleton {
    public static void main(String[] args) {

        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();

        if(s1.equals(s2)){
            System.out.println("Both Objects are Equals");
        }
        else{
            System.out.println("Both are differents");
        }

    }
}
