import java.util.Random;

public class Amazonka extends Character{
    Random random = new Random();
    public Amazonka(String name) {

        super(name,100, 15, "Elv");
    }

    @Override
    void attack(Monster m) {
        if(m instanceof IDefendable)
        {
            ((IDefendable) m).defend(getPower());
        }else{
           m.setHealth(getHealth() - getPower());
        }
        int myDmg = random.nextInt(15);
        if(myDmg == 0)
        {
            System.out.println("Miss attack!");
        }

        int monsterHealth  = m.getHealth() - myDmg;
        m.setHealth(monsterHealth);
        System.out.println(m.getName()+" hit with "+myDmg);
    }



    @Override
   public Character defend(int attackPower) {
        int protect = random.nextInt(10);
        if(protect == 5)
        {
            System.out.println(this.getName() + " blocked the attack!");
        }else if(protect >= 1 && protect <= 3)
        {
            int protection = attackPower / 3;
            setHealth(getHealth() - protection);
            System.out.println(getName() + " partially blocked the attack and took " + protection + " damage!");
        }else{
            setHealth(getHealth() - attackPower);
            System.out.println(getName() + " took " + attackPower + " damage!");
        }


        return this;
    }
}
