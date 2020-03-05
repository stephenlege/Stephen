package edu.slcc.asdv.bl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MathSequence implements Serializable {
   private List<Integer> sequence; 
   private int solution;
   
   public MathSequence() {}

   public MathSequence(int[] values, int solution) {
      sequence = new ArrayList<Integer>();
      for (int i = 0; i < values.length; i++)
         sequence.add(values[i]);
      this.solution = solution;
   }

   public List<Integer> getSequence() { return sequence; }
   
   public void setSequence(ArrayList<Integer> newValue) { sequence = newValue; }

   public int getSolution() { return solution; }
   
   public void setSolution(int newValue) { solution = newValue; }


   
   
}
