package chap19_java;
import java.util.ArrayList;
import java.util.List;
public class Q3
{
    public static void f( List<? extends List< Integer>> table )
    {
      for ( int i =0; i < 2; ++i )
        {
        List<Integer> row = new ArrayList<Integer>();
        for ( int j=0; j < 3; ++j )
            row.add(i+j); System.out.println( row);
        //table.add(row); will not compile, we cannnot modify the List of wildcard
        }    
     for (List<Integer> row: table)
            System.out.println( row);      
    }
    
    public static void main(String[] args)
    {
     f( new ArrayList<List<Integer>>() );
     //f(  new List<ArrayList<Integer>>() );//will not compile
        System.out.println("--------");
     f( new ArrayList<ArrayList<Integer>>() );  
     //f(  new List<List<Integer>>() ); //will not compile
    }
}
