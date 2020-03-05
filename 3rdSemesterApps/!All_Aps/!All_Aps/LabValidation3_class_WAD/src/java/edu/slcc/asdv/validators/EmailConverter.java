/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.validators;

import edu.slcc.asdv.pojos.Email;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
@FacesConverter (forClass=Email.class)

/**
 *
 * @author Greg
 */
public class EmailConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) 
        throws ConverterException
    {
        StringBuilder sb = new StringBuilder(value);
        
        boolean foundInvalidCharacter = false;
        char invalidCharacter = '\0';
        int i = 0;
        while (i < sb.length())
          {
            char ch = sb.charAt(i);
            if (Character.isWhitespace(ch)){
                foundInvalidCharacter = true;
                invalidCharacter = ' ';
                break;
            }
             
            else
              {
                ++i;
              }
          }
        //handle all cases of validation by throwing
        if (foundInvalidCharacter)
          {
            FacesMessage message = edu.slcc.asdv.util.Messages.getMessage(
                    "messages.errors", "invalidEmail",
                    new Object[] { new Character(invalidCharacter) });
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
          }
        if ( value.length()< 4 || value.length() > 30 )
          {
             FacesMessage message = edu.slcc.asdv.util.Messages.getMessage(
                    "messages.errors", "invalidEmail_detail",
                    new Object[]
                      {
                        "the size is too small", new String("2nd Objext in array----"),
                        "just another message."
                      });
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);           
          }
        if(!value.matches("^(.+)@(.+)$")){
            FacesMessage message = edu.slcc.asdv.util.Messages.getMessage(
                    "messages.errors", "invalidEmail_detail",
                    new Object[]
                      {
                        "email must match (\"^(.+)@(.+)$\") ", "so, ", "fix it!" 
                        
                      });
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);  
        }

        return new Email(sb.toString());
    }
    
    /**
     *
     * @param arg0
     * @param arg1
     * @param arg2 Email Object
     * @return
     */
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        String v = arg2.toString();//calls toString() of  Email
        
        StringBuilder result = new StringBuilder("\"");
        
        result.append(v);
        result.append("\"");
        
        return result.toString();
        
    }
    
}
