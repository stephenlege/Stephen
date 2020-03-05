package edu.slcc.asdv.pojos;

import java.util.HashMap;
import java.util.Map;

public class City {
    public String[] cityName = {"Baltimore", "Washington DC", "Philadelphia"};
    public Map<String, String> cityMap = new HashMap();
    
    public City(){
        cityMap.put("Baltimore", "NFL: Ravens, MLB: Orioles");
        cityMap.put("Washington DC", "NFL: Redskins, MLB: Nationals");
        cityMap.put("Philadelphia", "NFL: Eagles, MLB: Phillies");
    }

    public String[] getCityName() {
        return cityName;
    }

    public Map<String, String> getCityMap() {
        return cityMap;
    }
    
    

}
