package coreservlets;

import java.util.*;

public class CityUtils {
  private static CityInfo[] cities = {
    new CityInfo("Baltimore", "Ravens", "Orioles"),
    new CityInfo("Washington DC", "Redskins", "Nationals"),
    new CityInfo("Philadelphia", "Eagles", "Phillies")
  };
  private static Map<String,CityInfo> cityMap;
  
  static {
    cityMap = new HashMap<>();
    for(CityInfo city: cities) {
      cityMap.put(city.getCityName().toUpperCase(), city);
    }
  }
  
  public static CityInfo[] supportedCities() {
    return(cities);
  }
  
  public static CityInfo findCity(String cityName) {
    CityInfo city = cityMap.get(cityName.toUpperCase());
    if (city != null) {
      return(city);
    } else {
      return(new CityInfo(cityName, 
                          "Unknown NFL Team", "Unknown MLB Team"));
    }
  }

  private CityUtils() {} // Un-instantiatable class
}
