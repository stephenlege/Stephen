package chap19_java;
import java.util.ArrayList;
import java.util.List;

public class GenericsRule6
{
    public static void f6( List<? extends A> list)
    {
        System.out.println( list.size());
        //list.add(new C());
    }
    public static void main(String[] args)
    {
    List<A> list1 = new ArrayList();
    list1.add(new C());
    list1.add( new B());
    f6( list1 );
    
    ArrayList<B> list2 = new ArrayList();
    list1.add(new A());
    f6( list1 );     
    
    
    list2.add(new C());
    f6(list2);
    
    }
}
class A{}
class B extends A{}
class C extends B{}