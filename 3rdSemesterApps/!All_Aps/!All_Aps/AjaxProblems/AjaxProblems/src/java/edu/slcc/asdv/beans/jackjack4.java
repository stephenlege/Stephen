package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojos.CityInfo;
import edu.slcc.asdv.pojos.CityUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;

@Named(value = "jackjack4")
@SessionScoped
public class jackjack4 implements Serializable {
  private String cityName = "Baltimore";
  private CityInfo city = CityUtils.findCity(cityName);
  private List<SelectItem> cities;
  
  public jackjack4() {
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
