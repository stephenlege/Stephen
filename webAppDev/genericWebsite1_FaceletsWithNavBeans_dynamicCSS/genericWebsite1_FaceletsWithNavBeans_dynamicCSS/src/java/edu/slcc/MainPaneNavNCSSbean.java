package edu.slcc;

import java.io.Serializable;

import javax.inject.Named;

import javax.enterprise.context.SessionScoped;

import javax.faces.event.ActionEvent;

@Named("mp")
@SessionScoped
public class MainPaneNavNCSSbean implements Serializable
{

    private int index;
    private static final int NEWS_INDEX = 0;
    private static final int STUDENT_INDEX = 1;
    private static final int ADMIN_INDEX = 2;
    private static final int PROMOTIONS_INDEX = 3;
    private static final int CONTACT_INDEX = 4;
    private static final int DATABASE_INDEX = 5;
    private static final int FD_INDEX = 6;
    private static final int CARD_INDEX = 7;

    private String[] tabTooltips =
      {
        "tooltipNews", "tooltipStudents", "tooltipAdmin",
        "tooltipPromotions", "tooltipContact", "tooltipFlags" , 
        "tooltipGreekFlag" , "tooltipUSFlag",
         "tooltipFlags"
      };

    public MainPaneNavNCSSbean()
    {
        index = NEWS_INDEX;
    }

    // action listeners that set the current tab
    
       // action listeners that set the current tab
    public void newsAction(ActionEvent e)
    {
        index = NEWS_INDEX;
    }

    public void databaseAction(ActionEvent e)
    {
        index = DATABASE_INDEX;
    }
    

    public void studentAction(ActionEvent e)
    {
        index = STUDENT_INDEX;
    }

    public void adminAction(ActionEvent e)
    {
        index = ADMIN_INDEX;
    }

    public void contactAction(ActionEvent e)
    {
        index = CONTACT_INDEX;
    }

    public void promotionsAction(ActionEvent e)
    {
        index = PROMOTIONS_INDEX;
    }
    
   public void fdAction(ActionEvent e)
    {
        index = FD_INDEX;
    }
   public void cardAction(ActionEvent e)
    {
        index = CARD_INDEX;
    }
    
    public String getCSS(int forIndex)
    {
        if (forIndex == index)
          {
            return "tabbedPaneTextSelected";
          }
        else if (forIndex == DATABASE_INDEX)
          {
            return "newsStyle";
          }
        else
          {
            return "tabbedPaneText";
          }
    }

    // methods for CSS styles
    public String getNewsStyle()
    {
        return getCSS(NEWS_INDEX);
    }

    public String getStudentStyle()
    {
        return getCSS(STUDENT_INDEX);
    }

    public String getAdminStyle()
    {
        return getCSS(ADMIN_INDEX);
    }

    public String getContactStyle()
    {
        return getCSS(CONTACT_INDEX);
    }

    public String getPromotionsStyle()
    {
        return getCSS(PROMOTIONS_INDEX);
    }

    // methods for determining the current tab
    public boolean isStudentCurrent()
    {
        return index == STUDENT_INDEX;
    }

    public boolean isContactCurrent()
    {
        return index == CONTACT_INDEX;
    }

    public boolean isAdminCurrent()
    {
        return index == ADMIN_INDEX;
    }

    public boolean isNewsCurrent()
    {
        return index == NEWS_INDEX;
    }

    public boolean isPromotionCurrent()
    {
        return index == PROMOTIONS_INDEX;
    }
    public boolean isDatabaseCurrent()
    {
        return index == DATABASE_INDEX;
    }
    public boolean isFDCurrent()
    {
        return index == FD_INDEX;
    } 
    
  public boolean isCardCurrent()
    {
        return index == CARD_INDEX;
    } 
}