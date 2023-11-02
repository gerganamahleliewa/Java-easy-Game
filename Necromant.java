import java.util.Random;

public class Necromant extends Character implements IHealable{
    Random random = new Random();
    public Necromant(String name) {

        super(name,100, 20, "dvarfi");
    }

    @Override
    void attack(Monster target) {
        if(target instanceof IDefendable)
        {
            ((IDefendable) target).defend(getPower());
        }else{
            target.setHealth(getHealth() - getPower());
        }
        int myDmg = random.nextInt(6);
        if(myDmg == 0)
        {
            System.out.println("Miss!");
        }
        int monsterHealth = target.getHealth() - myDmg;
        target.setHealth(monsterHealth);
        System.out.println(target.getName()+" hit with "+myDmg);
    }



    @Override
    public Character defend(int attackPower) {
        int protect = random.nextInt(6);
        if(protect >= 1 && protect <= 3)
        {
            int protection = attackPower / 2;
            setHealth(getHealth() - protection);
            System.out.println(getName() + " partially blocked the attack and took " + protection + " damage!");
        }else{
            setHealth(getHealth() - attackPower);
            System.out.println(getName() + " took " + attackPower + " damage!");
        }
        return this;

    }

    @Override
    public void heal(Character target, int health) {

    }
}
