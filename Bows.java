public class Bows extends Item{

    private int damage;


    public Bows(String name,Effect effect) {
        super(name,effect);
        this.damage = 15;

    }


    @Override
    void applyEffect(Character target) {
        target.setArmor(0);
        int actualDamage = target.getHealth() - (damage - target.getArmor());
        if(actualDamage <= 0)
        {
            target.setHealth(0);
            System.out.println(target.getName() + " has been defeated!");
        }else{
            target.setExperience(actualDamage);
            System.out.println(target.getName() + " took " + (damage - target.getArmor()) + " damage after armor block. Remaining health: " + actualDamage);
        }


    }
}
