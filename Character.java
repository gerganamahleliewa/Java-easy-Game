public abstract class Character implements IDefendable {

    private String name;
    private int health;
    private int power;
    private String race;

    public Character(String name, int health,int power,String race)
    {
        this.name = name;
        this.health = health;
        this.power = power;
        this.race = race;
    }
   public abstract Character defend(int attackPower);
    void attack(Monster target){
       if( target instanceof IDefendable)
       {
           ((IDefendable) target).defend(target.getPower());
       }else{
           target.setHealth(getHealth() - target.getPower());
       }
   }


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
        System.out.println("Hi! I am "+getName()+" and I have "+getHealth()+" health" +
                "");
    }

    public boolean isAlive()
    {

        return (getHealth() > 0);
    }

    public void oneTeam()
    {
        System.out.println("One for all and all for galaxy");
    }

}
