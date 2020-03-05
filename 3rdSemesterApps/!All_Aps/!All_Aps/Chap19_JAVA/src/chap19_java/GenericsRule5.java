package chap19_java;
import java.util.ArrayList;
import java.util.List;
public class GenericsRule5
{
    public static void main(String[] args)
    {
       List<?> list1 = new ArrayList<Integer>();
       ArrayList<?> list2 = new ArrayList<Double>();
       ArrayList<?> list3 = new ArrayList<String>();
       //list3.add("abc");
       //A<String> a = new B<String>();

       //a.setT( "abc" );
    }
}
