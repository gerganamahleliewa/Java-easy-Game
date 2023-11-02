public abstract class Item {

    private String name;
    private Effect effect;

    public Item(String name,Effect effect)
    {
        this.name = name;
        this.effect = effect;

    }
    abstract void applyEffect(Character target);

}

