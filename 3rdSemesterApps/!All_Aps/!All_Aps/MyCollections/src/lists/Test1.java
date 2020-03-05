package lists;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author ASDV2
 */
public class Test1
{
    public static void main(String[] args)
    {
            List<Integer> l = Arrays.asList( new Integer[] { 1,2,3,4,5 });
            System.out.println(l);
            ListIterator it = l.listIterator(2);
            System.out.println("start at index 2 use next**********************");
            
            while ( it.hasNext() )
              {
                Object o = it.next();
                 System.out.println("previous index " + it.previousIndex() +
                                     " next index " + it.nextIndex() +
                                     " value " + o);
              }
            System.out.println("start at index 3 use previous**********************");
            it = l.listIterator(3);
            while ( it.hasPrevious() )
              {
                Object o = it.previous();
                 System.out.println("previous index " + it.previousIndex() +
                                     " next index " + it.nextIndex() +
                                     " value " + o);
              }
    }   
}