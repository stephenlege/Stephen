package chap19_java;

import java.util.ArrayList;
import java.util.List;

public class Q4
{ 
    public static void main(String[] args)
    {
     List<List<Integer>> table1 = new ArrayList<List<Integer>>();
     //List<List<Integer>> table = new List<ArrayList<Integer>>(); //will not compile
     List<? extends List<Integer>> table2 = new ArrayList<ArrayList<Integer>>();  
     //List<List<Integer>> table = new List<List<Integer>>();//will not compile

        for ( int i =0; i < 2; ++i )
        {
        List<Integer> row = new ArrayList<Integer>();
        for ( int j=0; j < 3; ++j )
            row.add(i+j);
        table1.add(row);
        //table2.add(row); willl not compile because it is wild card( uknown type)
        }
     
     for (List<Integer> row: table1)
            System.out.println( row);
     
        System.out.println("---------------------");
        System.out.println(table2);
    }
    }

