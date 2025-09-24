

class SingletonEager{

    private static SingletonEager singleton=new SingletonEager();

    private SingletonEager(){
        System.out.println("private Constructor");
    }

    public static SingletonEager getInstance(){
         return singleton;
    }

}

public class ThreadSafeEagerSingleton {
    public static void main(String[] args) {

        SingletonEager s1=SingletonEager.getInstance();
        SingletonEager s2=SingletonEager.getInstance();

        if(s1.equals(s2)){
            System.out.println("Both Objects Are Equals");
        }
        else{
            System.out.println("Both Objects are Differents");
        }

    }
}
