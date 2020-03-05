package coreservlets;

import javax.faces.bean.*;

@ManagedBean 
@SessionScoped
public class HitCountBean { 
  private int count = 0;
  
  public int getCount() {
    return(count++);
  }
}
