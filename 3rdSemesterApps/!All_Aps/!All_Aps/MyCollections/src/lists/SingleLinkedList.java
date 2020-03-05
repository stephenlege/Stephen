/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author Greg
 */
public class SingleLinkedList<E> {

    private Node<E> head;

    private class Node<E> {

        E e;
        Node<E> link;
    }

    public void print() {
        Node<E> temp1 = head;

        while (temp1 != null) {
            System.out.println(temp1.e);
            temp1 = temp1.link;
        }
        System.out.println("----------++++++++++++--------------");
    }

    public boolean add(E e) {
        Node<E> entry = new Node<>();
        entry.e = e;

        if (head == null) {
            head = entry;
        } else {
            Node<E> temp1 = head;
            Node<E> temp2 = head;

            while (temp1 != null) {
                temp2 = temp1;
                temp1 = temp1.link;
            }
            temp2.link = entry;
        }

        return true;
    }

    public int size() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.link;
        }
        return count;
    }

    public boolean isEmpty() {
        if (size() == 0 || head == null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean add(int position, E e) {
        Node<E> entry = new Node<E>();
        entry.e = e;

        if (position > size() || position < 0) {
            System.err.println("Position too large.");
            return false;
        }
        if (isEmpty()) {

            head = entry;
        } else if (position == 0) {    //add in the front with 1 or more nodes
            entry.link = head;
            head = entry;
        } else if (position == size()) {
            add(e);
        } else {
            Node<E> temp1 = head;

            for (int i = 0; i < position - 1; i++) {
                temp1 = temp1.link;
            }
            entry.link = temp1.link;
            temp1.link = entry;
        }
        return true;
    }

    ////////////////////////////////////////////////////////////////////HW
    /**
     *
     * @param position position of removal
     * @return true if the entry is removed false otherwise(invalid pos)
     */
    public boolean remove(int position) {
        if (position < 0 || position > size()) {
            return false;
        }

        if (position == 0) {
            head = head.link;
        } else {
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < position - 1; i++) {
                n = n.link;
            }
            n1 = n.link;

            n.link = n1.link;
        }
        return true;
    }

    /**
     * Removes the entry that matches the parameter value e
     *
     * @param e entry to be removed
     * @return true if the entry is removed, false otherwise
     */
    public boolean remove(E e) {
       
        if (isEmpty()) {
            return false;
        }
        if (head.e == e) {
            head = head.link;
        } else {
            Node n = head;
            //Node n1 = head.link;

           while(n.link != null){
               if (n.link.e == e)
                   n.link = n.link.link;
               else
                   n = n.link;
            }
        }
        return true;
    }
///////////////////////////////////////////////////////////////////////////////

    public boolean remove() {

        if (head == null) { //zero
            return false;
        } else if (head.link == null)//one node{
        {
            head = null;
        } else { //2
            Node<E> temp1 = head;
            Node<E> temp2 = head;

            while (temp1.link != null) {
                temp2 = temp1;
                temp1 = temp1.link;
                //temp2.link = null;
            }
            temp2.link = null;
        }
        return true;
    }

    public static void main(String[] args) {
//        SingleLinkedList<Integer> l1 = new SingleLinkedList<>();
//
//        l1.add(10);
//        l1.add(20);
//        l1.add(30);
//
//        l1.print();
//        System.out.println(l1.size());
//        System.out.println("------------------------------");
//        l1.remove();
//        l1.print();
//        System.out.println(l1.size());
//
//        System.out.println("---------------add(at index 1)");
//        l1.add(1, 15);
//        l1.print();
//
//        System.out.println("--------index 0, and 4");
//        l1.add(0, 5);
//        l1.add(4, 25);
//        l1.print();
//
//        l1.add(10, Integer.SIZE);
//
//        l1.remove(2);
//        l1.print();
//        
//         SingleLinkedList<String> l2 = new SingleLinkedList<>();
//         l2.add("nope");
//         l2.add("maybe");
//         l2.add("yes");
//         
//         l2.print();
//         l2.remove("maybe");
//         
//         l2.print();
         
         
         SingleLinkedList<Integer> list = new SingleLinkedList<>();
         list.add(10);
         list.add(20);
         list.add(30);
         list.add(40);
         list.print();
         
         list.remove(0);
         list.print();
         list.remove(1);
         list.print();
         list.remove(1);
         list.print();
        
    }
}
