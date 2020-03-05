package edu.slcc.asdv.bl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import java.util.ArrayList;

public class ProblemBean implements Serializable {
   private ArrayList<Integer> sequence; 
   private int solution;
   
   public ProblemBean() {}

   public ProblemBean(int[] values, int solution) {
      sequence = new ArrayList<Integer>();
      for (int i = 0; i < values.length; i++)
         sequence.add(values[i]);
      this.solution = solution;
   }

   public ArrayList<Integer> getSequence() { return sequence; }
   public void setSequence(ArrayList<Integer> newValue) { sequence = newValue; }

   public int getSolution() { return solution; }
   public void setSolution(int newValue) { solution = newValue; }
}
