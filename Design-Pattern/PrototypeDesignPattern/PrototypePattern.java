

interface Clonable{
    Clonable clone();
}

class NPC implements  Clonable{

    private String name;
    private int health;
    private int attack;
    private int defense;

    public NPC(String name, int health, int attack, int defense){
         this.name=name;
         this.health=health;
         this.attack=attack;
         this.defense=defense;
    }

    public NPC(NPC n){
         this.name=n.name;
         this.health=n.health;
         this.attack=n.attack;
         this.defense=n.defense;
    }

    @Override
    public Clonable clone() {
        return new NPC(this);
    }

    public void describe() {
        System.out.println("NPC " + name + " [HP=" + health + " ATK=" + attack
                + " DEF=" + defense + "]");
    }

    public void setName(String name){
        this.name=name;
    }

    public void setHealth(int health){
        this.health=health;
    }

    public void setAttack(int attack){
        this.attack=attack;
    }

    public void setDefense(int defense){
        this.defense=defense;
    }

}
public class PrototypePattern {

    public static void main(String[] args) {

        NPC n1=new NPC("simple character",100,10,2);
        System.out.println("first character");
        n1.describe();

        //copy1

        NPC npccopy1=(NPC)n1.clone();
        System.out.println("First Copy Character");
        npccopy1.describe();

        //copy2

        NPC npccopy2=(NPC)n1.clone();
        npccopy2.setName("Powerful Character");
        npccopy2.setHealth(200);
        npccopy2.setAttack(20);
        npccopy2.setAttack(5);
        System.out.println("Second Copy Character");
        npccopy2.describe();



    }
}
