/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.pojos;




public class SearchSpec {

    private String name;
    private String baseURL;

    public SearchSpec(String name, String baseURL) {
        this.name = name;
        this.baseURL = baseURL;
    }
    /**
     * builds a url for the results page by simply concatenating the base url
     * @param searchString
     * @return 
     */
   
    public String makeURL(String searchString){
        return baseURL + searchString;
    }
    
    public String getName(){
        return name;
    }
}
