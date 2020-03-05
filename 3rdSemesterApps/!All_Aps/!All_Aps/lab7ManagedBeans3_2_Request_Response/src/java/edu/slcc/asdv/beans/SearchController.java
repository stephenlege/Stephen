/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojos.SearchUtilities;
import java.io.IOException;
import java.util.List;
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

     private String searchString = "";
     private String searchEngine;

    public SearchController() {
    }

    public String getSearchString() {
        return searchString;
    }

    public String getSearchEngine() {
        return searchEngine;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public void setSearchEngine(String searchEngine) {
        this.searchEngine = searchEngine;
    }
     
     public List<String> getSearchEngineNames(){return SearchUtilities.searchEngineNames();}
     
     public String doSearch() throws IOException{
         if (searchString.isEmpty())
             return "no-search-string";
         String searchURL 
                 = SearchUtilities.makeURL(searchEngine, searchString);
         if (searchURL != null){
             ExternalContext context 
                     = FacesContext.getCurrentInstance().getExternalContext();
             
             HttpServletResponse response
                     = (HttpServletResponse) context.getResponse();
             
             response.sendRedirect(searchURL);
             return null;
         }
         else return ("unknown-search-engine");
     }
    
}
