
public abstract class Monster implements IAattackable{

    private String name;
    private int health;
    private int power;
    private String race;


    public Monster(String name, int health,int power,String race)
    {
        this.name = name;
        this.health = health;
        this.power = power;
        this.race = race;
    }

    public abstract void attack(Character target);

    public void setName(String name)
    {

        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public  void setHealth(int health)
    {
        this.health = health;
    }

    public int getHealth(){

        return health;
    }

    public void setPower(int power)
    {
        this.power = power;
    }
    public int getPower()
    {
        return power;
    }

    public void setRace(String race)
    {
        this.race = race;
    }
    public String getRace()
    {
        return race;
    }
    public void introduce()
    {
        System.out.println("Hi! I am "+getName()+" and I have "+getHealth()+" health");
    }
    public boolean isAlive()
    {
        return (getHealth() > 0);
    }
    public void oneTeam()
    {
        System.out.println("One for all and all for galaxy");
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

        return null;
    }
}
