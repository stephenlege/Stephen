/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Greg
 */
@Named(value = "searchController")
@RequestScoped
public class SearchController {

    String searchString = "";
    String url = "";
    int index = (int) (Math.random() * 2);

    public String doSearch() throws UnsupportedEncodingException, IOException {
        if (index == 0) {
            url = "https://www.google.com/#q=" + searchString;
            URLEncoder.encode(url, "utf-8");
            ExternalContext context
                    = FacesContext.getCurrentInstance().getExternalContext();

            HttpServletResponse response
                    = (HttpServletResponse) context.getResponse();

            response.sendRedirect(url);
            return null;
        } else {
            url = "http://www.bing.com/search?q=" + searchString;
            URLEncoder.encode(url, "utf-8");
            ExternalContext context
                    = FacesContext.getCurrentInstance().getExternalContext();

            HttpServletResponse response
                    = (HttpServletResponse) context.getResponse();

            response.sendRedirect(url);
            return null;
        }

    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Creates a new instance of SearchController
     */
    public SearchController() {
    }

}
