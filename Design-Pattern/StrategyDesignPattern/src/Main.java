

// strategy interface for walk

interface WalkableRobot{
     void walk();
}

class NoramlWalk implements  WalkableRobot{

    @Override
    public void walk() {
        System.out.println("walking Robot Normally");
    }
}


class NoWalk implements  WalkableRobot{

    @Override
    public void walk() {
       System.out.println("No Walking Robot");
    }
}

//strategy interface for talk

interface TalkableRobot{
     void talk();
}

class NormalTalk implements  TalkableRobot{

    @Override
    public void talk() {
         System.out.println("Normally Talking Robot");
    }
}

class NoTalk implements  TalkableRobot{

    @Override
    public void talk() {
        System.out.println("No Talking Robot");
    }
}

// strategy interface for Fly

interface FlyableRobot{
    void fly();
}

class NormalFly implements  FlyableRobot{

    @Override
    public void fly() {
         System.out.println("Normally Fly Robot");
    }
}

class NoFly implements  FlyableRobot{

    @Override
    public void fly() {
        System.out.println("No Fly Robot");
    }
}

// Robot Base Class

abstract class Robot {

    WalkableRobot w;
    TalkableRobot t;
    FlyableRobot f;

    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f ){
         this.w=w;
         this.t=t;
         this.f=f;
    }

    public void walk(){
        w.walk();
    }

    public void talk(){
        t.talk();
    }

    public void fly(){
        f.fly();
    }

    public abstract void  projection() ;

}

// Robot types class

class CompanionRobot extends  Robot{

    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
         System.out.println("Display CompanionRobot");
    }
}

class WorkerRobot extends  Robot{

    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("Display WorkerRobot");
    }
}



public class Main {
    public static void main(String[] args) {

        Robot r1=new CompanionRobot(new NoramlWalk(),new NormalTalk(), new NoFly());
        System.out.println("Robot r1----------------");
        r1.walk();
        r1.talk();
        r1.fly();
        r1.projection();

        Robot r2=new WorkerRobot(new NoWalk(), new NormalTalk(), new NormalFly());
        System.out.println("Robot r2----------------");
        r2.walk();
        r2.talk();
        r2.fly();
        r2.projection();


    }
}