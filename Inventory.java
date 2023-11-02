import java.util.*;

public class Inventory {

    private List<Item> items = new ArrayList<>();
    private List<Skill>skills = new ArrayList<>();

    public boolean hasSkill(Skill skill)
    {
        for(Skill sk: skills)
        {
            if(sk.equals(skill))
            {
                return true;
            }
        }
        return false;
    }

    public void adSkill(Skill skill)
    {
        skills.add(skill);
    }

    public void addItem(Item item){
        items.add(item);
    }

    public boolean removeItem(Item item){
       return items.remove(item);
    }
    public boolean hasItem(Item item)
    {
        for(Item it: items)
        {
            if(it.equals(item)){
                return true;
            }
        }return false;
    }

    public Item displayItem()
    {
        for(Item item:items)
        {
            System.out.println("Item is : "+item);
            return item;
        }
        return null;
    }
}
