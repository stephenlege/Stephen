/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Greg
 */
public class CircularDoubleLinkedList<E> implements Iterable<E> {

    private Node<E> head;

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Node<E> {

        E e;
        Node<E> leftLink;
        Node<E> rightLink;
    }

    public boolean isEmpty() {
        if (size() == 0 || head == null) {
            return true;
        } else {
            return false;
        }

    }
//    public boolean add(E e) {
//       return add(size(), e);
//    }
//    

    public boolean add(E e) {
        Node<E> newNode = new Node();
        newNode.e = e;

        if (head == null) {
            head = new Node();
            head.leftLink = head.rightLink = head;

        } else {
            newNode.leftLink = head.rightLink;
            newNode.rightLink = head;
            head.leftLink = newNode;
            head.rightLink = newNode;

        }
        return true;
    }

    public boolean add(int position, E e) {
        Node<E> entry = new Node<E>();
        entry.e = e;

        if (position > size() || position < 0) {
            System.err.println("Position too large/small.");
            return false;
        }
        if (isEmpty()) {
            head = head.leftLink = entry;

        } else if (position == 0) {
            entry.rightLink = head;
            head.leftLink = entry;
            head = entry;
        } else if (position == size()) {
            entry.leftLink = head.rightLink;
            entry.rightLink = entry;
            head.leftLink = entry;
            head.rightLink = entry;
        } else {
            Node<E> trail = head;

            for (int i = 0; i < position - 1; ++i) {
                trail = trail.rightLink;
            }
            // node is the new number, and temp is the  index stoped at from the head side of the list 
            entry.rightLink = trail.rightLink;
            trail.rightLink.leftLink = entry;
            entry.leftLink = trail;
            trail.rightLink = entry;
        }
        return true;
    }

    public int size() {
        Node<E> temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.rightLink;
        }
        return count;
    }

    @Override
    public String toString() {
        String s = "{ ";

         Node<E> temp = head;
        

        while (temp != null) {
            s += temp.e + " ";
            temp = temp.rightLink;
        }

        s += "}";
        return s;
    }

    public void print() {
        Node<E> temp = head;
        if (head == null) {
            return;
        }
        while (temp.rightLink != head) {
            System.out.print(temp.e + " ");
            temp = temp.rightLink;
        }
        System.out.println(temp.e);
    }
    
    public static void main(String[] args) {
        CircularDoubleLinkedList<Integer> list1 = new CircularDoubleLinkedList();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        
        list1.print();

    }
}
