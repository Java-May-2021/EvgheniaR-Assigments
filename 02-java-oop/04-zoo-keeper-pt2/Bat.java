public class Bat extends Mammal{
    public Bat(int energyLevel){
        super(energyLevel);
    }
    public void fly(){
        energyLevel -=50;
        System.out.println("The bat is flying and he's energy decrease:"+ this.energyLevel);
    }
    public void eatHumans(){
        energyLevel +=25;
        System.out.println("The bat is eating humans and he's energy increase:" +this.energyLevel);
    }
    public void attackTown(){
        energyLevel -=100;
        System.out.println("The bat attack town and he's energy decease:" + this.energyLevel);
    }
}