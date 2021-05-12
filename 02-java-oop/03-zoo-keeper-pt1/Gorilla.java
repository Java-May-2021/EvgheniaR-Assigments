
public class Gorilla extends Mammal{
    public Gorilla(int energyLevel){
        super(energyLevel);
    }
    public void throwSomething(){
        energyLevel -=5;
        System.out.println("The gorilla throwing stuff and her energy decrease:" + this.energyLevel);
    }
    public void eatBanana(){
        energyLevel +=10;
        System.out.println("Goriilla eating bananas and her energy increase:" + this.energyLevel);
    }
    public void climb(){
        energyLevel -=10;
        System.out.println("Gorilla climbing the trees and her energy increase:" + this.energyLevel);
    }
}