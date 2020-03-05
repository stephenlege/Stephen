
package chap19_java;

import java.util.ArrayList;

public class Q5
{}
 class XYZ<T1>
{
    // ArrayList<? extends T2> list;//will not compile
    public static <T2> void f ( ArrayList<? extends T2> list1)
    {
        System.out.println( list1.size());
        //list1.add( new Integer());//will not compile
    }
    public static void main(String[] args)
    {
        f( new ArrayList<Integer>() );
        f( new ArrayList<Object>() );
        f( new ArrayList<A>() );     
    }
}
