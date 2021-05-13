
public class SubclassTest {

	public static void main(String[] args) {
        Human human1 = new Human(100);
		Ninja ninja1 = new Ninja(100);
        Samurai samurai1 = new Samurai(200);
        Samurai samurai2 = new Samurai(200);
		Wizard wizard1 = new Wizard(50);
		
		wizard1.heal(human1);
		wizard1.fireball(ninja1);
        ninja1.steal(wizard1);
        ninja1.runAway();
		samurai1.deathBlow(human1);
        samurai1.meditate();
        Samurai.howMany();
		
		human1.displayHealth();
		ninja1.displayHealth();
	    samurai1.displayHealth();
		samurai2.displayHealth();
		wizard1.displayHealth();
	}
}


