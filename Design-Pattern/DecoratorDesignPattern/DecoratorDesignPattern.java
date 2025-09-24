
// Component Interface: defines a common interface for Mario and all power-up decorators.

interface Character{
    String getAbilities();
}


// Concrete Component: Basic Mario character with no power-ups.
class Mario implements Character{

    @Override
    public String getAbilities() {
        return "Mario";
    }
}

// Abstract Decorator: CharacterDecorator "is-a" Character and "has-a" Character

abstract class CharacterDecorator implements Character{
    protected Character character;

    public CharacterDecorator(Character character){
        this.character=character;
    }
}

class HieghtUp extends  CharacterDecorator{

    public HieghtUp(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return  character.getAbilities()+" With HeightUp";
    }
}

class GunPowerUp extends  CharacterDecorator{

    public GunPowerUp(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return  character.getAbilities()+" with gun";
    }
}

class StarPowerUp extends CharacterDecorator{

    public StarPowerUp(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities()+" with Star Power (Limited Time)";
    }
}


public class DecoratorDesignPattern {

    public static void main(String[] args) {

        // Create a basic Mario character.
        Character mario=new Mario();
        System.out.println("Basic charater:--"+mario.getAbilities());

        mario=new HieghtUp(mario);
        System.out.println("After HeightUp:--"+mario.getAbilities());

        mario=new GunPowerUp(mario);
        System.out.println("After GunPowerUp:--"+mario.getAbilities());

        mario=new StarPowerUp(mario);
        System.out.println("After StarPowerUp:--"+mario.getAbilities());

        System.out.println("2nd Mario only for testing");

        Character mario1=new Mario();
        System.out.println("Basic charater:--"+mario1.getAbilities());

        mario1=new GunPowerUp(mario1);
        System.out.println("After GunPowerUp:--"+mario1.getAbilities());



    }
}
