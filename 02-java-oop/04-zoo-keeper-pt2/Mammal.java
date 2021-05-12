
public class Mammal{
    protected int energyLevel = 100;

    public Mammal(int energyLevel){
        this.energyLevel = energyLevel;
    }
    public Integer displayEnergy(){
        System.out.println("Energy level is:" + this.energyLevel);
        return energyLevel;
    }
}