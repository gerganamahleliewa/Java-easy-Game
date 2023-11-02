public class Fireball extends Item{

    private int damage;


    public Fireball(String name, Effect effect) {
        super(name, effect);
        this.damage = 20;
    }

    @Override
    void applyEffect(Character target) {
        target.setArmor(0);

        int actualDamage = target.getHealth() - (damage - target.getArmor());
        if(actualDamage <= 0)
        {
            target.setHealth(0);
            System.out.println(target.getName() + " has been defeated!");
        }else {
            target.setHealth(actualDamage);
            System.out.println(target.getName() + " took " + (damage - target.getArmor()) + " damage after armor block. Remaining health: " + actualDamage);
        }
    }
}
