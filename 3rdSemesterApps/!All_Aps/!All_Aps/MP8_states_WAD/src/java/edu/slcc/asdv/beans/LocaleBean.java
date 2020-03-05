package edu.slcc.asdv.beans;


import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
@Named(value = "localeBean")
@SessionScoped
public class LocaleBean implements Serializable {
private final Locale ENGLISH = new Locale("en");
  private final Locale RUSSIAN = new Locale("ru");
  private final Locale GREEK = new Locale("el");
  private final Locale JAPANESE= new Locale("ja");
  private Locale locale = ENGLISH;
 
  public Locale getLocale() {
    return(locale);
  }
  public void setRussian(ActionEvent event) {
    locale = (RUSSIAN);
    updateViewLocale();
  }
   
  public void setEnglish(ActionEvent event) {
    locale = ENGLISH;
    updateViewLocale();
  }
   
  public void setGreek(ActionEvent event) {
    locale = (GREEK);
    updateViewLocale();
  }
   
  public void setJapanese(ActionEvent event) {
    locale = JAPANESE;
    updateViewLocale();
  }
   
  private void updateViewLocale() {
    FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
  }
}
