package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojos.Name;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
public class TableData implements Serializable
{

    private ArrayList<Name> names = new ArrayList<Name>(Arrays.asList(
            new Name("Anna", "Keeney"),
            new Name("John", "Wilson"),
            new Name("Mariko", "Randor"),
            new Name("William", "Dupont")
    ));

    public ArrayList<Name> getNames()
    {
        return names;
    }

    public String deleteRow(Name nameToDelete)
    {
        names.remove(nameToDelete);
        return null;
    }
}
