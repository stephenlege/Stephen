package coreservlets;

public class CityInfo {
  private final String cityName, nflTeam, mlbTeam;
  
  public String getCityName() {
    return(cityName);
  }

  public String getNflTeam() {
    return(nflTeam);
  }

  public String getMlbTeam() {
    return(mlbTeam);
  }

  public CityInfo(String cityName, String nflTeam, String mlbTeam) {
    this.cityName = cityName;
    this.nflTeam = nflTeam;
    this.mlbTeam = mlbTeam;
  }
}
