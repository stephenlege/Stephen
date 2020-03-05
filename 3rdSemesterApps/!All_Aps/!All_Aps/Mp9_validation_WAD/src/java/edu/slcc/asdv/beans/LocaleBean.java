package edu.slcc.asdv.beans;

import java.io.Serializable;

import java.util.Locale;

import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@Named(value = "localeBean")
@SessionScoped
public class LocaleBean implements Serializable {
     private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private String language = "en";

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public void langChanged(ValueChangeEvent e) {
         
            String l = e.getNewValue().toString();
            setLanguage(l);
            locale = new Locale(l);
            FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
         
    }
// 
//
//    private final Locale ENGLISH = new Locale("en");
//    private final Locale RUSSIAN = new Locale("ru");
//    private final Locale GREEK = new Locale("el");
//    private final Locale JAPANESE = new Locale("ja");
//    private Locale locale = ENGLISH;
//
//    public Locale getLocale() {
//        return (locale);
//    }
//
//    public void setRussian(ActionEvent event) {
//        locale = (RUSSIAN);
//        updateViewLocale();
//    }
//
//    public void setEnglish(ActionEvent event) {
//        locale = ENGLISH;
//        updateViewLocale();
//    }
//
//    public void setGreek(ActionEvent event) {
//        locale = (GREEK);
//        updateViewLocale();
//    }
//
//    public void setJapanese(ActionEvent event) {
//        locale = JAPANESE;
//        updateViewLocale();
//    }
//
//    public void setLocale(ValueChangeListener locale) {
//        updateViewLocale();
//    }
//    
//
//    private void updateViewLocale() {
//        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
//    }
}
