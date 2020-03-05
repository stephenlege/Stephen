package lists;

import java.util.Iterator;

public class SingleLinkedListCircular<E>implements Iterable<E>
{
    private Node head;

    @Override
    public Iterator<E> iterator()
    {
       Iterator<E> it = new Iterator<E>() 
       {
           Node temp = head;
           @Override
           public boolean hasNext()
           {
              return temp != null;
           }

           @Override
           public E next() 
           {
               Node temp2 = temp;
               temp = temp2.link;
               return temp2.e;
           }   
       };
           return it;
    }

    private class Node
    {
        E e;
        Node link;
    }

    public E remove(int index)
    {
        if (index < 0 || index >= size() )
                throw new IndexOutOfBoundsException();
        if (isEmpty())
            return null;
        
       Node temp = head;
       if ( index == 0 ) //remove first node
         {   
           head = temp.link;
           return temp.e;
         }
       else if (index == size() -1)//remove last node
         {         
            for ( int i = 0; i < index-1;++i)
                temp = temp.link;
            Node temp2 = temp;
            temp.link = null;   
            return temp2.e;
         }
       else//remove a middle node
         {         
            for ( int i = 0; i < index-1;++i)
                 temp = temp.link; 
            Node temp2 = temp;
            temp.link  = temp.link.link;
            return temp2.e;         
         }                
    }

    public boolean add(int index, E e)
    {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        Node node = new Node();
        node.e = e;

        if (index == 0)//insert at the front
          {
            node.link = head;
            head = node;
          }
        else if (index == size())//insert at the end
          {
            add(e);
          }
        else//insert in the middle
          {
            Node temp = head;

            for (int i = 0; i < index - 1; ++i)
                temp = temp.link;

            node.link = temp.link;
            temp.link = node;
          }
        return true;
    }

    public int size()
    {
        Node temp = head;
        int count = 0;

        while (temp != null)
          {
            count++;
            temp = temp.link;
          }
        return count;
    }

    public boolean add(E e)
    {
        Node node = new Node();
        node.e = e;

        if (isEmpty())//first node in
            head = node;
        else
          {
            Node temp1 = head;
            Node temp2 = temp1;

            while (temp1 != null)
              {
                temp2 = temp1;
                temp1 = temp1.link;
              }
            temp2.link = node;
          }
        return true;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    @Override
    public String toString()
    {
        String s = "{ ";

        Node temp = head;

        while (temp != null)
          {
            s += temp.e + " ";
            temp = temp.link;
          }

        s += "}";
        return s;
    }

    public static void main(String[] args)
    {
        SingleLinkedListCircular<Integer> ml = new SingleLinkedListCircular<Integer>();
        ml.add(10);
        ml.add(20);
        ml.add(30);
        ml.add(0, 5);
        ml.add(4, 40);
        ml.add(2, 15);
        System.out.println(ml);
        
        ml.remove(0);
        ml.remove(4);
        ml.remove(2);
        System.out.println("------" + ml);
        
    }
}
