package edu.slcc;

import java.io.Serializable;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
public class TableData implements Serializable
{

    private static final Name[] names = new Name[]
      {
        new Name("William", "Dupont"),
        new Name("Anna", "Keeney"),
        new Name("Mariko", "Randor"),
        new Name("John", "Wilson")
      };

    public Name[] getNames()
    {
        return names;
    }

    public String save()
    {
        for (Name name : names)
          {
            name.setEditable(false);
          }
        return null;
    }
}
