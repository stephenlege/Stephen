/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.Objects;

public class ListCircular<E> {

    public Node<E> head;

    class Node<E> {

        public E e;
        public Node<E> l;
        public Node<E> r;
    }

    public int size() {
        
        int count = 0;

        if (head == null) {
            return count;
        } else {
            Node<E> temp = head;
            do {
                temp = temp.r;
                count++;

            } while (temp != head);
        }
        return count;
    }

    public boolean add(E e) {
        Node<E> newNode = new Node();
        newNode.e = e;

        if (head == null) {
            newNode.r = newNode;
            newNode.l = newNode;
            head = newNode;

        } else {
            Node<E> temp = head.l;
            temp.r = newNode;
            newNode.r = head;
            head.l = newNode;
            newNode.l = temp;

        }
        return true;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean add(int pos, E e) {
        if (pos < 0 || pos > size()) {
            return false;
        }

        Node<E> node = new Node();
        node.e = e;

        if (pos == 0)//insert at the front
        {
            Node<E> newNode = new Node();
            newNode.e = e;

            if (head == null) {
                newNode.r = newNode;
                newNode.l = newNode;
                head = newNode;

            } else {
                Node<E> temp = head.l;

                temp.r = newNode;
                newNode.l = temp;
                newNode.r = head;
                head.l = newNode;
                head = newNode;
            }
        } else if (pos == size())//insert at the end
        {
            add(e);
        } else//insert in the middle
        {
            Node<E> temp = head;
            Node<E> newNode = new Node();
            newNode.e = e;

            for (int i = 0; i < pos - 1; ++i) {
                temp = temp.r;
            }

            newNode.r = temp.r;
            temp.r.l = newNode;
            temp.r = newNode;
            newNode.l = temp;
        }
        return true;
    }
    
   
    
    public void remove(Node<E> node){
        if (node.l == node || node.r == node)
            head = null;
        else{
            Node<E> temp = node.l;
            temp.r = node.r;
            node.r.l = temp;
        }
    }

    public boolean remove(int pos) {
        if (pos > size() || pos < 0) {
            return false;
        }
        if (pos == 0) {
            if (head == null) {
                System.err.println("isEmpty!");
            } else {
                Node<E> temp = head.r;
                head.l.r = temp;
                temp.l = head.l;
                head = temp;
            }

        } else if (pos == size() -1) {
         
            if (head == null) {
                System.out.println("isEmpty");
            } else {
                Node<E> temp = head.l;
                temp.l.r = head;
                head.l = temp.l;
                temp = null;
            }
        } else {
            Node<E> temp = head;
            for (int i = 0; i < pos ; i++) {
                temp = temp.r;
            }
            Node<E> node = temp.r;
            node.l = temp.l;
            temp.l.r = node;
            temp = null;
        }
       
        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListCircular<?> other = (ListCircular<?>) obj;
        if (!Objects.equals(this.head, other.head)) {
            return false;
        }
        return true;
    }
    

    private int searchFor(E e) {
        Node<E> temp = head;
        int index = 0;
        if (temp.r == head) {
            return index;
        }
       do{
           
           if(temp.e.equals(e))
               return index;
           temp = temp.r;
           index++;
           
       }while(temp != head);
        return -1;
    }

    public boolean remove(E e) {
        if (isEmpty()) {
            return false;
        }
        int index = searchFor(e);
        if (index == -1) {
            return false;
        }
       
            return remove(index);
    }

    public void print() {
        Node<E> p = head;

        if (isEmpty()) {
            return;
        } else if (p == p.r) {
            System.out.println(p.e);
        } else {
            do {
                System.out.println(p.e);
                p = p.r;
            } while (p != head);
        }
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public static void main(String[] args) {
        ListCircular<Integer> list = new ListCircular<>();

        list.add(0,10);

        list.add(0, 5);
        list.add(2, 15);
        list.add(2,12);
        
        list.print();
        
        System.out.println("---------------------------------------");
        list.remove(0);
        list.remove(2);
        list.remove(1);
        list.print();
        

//        System.out.println("After remove pos 0: ");
//        list.remove(0);
//        list.print();
//        System.out.println("remove 2: " + list.remove(2));
//       list.print();
//        
//        ListCircular<String> str = new ListCircular<>();
//        str.add("You");
//        str.add("Are");
//        str.add("Old");
//        str.add(3,"Yeller");
//        str.print();
//        
//        System.out.println("After removal of You: ");
//        str.remove(0);
//        str.print();
//        System.out.println("-------------Remove Old :"  );
//        str.remove("Old");
//        str.print();
    }
}
