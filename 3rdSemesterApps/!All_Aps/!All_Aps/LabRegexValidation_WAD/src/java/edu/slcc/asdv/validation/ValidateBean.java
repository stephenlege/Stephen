package edu.slcc.asdv.validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Greg
 */
@Named(value = "validateBean")
@SessionScoped
public class ValidateBean implements Serializable {

    private String phone;
    private String SSN;
    private String date;
    private String floating;
    private String email;

    private String CCmessage;
    private String patern;
    private String CCnumber;
    private String card;

    public void changeCCnumber(ValueChangeEvent event) {
        //HtmlSelectOneRadio component = (HtmlSelectOneRadio) event.getNewValue();
         card = (String) event.getNewValue().toString();

        switch (card) {
            case "1":
                patern = "(4[0-9]{13})|(4[0-9]{15})";
                CCmessage = "Visa starts with 4 and has 14-16 digits";
                break;
            case "2":                                //2221-2270
                patern = "(5[1-5][0-9]{14})|([2221-2270]{4}[0-9]{12})";
                CCmessage = "MasterCard : 16 digits, starting with 51 through 55 or 2221 - 2720.";
                break;
            case "3":
                patern = "3[47][0-9]{13}";
                CCmessage = "American Express : 15 digits, starting with 34 or 37.";
                break;
            case "4":
                patern = "(3(?:0[0-5]|[68][0-9])?[0-9]{11})|(5[0-9]{15})";
                CCmessage = "Diners Club : 14 digits, starting with 300 through 305, 36, or 38. However, some start with 5 and have 16 digits.";
                break;
            case "5":      //(6011[0-9]{12})|(65[0-9]{14})        //6(?:011|5[0-9]{2})[0-9]{12}
                patern = "(6011[0-9]{12})|(65[0-9]{14})";
                CCmessage = "Discover : 16 digits, starting with 6011 or 65.";
                break;
            default:
                CCmessage = "Something Wrong.";
        }
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCCnumber() {
        return CCnumber;
    }

    public void setCCnumber(String CCnumber) {
        this.CCnumber = CCnumber;
    }

    public String getCCmessage() {
        return CCmessage;
    }

    public void setCCmessage(String CCmessage) {
        this.CCmessage = CCmessage;
    }

    public String getPatern() {
        return patern;
    }

    public void setPatern(String patern) {
        this.patern = patern;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFloating() {
        return floating;
    }

    public void setFloating(String floating) {
        this.floating = floating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
