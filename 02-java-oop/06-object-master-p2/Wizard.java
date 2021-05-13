public class Wizard extends Human{
    public Wizard(int health){
        super(health);
        this.health = 50;
        this.intelligence = 8;
    }
    public void heal(Human healed){
        healed.health += this.intelligence;
        System.out.println("The human been healed by: " + this.intelligence);
    }
    public void fireball(Human decr){
        decr.health -= (this.intelligence * 3);
        System.out.println("The Ninja health decrease:" + decr.health);
    }
}