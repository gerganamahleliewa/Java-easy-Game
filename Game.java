import javax.management.monitor.MonitorSettingException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Character hero;
    private Queue<Monster> monsters = new LinkedList<>();

    GameData gameData;

    public Character createHero(String name, String race)
    {

        switch (race)
        {
            case "Paladin":
               hero = new Paladin(name);
               hero.introduce();
                break;
            case "Amazon":
                hero = new Amazonka(name);
                hero.introduce();
                break;
            case "Barbarian":
                hero = new Varvarin(name);
                hero.introduce();
                break;
            case "Necromancer":
                hero = new Necromant(name);
                hero.introduce();
                break;
            case "Witch":
                hero = new Witch(name);
                hero.introduce();
                break;
            default:
                System.out.println("Not found such a race...");
                break;
        }
        return hero;
    }
    public void callBoss(String name)
    {
        Boss boss = new Boss(name,200,20,"undead");
        if(boss.canChallenge(hero))
        {
            while(boss.isAlive() && hero.isAlive()) {
                boss.attack(hero);
                if (hero.isAlive()) {
                    hero.attack(boss);
                }
            }
        }
        if(hero.isAlive())
        {
            Item item = (Item) boss.dropLoot();
            hero.addItem(item);
            hero.gainExperience(50);
        }
    }
    public void addMonster(Monster monster)
    {
        this.monsters.add(monster);
        monster.introduce();
    }
    public void recover()
    {
        hero.setHealth(100);
    }

int flag = 0;
    public void startBattle()
    {

       while(!(monsters.isEmpty()) && hero.isAlive())
        {
            Monster monster = monsters.poll();

            while(hero.isAlive() && monster.isAlive()) {

                if (monster.getHealth() >= 100 && monster.getHealth() <= 150) {
                    flag = 1;
                } else if (monster.getHealth() > 150 && monster.getHealth() <= 250) {
                    flag = 2;
                }else{
                    flag = 0;
                }

                hero.attack(monster.takeDamage(10));
                hero.setArmor(hero.getArmor()+10);
                if (monster.isAlive()) {
                    monster.attack(hero.defend(10));

                }
            }

                if (hero.isAlive()) {
                    if (!monsters.isEmpty()) {
                        System.out.println("Recovering health...");
                        try {
                            Thread.sleep(5000);
                            recover();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {

                    System.out.println(hero.getName() + " has been defeated by " + monster.getName() + "!");
                    return;

                }
            Effect effect = new Effect("attack");
            Item item;

            if(hero.isAlive())
            {
                if(flag == 1)
                {
                    item = new Axes("Axes",effect);
                    hero.gainExperience(25);
                    hero.addItem(item);
                    gameData.setLastPlayedCharacter(hero);
                    gameData.setInventory(hero);
                    gameData.getInventory();
                    gameData = new GameData(hero, hero.getArmor(), hero.getLevel());
                }else if(flag == 2)
                {
                    item = new Bows("Bows",effect);
                    hero.gainExperience(65);
                    hero.addItem(item);
                    gameData.setLastPlayedCharacter(hero);
                    gameData.setInventory(hero);
                    gameData.getInventory();
                    gameData = new GameData(hero, hero.getArmor(), hero.getLevel());
                }else{
                    item = new Fireball("Fireball",effect);
                    hero.gainExperience(100);
                    hero.addItem(item);
                    gameData = new GameData(hero, hero.getArmor(), hero.getLevel());
                    gameData.setInventory(hero);
                    gameData.getInventory();
                }

                System.out.println("Congratulations! You defeated all monsters!");
            }
        }


    }
    Random random = new Random();

    public void createMonster(int chooseMonsters)
    {
        Monster monster;
        Scanner scanner = new Scanner(System.in);
        while(chooseMonsters > 0)
        {
            int choice = random.nextInt(2);
            switch (choice)
            {
                case 0:
                    System.out.println("Enter name:");
                    String name = scanner.next();
                    System.out.println("Enter health:");
                    int health = scanner.nextInt();
                    System.out.println("Enter power:");
                    int power = scanner.nextInt();
                    System.out.println("Enter race:");
                    String race = scanner.next();
                    monster =  new FallanShaman(name,health,power,race);
                    addMonster(monster);
                    break;
                case 1:
                    System.out.println("Enter name:");
                    name = scanner.next();
                    System.out.println("Enter health:");
                    health = scanner.nextInt();
                    System.out.println("Enter power:");
                     power = scanner.nextInt();
                    System.out.println("Enter race:");
                    race = scanner.next();
                    monster = new SkeletonKing(name,health,power,race);
                    addMonster(monster);
                    break;
                default:
                    System.out.println("Invalid input...");
            }

            chooseMonsters--;
        }

    }
    public void displayMonsters()
    {
        if(monsters.isEmpty())
        {
            System.out.println("No monsters found...");
        }else{
            System.out.println("Monsters list is:");
            for(Monster monster:monsters)
            {
                System.out.println("Monster name: "+monster.getName());
            }

        }
    }

    public Monster createRandomMonster(String name,int health, int power,String race)
    {

        int choice = random.nextInt(2);
        switch (choice)
        {
            case 0:
                return new FallanShaman(name,health,power,race);
            case 1:
                return new SkeletonKing(name,health,power,race);
            default:
                System.out.println("Invalid input...");
                return null;
        }
    }
}
