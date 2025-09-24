
//command interface

interface Command{
     void execute();
     void undo();
}

//Receivers class

class Light{

     public void on(){
         System.out.println("Light is On");
     }

     public void off(){
         System.out.println("Light is Off");
     }

}

class Fan{

    public void on(){
        System.out.println("Fan is On");
    }

    public void off(){
        System.out.println("Fan is Off");
    }

}

// concrete command for light

class LightCommand implements Command{

    private Light light;

    public LightCommand(Light light){
        this.light=light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class FanCommand implements Command{

    private Fan fan;

    public FanCommand(Fan fan){
        this.fan=fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}


//RemoteController

class RemoteController{

    private static final int numButtons=4;
    private Command[]buttons;
    private boolean []buttonPressed;

    public RemoteController(){
        buttons=new Command[numButtons];
        buttonPressed=new boolean[numButtons];
        for(int i=0;i<numButtons;i++){
            buttons[i]=null;
            buttonPressed[i]=false;
        }
    }

    public void setCommand( int idx, Command cmd){
          if(idx>=0 && idx<numButtons){
              buttons[idx]=cmd;
              buttonPressed[idx]=false;
          }
    }

    public void pressButton(int idx) {
        if (idx >= 0 && idx < numButtons && buttons[idx] != null) {
            if (!buttonPressed[idx]) {
                buttons[idx].execute();
            } else {
                buttons[idx].undo();
            }
            buttonPressed[idx] = !buttonPressed[idx];
        } else {
            System.out.println("No command assigned at button " + idx);
        }
    }


}


public class CommandDesignPattern {
    public static void main(String[] args) {

        Light livinglight=new Light();
        Fan fan=new Fan();

        RemoteController rm=new RemoteController();

        rm.setCommand(0, new LightCommand(livinglight));
        rm.setCommand(1,new FanCommand(fan));

        System.out.println("Toggling Light button 0");
        rm.pressButton(0);
        rm.pressButton(0);

        System.out.println("Toggling Fan button 1");
        rm.pressButton(1);
        rm.pressButton(1);

        System.out.println("Pressing wrong buttons");
        rm.pressButton(2);

    }
}
