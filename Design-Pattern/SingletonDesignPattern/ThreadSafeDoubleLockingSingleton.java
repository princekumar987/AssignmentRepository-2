
class SingletonDoubleLocking{

    private static SingletonDoubleLocking singletonDoubleLocking=null;

    private SingletonDoubleLocking(){
        System.out.println("private constructor");
    }

    public static SingletonDoubleLocking getInstance(){
        synchronized (SingletonDoubleLocking.class){
            if(singletonDoubleLocking==null){
                singletonDoubleLocking=new SingletonDoubleLocking();
            }
            return singletonDoubleLocking;
        }
    }

}


public class ThreadSafeDoubleLockingSingleton {

    public static void main(String[] args) {

        SingletonDoubleLocking s1=SingletonDoubleLocking.getInstance();
        SingletonDoubleLocking s2=SingletonDoubleLocking.getInstance();

        if(s1==s2){
            System.out.println("Both Objects are Equals-");
        }
        else{
            System.out.println("Objects Are not Equals");
        }
    }
}
