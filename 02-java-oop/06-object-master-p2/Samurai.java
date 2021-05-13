public class Samurai extends Human{
    protected static int counter = 0;
    public Samurai(int health){
        super(health);
        this.health = 200;
        counter ++;
    }
    public void deathBlow(Human destroyed){
        destroyed.health = 0;
        this.health = (this.health/2); 
        System.out.println("Samurai health decrease:" + this.health) ;
    }
    public void meditate(){
        this.health += (this.health/2);
        System.out.println("Samurai has been healed by:"+ this.health);
    }
    public static int howMany(){
        System.out.println(Samurai.counter);
        return Samurai.counter;
    }

}