//Question 5
package TestQuestionsCheck;

import java.util.ArrayList;
import java.util.List;

public class AA
{
public static void x( List<? super C> list){}


public static void main(String[] args)
{
   ArrayList<A> list1 = new ArrayList<A>();
   list1.add( new A());
        x( list1 ); //1
   System.out.println( list1.get(0));

  ArrayList<Object> list2 = new ArrayList();
       x( list2); //2

   ArrayList<Integer> list3 = new ArrayList();//3
      // x( list3); //4
  }
}

class A{}
class B extends A{}
class C extends B{}