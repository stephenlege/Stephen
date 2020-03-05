package coreservlets;

public enum Page {
  A("Page A"),
  B("Page B"),
  C("Page C"),
  VICTORY("Victory! Congratulations!"),
  DEFEAT("Defeat! Loser!");
  
  private String message;
  
  private Page(String message) {
    this.message = message;
  }
  
  public String getMessage() {
    return(message);
  }
}
