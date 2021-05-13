public class Ninja extends Human{
    public Ninja(int health){
        super(health);
        this.stealth = 10;
    }
    public void steal(Human stealed){
        stealed.health -= this.stealth;
        this.health += this.stealth;
        System.out.println("The ninja's stealth now is " + this.health);
    }
    public void runAway(){
        this.health -=10;
        System.out.println("Ninja health decrease :" +this.health);
    }
}