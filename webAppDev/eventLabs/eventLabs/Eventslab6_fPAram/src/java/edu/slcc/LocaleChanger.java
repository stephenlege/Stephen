package edu.slcc;

import java.util.Locale;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
public class LocaleChanger
{

    public void changeLocale()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        String languageCode = getLanguageCode(context);
        context.getViewRoot().setLocale(new Locale(languageCode));
        
    }

    private String getLanguageCode(FacesContext context)
    {
        Map<String, String> params = context.getExternalContext().getRequestParameterMap();
        return params.get("languageCode");
    }
}
