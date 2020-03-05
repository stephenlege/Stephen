package coreservlets;

import java.util.*;
import javax.faces.bean.*;
import javax.faces.model.*;

@ManagedBean 
public class CityBean {
  private String cityName = "Baltimore";
  private CityInfo city = CityUtils.findCity(cityName);
  private List<SelectItem> cities;
  
  public CityBean() {
    cities = new ArrayList<>();
    for(CityInfo city: CityUtils.supportedCities()) {
      cities.add(new SelectItem(city.getCityName()));
    }
  }
  
  public String getCityName() {
    return(cityName);
  }
  
  public void setCityName(String cityName) {
    this.cityName = cityName;
    city = CityUtils.findCity(cityName);
  }
  
  public List<SelectItem> getCities() {
    return(cities);
  }
  
  public String getNflTeam() {
    return(city.getNflTeam());
  }
 
  public String getMlbTeam() {
    return(city.getMlbTeam());
  }
}
