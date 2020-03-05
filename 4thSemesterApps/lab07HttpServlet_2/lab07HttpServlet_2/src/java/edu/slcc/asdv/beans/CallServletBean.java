package edu.slcc.asdv.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASDV2
 */
@Named(value = "callServletBean")
@SessionScoped
public class CallServletBean implements Serializable
{
    
  /**
     * Creates a new instance of CallServletBean
     */
    public CallServletBean()
    {
    }
 


  

    public void callServlet()
    {
        System.out.println("inside callServelet() of bean");
        FacesContext context = FacesContext.getCurrentInstance();
        try
          {

            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            HttpSession session = request.getSession();
            session.setAttribute("song", "last.mp3");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/DownloadServlet");
            dispatcher.forward(request, response);

          }
        catch (Exception e)
          {
            e.printStackTrace();
          }
        finally
          {
            context.responseComplete();
          }
    }

}
