package coreservlets;

import java.util.*;
import javax.faces.bean.*;

@ManagedBean 
@ApplicationScoped // Optional minor optimization, since no user-specific state
public class DateBean { 
  public Date getTime() {
    return(new Date());
  }
}
