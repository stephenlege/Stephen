package chap19_java;
import java.util.ArrayList;
public class GenericsRule4
{
    public static void f1(ArrayList<?> list)
    {
        System.out.println( list.size());
        //list.add(new Integer(5));
    }

    public static void main(String[] args)
    {
        f1(new ArrayList<Integer>());
        f1(new ArrayList<Double>());
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        list.add(10);
        list.add(20);
        
        f1(list);
    }
}
