package edu.slcc;

import java.util.logging.Logger;
import javax.inject.Named;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
//import javax.faces.event.PhaseListener;

@Named
@RequestScoped
public class FormBean extends PhaseListenerASDV

{

    private static final Logger logger = Logger.getLogger("edu.slcc.formBean");
    FacesContext context = null;
    String name = "abc";

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
