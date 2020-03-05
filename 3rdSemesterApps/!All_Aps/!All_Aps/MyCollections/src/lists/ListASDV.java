/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Consumer;

public class ListASDV<E>
        implements Serializable,
        Cloneable,
        Iterable<E>,
        Collection<E>, Deque<E>, List<E>, Queue<E> {

    public Node<E> head;
    public Node<E> tail;

    private int size = 0;

    public class Node<E> {

        public E e;
        public Node<E> l;
        public Node<E> r;
    }

    /**
     * Constructs an empty list.
     */
    public ListASDV() {

    }

    /**
     * Constructs a list containing the elements of the specified collection, in
     * the order they are returned by the collection's iterator.
     *
     * @param c - the collection whose elements are to be placed into this list
     * @throws NullPointerException - if the specified collection is null
     */
    public ListASDV(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return Iteraror with the implementatio of: hasNext, next
     * forEachRemaining
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            Node<E> temp = head;

            @Override
            public boolean hasNext() {
                if (temp == null || head == null) {
                    temp = head;
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E element = temp.e;
                    temp = temp.r;
                    return element;
                }
                return null;
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                while (hasNext()) {
                    action.accept(next());
                }
            }
        };
        return it;
    }

    /**
     * Inserts all of the elements in the specified collection into this list,
     * starting at the specified position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (increases
     * their indices). The new elements will appear in the list in the order
     * that they are returned by the specified collection's iterator.
     *
     * @param index - index at which to insert the first element from the
     * specified collection
     * @param c - collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * LESS 0 || index GREATER size())
     * @throws NullPointerException - if the specified collection is null
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException, index : " + index + " is out of bounds");
        }
        if (c == null) {
            throw new NullPointerException("Null Parameter " + c);
        }
        Node<E> temp = tail;
        for (E e : c) {
            add(index++, e);
        }
        return temp != tail;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * LT 0 || index GE size())
     */
    //checkIndex(index);
    //return node(index).e;
    @Override
    public E get(int index) {
        Node<E> temp = head;
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException("Out of bounds: " + index);
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.r;
            }
            return temp.e;
        }
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size() >> 1)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++) {
                x = x.r;
            }
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size() - 1; i > index; i--) {
                x = x.l;
            }
            return x;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index - index of the element to replace
     * @param element
     * @return element - the element previously at the specified position
     * @throws ClassCastException - if the class of the specified element
     * prevents it from being added to this list
     * @throws NullPointerException - if the specified element is null and this
     * list does not permit null elements
     * @throws IllegalArgumentException - if some property of the specified
     * element prevents it from being added to this list
     * @throws IndexOutOfBoundsException - if the index is out of range (index L
     * 0 || index GE size())
     */
    @Override
    public E set(int index, E element) {
        if (this.element().getClass() != element.getClass()) {
            throw new ClassCastException();
        }
        if (element == null) {
            throw new NullPointerException("null parameter");
        }
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("Out of bounds: " + index);
        }
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.r;
        }
        E old = (E) n.e;
//        tail.e = element;
//        tail = null;

        n.e = element;
        return old;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index at which the specified element is to be inserted
     * @param element - element to be appended to this list
     * @throws IndexOutOfBoundsException - if the index is out of range (index L
     * 0 || index G size())
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node node = new Node();
        node.e = element;

        if (index == 0)//insert at the front
        {
            addFirst(element);
        } else if (index == size())//insert at the end
        {
            addLast(element);
        } else//insert in the middle
        {
            Node temp = head;

            for (int i = 0; i < index - 1; ++i) {
                temp = temp.r;
            }

            node.r = temp.r;
            temp.r.l = node;
            node.l = temp;
            temp.r = node;
        }

    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position, null if empty
     * list
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * LESS 0 or index GE size()
     */
    @Override
    public E remove(int index) {
        E e = null;
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException("Index Out of bounds exception : " + index);
        }
        if (isEmpty()) {
            return null;
        } else if (size() == 1) {
            head = tail = null;
        } else if (index == 0) {
            head = head.r;
            e = head.l.e;
            head.l = null;
        } else if (index == size() - 1) {
            tail = tail.l;
            e = tail.l.e;
            tail.r = null;

        } 
        else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.r;
            }
            // temp = tail;
            e = temp.e;
            temp.l.r = temp.r;
            temp.r.l = temp.l;
        }
        return e;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     *
     * @param o - element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     * @throws ClassCastException - if the type of the specified element is
     * incompatible with this list (optional)
     */
    @Override
    public int indexOf(Object o) {
        Node<E> temp = head;
        for (int i = 0; i < size(); ++i) {
            if (o.equals(temp.e) || o.equals(temp)) {
                return i;
            } else {
                temp = temp.r;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element. More formally,
     * returns the highest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index.
     *
     *
     *
     * @param o - element to search for
     * @return the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element
     * @throws:ClassCastException - if the type of the specified element is
     * incompatible with this list (optional)
     *
     */
    @Override
    public int lastIndexOf(Object o) {
        Node<E> temp = tail;
        int index = -1;
        for (int i = size() - 1; i >= 0; i--) {
            if (o.equals(temp.e) || o.equals(temp)) {
                index = i;
                break;
            } else {
                temp = temp.l;
            }
        }
        return index;
    }

    /**
     * Returns a list-iterator of the elements in this list (in proper
     * sequence), starting at the specified position in the list. Obeys the
     * general contract of List.listIterator(int). implements : hasNext, next,,
     * previous, hasPrevious, nextIndex, previousIndex
     *
     * @param index - index of the first element to be returned from the
     * list-iterator (by a call to next)
     * @return a ListIterator of the elements in this list (in proper sequence),
     * starting at the specified position in the list
     *
     * @throws IndexOutOfBoundsException - if the index is out of range (index L
     * 0 || index G size())
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> it = new ListIterator<E>() {
            Node<E> trailNext = trailNextInitialize();
            Node<E> trailPrevious = trailNext.l;

            int nextIndex = index;
            int previousIndex = nextIndex - 1;

            Node<E> trailNextInitialize() {
                if (index < 0 || index > size()) {
                    throw new IndexOutOfBoundsException("ListIterator index out of bounds: " + index);
                }
                trailNext = head;
                for (int i = 0; i < index; ++i) {
                    trailNext = trailNext.r;
                }
                return trailNext;
            }

            @Override
            public boolean hasNext() {
                if (trailNext == null) {
                    trailNext = head;
                    trailPrevious = trailNext.l;
                    nextIndex = 0;
                    previousIndex = -1;
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                Node<E> temp = trailNext;
                trailPrevious = trailNext;
                trailNext = trailNext.r;
                previousIndex = nextIndex;
                nextIndex++;
                return temp.e;
            }

            @Override
            public boolean hasPrevious() {
                if (trailNext.l == null) {
                    trailNext = tail;
                    trailPrevious = trailNext;
                    nextIndex = 0;
                    previousIndex = -1;
                    return false;
                }
                return true;
            }

            @Override
            public E previous() {
                Node<E> temp = trailNext.l;
                trailPrevious = trailNext;
                trailNext = trailNext.l;
                previousIndex = --nextIndex;
                previousIndex--;
                return temp.e;
            }

            @Override
            public int nextIndex() {
                return nextIndex;
            }

            @Override
            public int previousIndex() {
                return previousIndex;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        return it;
    }

    /**
     * One line of code here. Call listIterator(0)
     *
     * @return
     */
    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }


    /*<exercise chapter="2" section="7" type="programming" number="1">*/
    /**
     * Method to find the index of the first occurence of an item in the list
     *
     * @param target The item being sought
     * @return The index of the first occurence of the tartet item or -1 if the
     * item is not found.
     */

    /*</exercise>*/

 /*<exercise chapter="2" section="7" type="programming" number="2">*/
    /**
     * Method to find the index of the last occurence of an item in the list
     *
     * @param target The item being sought
     * @return The index of the last occurence of the tartet item or -1 if the
     * item is not found.
     */
    /**
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex
     * are equal, the returned list is empty.) The returned list is backed by
     * this list, so non-structural changes in the returned list are reflected
     * in this list, and vice-versa. The returned list supports all of the
     * optional list operations supported by this list.
     *
     *
     * @param fromIndex - low endpoint (inclusive) of the subList
     * @param toIndex - high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws Throws: IndexOutOfBoundsException - for an illegal endpoint index
     * value (fromIndex L 0 || toIndex G size || fromIndex > toIndex)
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index out of Bounds exception " + fromIndex + " " + toIndex);
        }
        int i = 0;
        ListASDV<E> list = new ListASDV<E>();
        for (Node node = head; node != null; node = node.r) {
            if (i >= fromIndex && i < toIndex) {
                list.add((E) node.e);
            }
            i++;
        }
        return list;
    }

    @Override
    public int size() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.r;
        }
        return count;
    }

    /**
     * Tests is the list is empty
     *
     * @return true if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (head == null && size() == 0);
    }

    /**
     *
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o - element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     * @throws ClassCastException - if the type of the specified element is
     * incompatible with this list (optional)
     */
    @Override
    public boolean contains(Object o) {

        return indexOf(o) != -1;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * The returned array will be "safe" in that no references to it are
     * maintained by this list. (In other words, this method must allocate a new
     * array even if this list is backed by an array). The caller is thus free
     * to modify the returned array.
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */
    @Override
    public Object[] toArray() {
        Object[] list = new Object[size()];
        int i = 0;

        for (Node<E> node = head; node != null; node = node.r) {
            list[i] = node.e;
            i++;
        }
        return list;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array. If the list fits in the specified
     * array, it is returned therein. Otherwise, a new array is allocated with
     * the runtime type of the specified array and the size of this list. If the
     * list fits in the specified array with room to spare (i.e., the array has
     * more elements than the list), the element in the array immediately
     * following the end of the list is set to null. (This is useful in
     * determining the length of the list only if the caller knows that the list
     * does not contain any null elements.)
     *
     * Like the toArray() method, this method acts as bridge between array-based
     * and collection-based APIs. Further, this method allows precise control
     * over the runtime type of the output array, and may, under certain
     * circumstances, be used to save allocation costs.
     *
     * Suppose x is a list known to contain only strings. The following code can
     * be used to dump the list into a newly allocated array of String: String[]
     * y = x.toArray(new String[0]); Note that toArray(new Object[0]) is
     * identical in function to toArray().
     *
     * Specified by: toArray in interface Collection Type Parameters: T - the
     * runtime type of the array to contain the collection Parameters: a - the
     * array into which the elements of this list are to be stored, if it is big
     * enough; otherwise, a new array of the same runtime type is allocated for
     * this purpose. Returns: an array containing the elements of this list
     * Throws: ArrayStoreException - if the runtime type of the specified array
     * is not a supertype of the runtime type of every element in this list
     * NullPointerException - if the specified array is null
     *
     * @param <T> - the runtime type of the array to contain the collection
     * @param a - the array into which the elements of this list are to be
     * stored, if it is big enough; otherwise, a new array of the same runtime
     * type is allocated for this purpose.
     *
     * @return an array containing the elements of this list
     * @throws ArrayStoreException - if the runtime type of the specified array
     * is not a supertype of the runtime type of every element in this list
     * @throws NullPointerException - if the specified array is null
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new NullPointerException("Null pointer exception: parameter is null");
        }
        for (int i = 0; i < a.length; i++) {
            if (a.length > size()) {
                this.add(null);
            }
        }

        Object[] o = this.toArray();
        T[] list = Arrays.copyOf(a, o.length);
        for (int i = 0; i < o.length; i++) {
            list[i] = (T) o[i];
        }
        return (T[]) list;
    }

    /**
     * Appends the specified element to the end of this list. This method is
     * equivalent to addLast(E).
     *
     * @param e element to be appended to this list
     * @return true if this collection changed as a result of the call
     */
    @Override
    public boolean add(E e) {
        Node node = new Node();
        node.e = e;

        if (isEmpty())//first node in
        {
            head = tail = node;
        } else {
            //1 connect the newly created node with the rest of the list
            node.l = tail;
            tail.r = node;
            //2 move tail 
            tail = node;
        }
        return true;
    }

    /**
     * Removes a single instance of the specified element from this collection,
     * if it is present (optional operation). More formally, removes an element
     * e such that (o==null ? e==null : o.equals(e)), if this collection
     * contains one or more such elements.
     *
     *
     * @param o - element to be removed from this collection, if present
     * @return true if this collection changed as a result of the call.
     * @throws ClassCastException - if the type of the specified element is
     * incompatible with this collection (optional)
     * @throws NullPointerException - if the specified element is null and this
     * collection does not permit null elements (optional)
     */
    @Override
    public boolean remove(Object o) {
        boolean b = false;
        if (o == null) {
            throw new NullPointerException("Null Pointer exception, cant pass null arguments");
        }
        Object e = this.getLast();
        if (e.equals(o)) {
            removeLast();
            b = true;
        }
        for (int i = 0; i < size(); i++) {
            if (i == indexOf(o)) {
                remove(i);
                b = true;
            }
        }
        return b;
    }

    /**
     * Returns true if this collection contains all of the elements in the
     * specified collection.
     *
     * @param c - collection to be checked for containment in this collection
     * @return true if this collection contains all of the elements in the
     * specified collection
     * @throws ClassCastException - if the types of one or more elements in the
     * specified collection are incompatible with this collection (optional)
     * @throws NullPointerException - if the specified collection contains one
     * or more null elements and this collection does not permit null elements
     * (optional), or if the specified collection is null.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator. The behavior of this operation is undefined if the
     * specified collection is modified while the operation is in progress.
     * (Note that this will occur if the specified collection is this list, and
     * it's nonempty.)
     *
     * @param c - collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException - if the specified collection is null
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addAll(size(), c);
        return true;

    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     *
     * @param c - collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     * @throws ClassCastException - if the class of an element of this list is
     * incompatible with the specified collection (optional)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        Node<E> temp = head;
        Node<E> prev = null;
        boolean changed = false;
        while (temp != null) {
            if (c.contains(temp.e)) {
                if (prev != null) {
                    prev.r = temp.r;
                } else {
                    head = temp.r;
                }
                temp = temp.r;
                changed = true;
            } else {
                prev = temp;
                temp = temp.r;
            }
        }
        return changed;
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection (optional operation). In other words, removes from
     * this list all of its elements that are not contained in the specified
     * collection.
     *
     * @param c - collection containing elements to be retained in this list
     * @return true if this list changed as a result of the call
     * @throws ClassCastException - if the class of an element of this list is
     * incompatible with the specified collection (optional)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        Node<E> temp = head;
        Node<E> prev = null;
        boolean changed = false;
        while (temp != null) {
            if (!c.contains(temp.e)) {
                if (prev != null) {
                    prev.r = temp.r;
                } else {
                    head = temp.r;
                }
                temp = temp.r;
                changed = true;
            } else {
                prev = temp;
                temp = temp.r;
            }
        }
        return changed;
    }

    /**
     * Clears the list of all elements.
     */
    @Override
    public void clear() {
        for (Node<E> i = head; i != null;) {
            Node<E> next = i.r;
            i.e = null;
            i.r = null;
            i.l = null;
            i = next;
        }
        head = tail = null;
        size = 0;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e - the element to add
     */
    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>();
        newNode.e = e;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.r = head;
            head.l = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Appends the specified element to the end of this list. This method is
     * equivalent to add(E).
     *
     * @param e - the element to add
     */
    @Override
    public void addLast(E e) {
        add(e);
        size++;
    }

    /**
     * Inserts the specified element at the front of this deque unless it would
     * violate capacity restrictions. When using a capacity-restricted deque,
     * this method is generally preferable to the addFirst(E) method, which can
     * fail to insert an element only by throwing an exception.
     *
     * Parameters: e - the element to add Returns: true if the element was added
     * to this deque, else false Throws: ClassCastException - if the class of
     * the specified element prevents it from being added to this deque
     * NullPointerException - if the specified element is null and this deque
     * does not permit null elements IllegalArgumentException - if some property
     * of the specified element prevents it from being added to this deque
     *
     * @param e - the element to add
     * @return true if the element was added to this deque, else false
     * @throws ClassCastException if the class of the specified element prevents
     * it from being added to this deque
     * @throws IllegalArgumentException - if some property of the specified
     * element prevents it from being added to this deque
     */
    @Override
    public boolean offerFirst(E e) {
        if (this.element().getClass() != e.getClass()) {
            throw new ClassCastException();
        }
        if (this == e) {
            throw new IllegalArgumentException();
        }
        addFirst(e);
        return true;
    }

    /**
     * Inserts the specified element at the end of this deque unless it would
     * violate capacity restrictions. When using a capacity-restricted deque,
     * this method is generally preferable to the addLast(E) method, which can
     * fail to insert an element only by throwing an exception.
     *
     * Parameters: e - the element to add Returns: true if the element was added
     * to this deque, else false Throws: ClassCastException - if the class of
     * the specified element prevents it from being added to this deque
     * NullPointerException - if the specified element is null and this deque
     * does not permit null elements IllegalArgumentException - if some property
     * of the specified element prevents it from being added to this deque
     *
     * @param e - the element to add
     * @return true if the element was added to this deque, else false
     * @throws ClassCastException - if the class of the specified element
     * prevents it from being added to this deque
     * @throws IllegalArgumentException - if some property of the specified
     * element prevents it from being added to this deque *
     */
    @Override
    public boolean offerLast(E e) throws IllegalArgumentException {
        if (this.element().getClass() != e.getClass()) {
            throw new ClassCastException();
        }
        if (this == e) {
            throw new IllegalArgumentException();
        }
        addLast(e);
        return true;
    }

    /**
     * E removeFirst()
     *
     * Retrieves and removes the first element of this deque. This method
     * differs from pollFirst only in that it throws an exception if this deque
     * is empty.
     *
     * @return the head of this deque
     * @throws NoSuchElementException - if this deque is empty
     */
    @Override
    public E removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        E e = head.e;
        Node<E> next = head.r;
        head.e = null;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.l = null;
        }
        size--;
        return e;
    }

    /**
     * Retrieves and removes the last element of this deque. This method differs
     * from pollLast only in that it throws an exception if this deque is empty.
     *
     * @return the tail of this deque
     * @thows NoSuchElementException - if this deque is empty
     */
    @Override
    public E removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        E e = tail.e;
        Node<E> prev = tail.l;
        tail.e = null;
        tail = prev;
        if (prev == null) {
            head = null;
        } else {
            prev.r = null;
        }
        size--;
        return e;
    }

    /**
     * Retrieves and removes the first element of this deque, or returns null if
     * this deque is empty.
     *
     * @return the head of this deque, or null if this deque is empty
     */
    @Override
    public E pollFirst() {
        return this.isEmpty() ? null : removeFirst();
    }

    /**
     * Retrieves and removes the last element of this deque, or returns null if
     * this deque is empty.
     *
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E pollLast() {
        return this.isEmpty() ? null : removeLast();
    }

    /**
     * Retrieves, but does not remove, the first element of this deque. This
     * method differs from peekFirst only in that it throws an exception if this
     * deque is empty.
     *
     * @return the head of this deque
     * @throws NoSuchElementException - if this deque is empty
     */
    @Override
    public E getFirst() {
        if (size() < 0 || this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        Node<E> node = new Node();
        node.e = head.e;

        node.r = head;
        head.l = node;
        head = node;

        return head.e;
    }

    /**
     * Retrieves, but does not remove, the last element of this deque. This
     * method differs from peekLast only in that it throws an exception if this
     * deque is empty.
     *
     * @return the tail of this deque
     * @throws Throws: NoSuchElementException - if this deque is empty
     */
    @Override
    public E getLast() {
        if (size() < 0 || this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        Node<E> node = new Node();
        node.e = head.e;

        node.r = head;
        head.l = node;
        head = node;

        return tail.e;
    }

    /**
     * Retrieves, but does not remove, the first element of this deque, or
     * returns null if this deque is empty.
     *
     * @return the head of this deque, or null if this deque is empty
     *
     */
    @Override
    public E peekFirst() {
        if (this.isEmpty()) {
            return null;
        }
        return head.e;
    }

    /**
     * Retrieves, but does not remove, the last element of this deque, or
     * returns null if this deque is empty.
     *
     * @return the tail of this deque, or null if this deque is empty
     */
    @Override
    public E peekLast() {
        if (this.isEmpty()) {
            return null;
        }
        return tail.e;
    }

    /**
     * Removes the first occurrence of the specified element from this deque. If
     * the deque does not contain the element, it is unchanged. More formally,
     * removes the first element e such that (o==null ? e==null : o.equals(e))
     * (if such an element exists). Returns true if this deque contained the
     * specified element (or equivalently, if this deque changed as a result of
     * the call).
     *
     * @param o - element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     * @throws ClassCastException - if the class of the specified element is
     * incompatible with this deque
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        {
            if (this.element().getClass() != o.getClass()) {
                throw new ClassCastException();
            }
            Node<E> cursor = head;
            while (cursor.r != null && !cursor.r.e.equals(o)) {
                cursor = cursor.r;
            }

            if (cursor.r.r == null && cursor.r.e.equals(o)) {
                removeLast();
                return true;
            } else {
                cursor.r = cursor.r.r;
                cursor.r.l = cursor;

                return true;
            }
        }
    }

    /**
     * Removes the last occurrence of the specified element from this deque. If
     * the deque does not contain the element, it is unchanged. More formally,
     * removes the last element e such that (o==null ? e==null : o.equals(e))
     * (if such an element exists). Returns true if this deque contained the
     * specified element (or equivalently, if this deque changed as a result of
     * the call)
     *
     * @param o - element to be removed from this deque, if present
     * @return true if an element was removed as a result of this call
     * @throws ClassCastException - if the class of the specified element is
     * incompatible with this deque (optional)
     */
    @Override
    public boolean removeLastOccurrence(Object o) {
        if (this.element().getClass() != o.getClass()) {
            throw new ClassCastException();
        }
        int i = lastIndexOf(o);
        if (i != -1) {
            remove(i);
            return true;
        }
        return false;

    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions. When using a
     * capacity-restricted queue, this method is generally preferable to add(E),
     * which can fail to insert an element only by throwing an exception.
     *
     *
     * @param e - the element to add
     * @return true if the element was added to this queue, else false
     * @throws: ClassCastException - if the class of the specified element
     * prevents it from being added to this queue
     */
    @Override
    public boolean offer(E e
    ) {
        if (this.element().getClass() != e.getClass()) {
            throw new ClassCastException();
        }
        return add(e);
    }

    /**
     * Retrieves and removes the head of this queue. This method differs from
     * poll only in that it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException - if this queue is empty
     *
     */
    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
        return remove(0);
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this
     * queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     *
     */
    @Override
    public E poll() {
        return this.isEmpty() ? null : removeFirst();
    }

    /**
     * Retrieves, but does not remove, the head of this queue. This method
     * differs from peek only in that it throws an exception if this queue is
     * empty.
     *
     * @return the head of this queue
     * @throws: NoSuchElementException - if this queue is empty
     *
     */
    @Override
    public E element() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
        return head.e;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null
     * if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return head.e;
    }

    /**
     * Pushes an element onto the stack represented by this list. In other
     * words, inserts the element at the front of this list.
     *
     * This method is equivalent to addFirst(E). Specified by: push in interface
     * Deque
     *
     * @param e - the element to push
     */
    @Override
    public void push(E e
    ) {
        addFirst(e);
    }

    /**
     * Pops an element from the stack represented by this list. In other words,
     * removes and returns the first element of this list.
     *
     * This method is equivalent to removeFirst(). Specified by: pop in
     * interface Deque
     *
     * @return the element at the front of this list (which is the top of the
     * stack represented by this list)
     * @throws: NoSuchElementException - if this list is empty
     */
    @Override
    public E pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
        return removeFirst();
    }

    /**
     * Description copied from interface: Deque Returns an iterator over the
     * elements in this deque in reverse sequential order. The elements will be
     * returned in order from last (tail) to first (head).
     *
     * Specified by: descendingIterator in interface Deque
     *
     * @return an iterator over the elements in this deque in reverse sequence
     */
    @Override
    public Iterator<E> descendingIterator() {
        Iterator<E> it = new Iterator<E>() {
            Node<E> temp = tail;

            @Override
            public boolean hasNext() {
                if (temp == null || tail == null) {
                    temp = tail;
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E element = temp.e;
                    temp = temp.l;
                    return element;
                }
                return null;
            }
        };
        return it;
    }

    /**
     * Returns a deep clone of the list.
     *
     * @return the cloned list
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ListASDV<E> list = (ListASDV<E>) super.clone();
        ListASDV<E> copy = (ListASDV<E>) new ListASDV<E>();
        Iterator<E> iterator = list.iterator();
        while (iterator.hasNext()) {
            copy.add((E) iterator.next());
        }
        return copy;
    }

    /**
     *
     * @return string of list
     */
    @Override
    public String toString() {

        String s = "{ ";

        Node temp = head;

        while (temp != null) {
            s += temp.e + " ";
            temp = temp.r;
        }

        s += "}";
        return s;
    }

    public void print() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.e + " ");
            temp = temp.r;
        }
        System.out.println();
    }

    /**
     * Used for testing purposes only.
     *
     * @param args
     */
    public static void main(String[] args) throws CloneNotSupportedException {

        ListASDV<Integer> list = new ListASDV<Integer>();
        list.add(100);
        list.addFirst(50);
        list.add(1, 75);
        list.addLast(200);
        List<Integer> collection = Arrays.asList(new Integer[]{300, 400});
        list.addAll(collection);
        try {
            list.addAll(8, collection);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());

        }
        System.out.println(list);

        Iterator it = list.iterator();
        System.out.println("\ntest add methods ***************************************");
        while (it.hasNext()) {
            Object o = it.next();
            System.out.print(o + " ");
        }
//        list.remove(5);
//        System.out.println(list);
        
        System.out.println("");

        System.out.println("\nforEachRemaining(action) ***************************************");

        Consumer<Integer> action = new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.print("*" + t + " ");
            }

        };
        it = list.iterator();
        it.next();
        it.next();
        it.forEachRemaining(action);
        System.out.println("");
        while (it.hasNext()) {
            Object o = it.next();
            System.out.print(o + " ");
        }
        System.out.println("");
        it.forEachRemaining(action);

        System.out.println("");
        System.out.println("indexOf ***************************************");
        System.out.println(list.indexOf(new A()));
        System.out.println(list.indexOf(200));
        System.out.println(list.indexOf(800));

        System.out.println("\nclone() ***************************************");
        ListASDV<Integer> listCloned = (ListASDV<Integer>) list.clone();
        list.clear();
        it = listCloned.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.print(o + " ");
        }
        System.out.println("\nsize of original list after clear: " + list.size());
        list.addAll(0, listCloned);
        System.out.println("\ntoString() ***************************************\n" + list);

        System.out.println("\ncontains ***************************************");
        System.out.println(list.contains(new A()));
        System.out.println(list.contains(200));
        System.out.println(list.contains(800));

        System.out.println("\ncontainsAll ***************************************");
        try {
            System.out.println(list.containsAll((Collection) new A()));
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list.containsAll(listCloned));
        System.out.println(list.containsAll(Arrays.asList(new Integer[]{100, 300})));
        System.out.println(list.containsAll(Arrays.asList(new Integer[]{10, 300})));

        System.out.println("\ndiscendingIterator ***************************************");
        Iterator descIt = list.descendingIterator();
        while (descIt.hasNext()) {
            Object o = descIt.next();
            System.out.print(o + " ");
        }

        System.out.println("\nelement ***************************************");
        System.out.println(list.element());
        System.out.println(list.element());
        listCloned.clear();
        try {
            listCloned.element();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nget(int) ***************************************");
        System.out.println(list.get(0));
        System.out.println(list.get(list.size() - 1));
        try {
            list.get(list.size());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\ngetFirst()  ***************************************");
        System.out.println(list.getFirst());
        System.out.println(list.getFirst());
        try {
            listCloned.getFirst();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n getLAst()***************************************");
        System.out.println(list.getLast());
        System.out.println(list.getLast());

        try {
            listCloned.getLast();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n isEmpty()***************************************");
        System.out.println(list.isEmpty());
        System.out.println(listCloned.isEmpty());

        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        System.out.println("\n lastIndexOf***************************************");
        System.out.println(list);
        list.add(1, -888);
        list.add(4, -888);
        System.out.println(list);
        System.out.println(list.lastIndexOf(-888));
        System.out.println(list.lastIndexOf(12));
        System.out.println(list.lastIndexOf(new A()));

        System.out.println("\nlistIterator( index=3) using next***************************************");
        System.out.println(list);
        ListIterator itList = list.listIterator(3);

        while (itList.hasNext()) {
            Object o = itList.next();
            System.out.print("next Index " + itList.nextIndex());
            System.out.print(" previous Index " + itList.previousIndex());
            System.out.println(" node " + o + " ");
        }

        System.out.println("\nlistIterator( index=3) using previous ***************************************");
        System.out.println(list);
        itList = list.listIterator(3);

        while (itList.hasPrevious()) {
            Object o = itList.previous();
            System.out.print("next Index " + itList.nextIndex());
            System.out.print(" previous Index " + itList.previousIndex());
            System.out.println(" node " + o + " ");
        }

        System.out.println("\nlistIterator with next ***************************************");
        System.out.println(list);
        itList = list.listIterator();

        while (itList.hasNext()) {
            Object o = itList.next();
            System.out.print("next Index " + itList.nextIndex());
            System.out.print(" previous Index " + itList.previousIndex());
            System.out.println(" node " + o + " ");
        }

        System.out.println("\noffer methods ***************************************");
        list.offer(500);
        list.offerLast(600);
        list.offerFirst(33);
        System.out.println(list);

        System.out.println("\npeek poll methods ***************************************");
        System.out.println(list.peek());
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        System.out.println(listCloned.peekLast());
        System.out.println(list.poll());
        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        System.out.println(listCloned.pollFirst());

        System.out.println("\npush pop methods ***************************************");
        System.out.println(list);
        Integer o = list.pop();
        list.push(o);
        System.out.println(list);
        try {
            listCloned.pop();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nremove methods ***************************************");
        System.out.println(list);
        System.out.println(list.removeLastOccurrence(-888));
        System.out.println(list);
        System.out.println(list.remove());
        System.out.println(list.removeFirst());
        System.out.println(list);
        System.out.println(list.remove((Integer) 300));
        
        try {
            list.remove(null);
            
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            list.remove(200);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        list.remove(0);
        System.out.println(list);
        System.out.println("\nremoveAll( Collection c) ***************************************");
        list.add(0, -888);
        list.add(2, -888);
        list.add(-888);
        listCloned = (ListASDV) list.clone();
        System.out.println(list);
        List<Integer> col = Arrays.asList(new Integer[]{-888, 200});
        list.removeAll(col);
        System.out.println(list);

        System.out.println("\nretailAll( Collection c) ***************************************");
        list = (ListASDV) listCloned.clone();
        list.retainAll(col);
        System.out.println(list);

        System.out.println("\nset ***************************************");
        list.set(0, 100);
        System.out.println(list);

        System.out.println("\nsubList ***************************************");
        List<Integer> subList = list.subList(1, 3);
        System.out.println(subList);
        try {
            list.subList(1, 5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\ntoArray ***************************************");
        System.out.println(list);
        System.out.println(Arrays.asList(list.toArray()));

        Integer[] ar = new Integer[list.size()];
        System.out.println("\ntoArray(T[] ) ***************************************");
        System.out.println(list);
        System.out.println(Arrays.asList(list.toArray(ar)));

        ar = new Integer[1];
        System.out.println(Arrays.asList(list.toArray(ar)));

        ar = new Integer[list.size() + list.size()];
        System.out.println(Arrays.asList(list.toArray(ar)));

        ar = null;
        try {
            list.toArray(ar);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

}

class A {
}
