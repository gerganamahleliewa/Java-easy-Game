public class Axes extends Item{

    private int damage;

    public Axes(String name,Effect effect) {

        super(name,effect);
        this.damage = 10;
    }

    @Override
    void applyEffect(Character target) {
        int healthAfterAxe = target.getHealth() - damage;
        target.setHealth(healthAfterAxe);
        System.out.println(target.getName() + " took " + damage + " damage from the axe!");
    }

}
