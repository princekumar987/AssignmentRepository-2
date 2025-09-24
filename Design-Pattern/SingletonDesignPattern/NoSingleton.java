
class NoSingetonTest{

    public NoSingetonTest(){
        System.out.println("New Object is Created");
    }
}
public class NoSingleton {
    public static void main(String[] args) {

        NoSingetonTest n1=new NoSingetonTest();
        NoSingetonTest n2=new NoSingetonTest();

        if(n1.equals(n2)){
            System.out.println("Object are Equals");
        }
        else{
            System.out.println("Both are Different Object");
        }
    }
}
