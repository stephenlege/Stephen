package chap19_java;

import java.util.ArrayList;
import java.util.List;

public class Q1
{
    public static void f( List<List<Integer>> table )
    {
      for ( int i =0; i < 2; ++i )
        {
        List<Integer> row = new ArrayList<Integer>();
        for ( int j=0; j < 3; ++j )
            row.add(i+j);
        table.add(row);
        }
     
     for (List<Integer> row: table)
            System.out.println( row);      
    }
    
    public static void main(String[] args)
    {
     f( new ArrayList<List<Integer>>() );
     //f(  new List<ArrayList<Integer>>() );//will not compile
     //f( new ArrayList<ArrayList<Integer>>() );  //will not compile
     //f(  new List<List<Integer>>() ); //will not compile
    }
}
