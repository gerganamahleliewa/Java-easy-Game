import java.util.ArrayList;
import java.util.*;
public class Boss extends Monster{

    private List<Item>requiredItems = new ArrayList<>();
    private List<Skill>requiredSkill = new ArrayList<>();

    public Boss(String name, int health, int power, String race) {
        super(name, health, power, race);
    }

    Effect effect = new Effect("attack");
   Item item ;


    public boolean canChallenge(Character hero){
        item = new Sword("Sword",effect);
        hero.addItem(item);
        item = new Bows("Bows",effect);
        hero.addItem(item);

        for(Item item:requiredItems)
        {
            if(!hero.hasItem(item))
            {
                return false;
            }
        }

        for(Skill skill : requiredSkill)
        {
            if(!hero.hasSkill(skill))
            {
                return false;
            }
        }
        return true;
    }
    Random random = new Random();
    public List<Item> dropLoot(){
        int fromIndex = random.nextInt(5);
        int tolndex = random.nextInt(2);
        List<Item> item = requiredItems.subList(fromIndex,requiredItems.size() / tolndex);
        return item;
    }
    @Override
    public void attack(Character target) {
        canChallenge(target);
        int myDmg = random.nextInt(20);
        int heroHealth = target.getHealth() - myDmg;
        if(myDmg == 0)
        {
            System.out.println("Miss!");
        }
        target.setHealth(heroHealth);

    }
}
