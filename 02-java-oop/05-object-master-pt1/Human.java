public class Human{
    protected int strength = 3;
    protected int stealth = 3;
    protected int intelligence = 3;
    protected int health = 100;

    public Human(){
        this.strength = 3;
        this.stealth = 3;
        this.intelligence = 3;
        this.health = 100;
    }

    public Human attack(Human target){
        target.health -= this.strength;
        return target;
    }
    public void displayHealth(){
        System.out.println(this.health);
    }
}