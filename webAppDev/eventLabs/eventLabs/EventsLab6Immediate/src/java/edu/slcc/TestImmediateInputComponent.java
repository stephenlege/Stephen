package edu.slcc;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@Named(value = "testImmediate")
@SessionScoped
public class TestImmediateInputComponent implements Serializable
{
    private String name;
    private String language = "en";
    private Map<String, String> languagesMap;
    public TestImmediateInputComponent()
    {
        languagesMap = new LinkedHashMap<String, String>();
        languagesMap.put("US", "en");//usa
        languagesMap.put("DE", "de");//germany
        languagesMap.put("GR", "el");//greece
        languagesMap.put("RU", "ru");//russia
        languagesMap.put("CN", "zn");//china 
        languagesMap.put("VI", "vi");//vietnam         
    }
   
    public String getName()
    {
        return name;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Map<String, String> getLanguagesMap()
    {
        return languagesMap;
    }
    public void languageChanged(ValueChangeEvent event)
    {
        FacesContext contextInstance = FacesContext.getCurrentInstance();
        for (Map.Entry<String, String> entry : this.languagesMap.entrySet())
          {
            Object o = event.getNewValue();
            String lang = entry.getValue();
            if (lang.equals(o.toString() ))
              {
              contextInstance.getViewRoot().setLocale(
                    new Locale(o.toString(), entry.getKey()));
              this.language = o.toString();
              name = null;
              break;
              }
          }
        contextInstance.renderResponse();
    }
   
     public String newData()
    {
        if (name == null)
            return "";
        
        return "<p style=\"color:red\">Data in <br />"
                + "Your name: " + name + "<br />"
                + "Your language: " + language + "<br />"
                + "</p>";
    }             
}
