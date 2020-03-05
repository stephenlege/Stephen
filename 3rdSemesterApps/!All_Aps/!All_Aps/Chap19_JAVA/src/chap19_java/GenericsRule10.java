package chap19_java;

import java.util.ArrayList;
import java.util.List;

public class GenericsRule10
{
    public static void f10( List<? extends A> list1, List<? super C>  list2)
    {
        System.out.println( list1.size());
        //list1.add( new B());   //will not compile  
    }
    public static void main(String[] args)
    {
      ArrayList<A> list1 = new ArrayList<A>();
      list1.add( new A());
      
      System.out.println( list1.get(0));
      ArrayList<Object> list2 = new ArrayList();
      f10( list1, list2);
      list2.add(new C());
      
      ArrayList<Integer> list3 = new ArrayList();
      f10(list1,list2);
      //f10( list1, list3);//will not compile
    }
}


