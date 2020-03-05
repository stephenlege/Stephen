/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;
import java.util.Iterator;


public class DoubleLinkedList<E>
        implements Iterable<E>
{

    private Node head, tail;

    @Override
    public Iterator<E> iterator()
    {
       return null;
    }

    private class Node
    {

        E e;
        Node leftLink, rightLink;
        
    }

    public E remove(int index)
    {
        
        Node temp = head;
        for(int i = 0; i < index; i++)
        {
            temp = temp.rightLink;
        }
        temp.leftLink.rightLink = temp.rightLink;
        temp.rightLink.leftLink = temp.leftLink;
        temp.leftLink = null;
        temp.rightLink = null;
        
        return temp.e;
    }

    public boolean add(int index, E e)
    {
      if (index < 0 || index > size())
          {
            throw new IndexOutOfBoundsException();
          }

        Node node = new Node();
        node.e = e;

        if (index == 0)//insert at the front
          {
            node.rightLink = head;
            head.leftLink = node;
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
              {
                temp = temp.rightLink;
              }
            
            node.rightLink = temp.rightLink;
            temp.rightLink.leftLink = node;
            node.leftLink = temp;
            temp.rightLink = node;
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
            temp = temp.rightLink;
          }
        return count;
    }

    public boolean add(E e)
    {
        Node node = new Node();
        node.e = e;

        if (isEmpty())//first node in
          {
            head = tail = node;
          }
        else
          {
            //1 connect the newly created node with the rest of the list
              node.leftLink = tail;
              tail.rightLink = node;
            //2 move tail 
              tail = node;
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
            temp = temp.rightLink;
          }

        s += "}";
        return s;
    }
    public static void main(String[] args)
    {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(50);
       
        list.add(2, 3);
         System.out.println(list);
        list.remove(2);
        
        System.out.println(list);
        
        
    }
}
