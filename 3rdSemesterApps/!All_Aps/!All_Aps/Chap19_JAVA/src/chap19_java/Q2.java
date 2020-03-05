package chap19_java;

import java.util.ArrayList;
import java.util.List;

public class Q2
{
    public static void main(String[] args)
    {
     List<List<Integer>> table = new ArrayList<List<Integer>>();
     //List<List<Integer>> table = new List<ArrayList<Integer>>(); //will not compile
     //List<List<Integer>> table = new ArrayList<ArrayList<Integer>>();  //will not compile
     //List<List<Integer>> table = new List<List<Integer>>();//will not compile

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
}
