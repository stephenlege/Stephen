package coreservlets;

import java.io.Serializable;
import javax.faces.bean.*;

@ManagedBean 
@SessionScoped
public class NavBean implements Serializable {
  private static final long serialVersionUID = 1L;
  private Page currentPage = Page.A;
  
  public Page getCurrentPage() {
    return(currentPage);
  }
  
  public String doNavigation() {
    double num = Math.random();
    switch(currentPage) {
      case A: 
        currentPage = nextPage(num, Page.B);
        break;
      case B: 
        currentPage = nextPage(num, Page.C);
        break;
      case C:
        currentPage = nextPage(num, Page.VICTORY);
        break;
      case VICTORY:
        currentPage = Page.VICTORY;
        break;
      case DEFEAT:
        currentPage = Page.DEFEAT;
        break;
    }
    return(null); // So app works if you remove f:ajax
  }
  
  public String giveUp() {
    currentPage = Page.A;
    return(null); // So app works if you remove f:ajax
  }

  private Page nextPage(double num, Page continuePage) {
    if (num < 0.5) {
      return(continuePage);
    } else {
      return(Page.DEFEAT);
    }
  }
}
