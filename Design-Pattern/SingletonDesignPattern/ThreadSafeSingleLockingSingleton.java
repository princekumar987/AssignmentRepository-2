

class SingletonSingleLocking{

    private static SingletonSingleLocking singletonSingleLocking=null;

    private SingletonSingleLocking(){
        System.out.println("private constructor");
    }

    public static SingletonSingleLocking getInstance(){
         synchronized (SingletonSingleLocking.class){
              if(singletonSingleLocking==null){
                  singletonSingleLocking=new SingletonSingleLocking();
              }
              return singletonSingleLocking;
         }
    }

}



public class ThreadSafeSingleLockingSingleton {
    public static void main(String[] args) {

        SingletonSingleLocking s1=SingletonSingleLocking.getInstance();
        SingletonSingleLocking s2=SingletonSingleLocking.getInstance();

        if(s1==s2){
            System.out.println("Both Objects are Equals");
        }
        else{
            System.out.println("Both Objects are different");
        }


    }
}
