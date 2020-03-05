
package factory_generic_dao;
import java.util.Objects;

public class Item 
        implements Keyable<String>, Comparable<Item>, Categorable<String>
{   private String category;
    private String id;  
    private String description;
    
    public Item(){}
    public Item(String category, String id, String description )
    {
        this.id = id;
        this.description = description;
        this.category = category;
    }
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}
    public String getId(){return id;}
    public void setId(String id){this.id = id;}

  

    @Override public String getKey(){return getId();}
    @Override public void setKey(String key){ setKey(key);}

    @Override
    public String getCategory()
    {
        return category;
    }

    @Override
    public void setCategory(String t)
    {
         this.category = t;
    }

    @Override
    public int compareTo(Item o)
    {
        return this.id.compareTo(o.id);
    }

  

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
          {
            return true;
          }
        if (obj == null)
          {
            return false;
          }
        if (getClass() != obj.getClass())
          {
            return false;
          }
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id))
          {
            return false;
          }
        return true;
    }

    @Override
    public String toString()
    {
        return "Item{" + "category=" + category + ", id=" + id + ", description=" + description + '}';
    }
    
    
}
