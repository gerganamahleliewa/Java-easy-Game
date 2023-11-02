import java.util.Random;

public class Paladin extends Character{
    Random rand = new Random();
    public Paladin(String name) {

        super(name, 100, 10,"Human");
    }

    @Override
    void attack(Monster p) {
        int myDmg = rand.nextInt(10);
        int monsterHealth = p.getHealth() - myDmg;
        if(myDmg == 0)
        {
            System.out.println("Miss!");
        }
        p.setHealth(monsterHealth);
        System.out.println(p.getName()+" hit with "+myDmg);
    }


    @Override
    public Character defend(int attackPower) {
        int protection = rand.nextInt(12);
        if(protection == 1)
        {
            System.out.println(this.getName() + " blocked the attack!");
            setHealth(getHealth()+2);

        }else if(protection >= 2 && protection <= 4){
            int protect = attackPower / 2;
            setHealth(getHealth() - protect);
            System.out.println(getName() + " partially blocked the attack and took " + protect + " damage!");
        }
        else{
            setHealth(getHealth() - attackPower);
            System.out.println(getName() + " took " + attackPower + " damage!");
        }
        return this;
    }

}
