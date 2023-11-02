import java.util.Random;

public class FallanShaman extends Monster{
    public FallanShaman(String name,int health, int power,String race) {

        super(name, health, power, race);
    }

    @Override
    public void attack(Character ch) {
        Random rand = new Random();
        int myDmg = rand.nextInt(10);
        int monsterHealth  = ch.getHealth() - myDmg;
        if(myDmg == 0)
        {
            System.out.println("Miss!");
        }
        ch.setHealth(monsterHealth);
        ch.defend(myDmg);
        System.out.println(ch.getName()+" hit with "+myDmg);

    }

    public Monster takeDamage(int damage)
    {

        int finalDamage = getHealth() - damage;
        if(finalDamage <= 0)
        {
            System.out.println("The monster is defeated!");
        }else{
            System.out.println("After "+damage+ " damage, Monster "+getName()+" health is "+getHealth());
        }

        return this;
    }
}
