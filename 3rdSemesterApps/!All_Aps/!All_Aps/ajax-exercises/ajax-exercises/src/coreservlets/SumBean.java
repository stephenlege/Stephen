package coreservlets;

import javax.faces.bean.*;

@ManagedBean 
public class SumBean { 
  private String num1String, num2String;
  private double num1, num2;
  
  public String getNum1String() {
    return(num1String);
  }
  
  public void setNum1String(String num1String) {
    this.num1String = num1String;
    try {
      num1 = Double.parseDouble(num1String);
    } catch(Exception e) {}
  }
  
  public String getNum2String() {
    return(num2String);
  }
  
  public void setNum2String(String num2String) {
    this.num2String = num2String;
    try {
      num2 = Double.parseDouble(num2String);
    } catch(Exception e) {}
  }
  
  public double getSum() {
    return(num1 + num2);
  }
}
