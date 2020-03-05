/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.pojos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Greg
 */
public class SearchUtilities {

    private SearchUtilities() {
    }

    private static SearchSpec[] commonSpecs = {
        new SearchSpec("Google", "https://www.google.com/#q="),
        new SearchSpec("Yahoo", "https://search.yahoo.com/search;?p="),
        new SearchSpec("Bing", "http://www.bing.com/search?q="),
        new SearchSpec("DuckDuckGo", "http://duckduckgo.com/?q=")

    };
    private static List<String> searchEngineNames;

    static{
        searchEngineNames = new ArrayList();
        for (SearchSpec spec : commonSpecs)
            searchEngineNames.add(spec.getName());}
       
        public static SearchSpec[] commonSearchSpecs(){return commonSpecs;}
        public static List<String> searchEngineNames(){return searchEngineNames;}

    public static SearchSpec[] getCommonSpecs() {
        return commonSpecs;
    }

    public static List<String> getSearchEngineNames() {
        return searchEngineNames;
    }
        
        /**
         * Given a search engine name and a search string, builds a URL for the ....5 lines 
         */
        public static String makeURL(String searchEngineName, String searchString){
            String searchURL = null;
            for(SearchSpec spec : commonSpecs){
                if (spec.getName().equalsIgnoreCase(searchEngineName)){
                    searchURL = spec.makeURL(searchString);
                    break;
                }
            }
            return (searchURL);
        }
        
    }


