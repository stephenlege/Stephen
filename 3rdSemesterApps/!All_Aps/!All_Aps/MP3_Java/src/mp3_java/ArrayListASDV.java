/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3_java;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ArrayListASDV<E>
        implements Serializable, Cloneable, List<E>, Iterable<E> {

    private E[] list;
    private int index;

    /**
     * if (index >= 2 / 3.0 * this.list.length)
     *
     * DOUBLE THE SIZE OF THE ARRAY,
     *
     * copy all element sin new array.
     */
    /**
     * public E[] checkLength(int index, E element){ if(index >= 2/3.0 *
     * this.list.length){ E [] temp = (E[])new Object[this.list.length * 2]; for
     * (int i = 0; i < temp.length;i++){ temp[i] = list[i]; } list = temp; }
     * return list; }
     */
    //private Class<E> type;
    /**
     * Constructs an empty list with an initial capacity of three.
     *
     */
    public ArrayListASDV() {
        list = (E[]) new Object[3];
        index = 0;
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity - the initial capacity of the list
     * @throws IllegalArgumentException - if the specified initial capacity is
     * negative
     */
    public ArrayListASDV(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity id negative: " + initialCapacity);
        }
        list = (E[]) new Object[initialCapacity];
        index = 0;

    }

    /**
     * Constructs a list containing the elements of the specified collection, in
     * the order they are returned by the collection's iterator.
     *
     * @param c - the collection whose elements are to be placed into this
     * @throws NullPointerException - if the specified collection is null
     *
     *
     */
    public ArrayListASDV(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns true if this collection changed as a result of the call. false if
     * this collection does not permit duplicates and already contains the
     * specified element.
     *
     * @param e - element whose presence in this collection is to be ensured
     *
     * @return true if this collection changed as a result of the call
     * @throws ClassCastException - if the class of the specified element
     * prevents it from being added to this collection
     * @throws NullPointerException - if the specified element is null and this
     * collection does not permit null elements
     * @throws IllegalArgumentException - if some property of the element
     * prevents it from being added to this collection
     */
    @Override
    public boolean add(E e) throws ClassCastException, IllegalArgumentException {
        if (e == (null)) {
            throw new NullPointerException("null parameter");
        }
        if (index >= 2 / 3.0 * this.list.length) {
            E[] list2 = (E[]) new Object[list.length * 2];
            System.arraycopy(list, 0, list2, 0, list.length);
            list = list2.clone();
        }
        list[index] = e;
        index++;
        for (E list1 : list) {
            if (list1 == null) {
                remove(list1);
            }
        }
        return true;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        return list.length;
    }

    @Override
    public String toString() {
        String s = "ArrayListASDV [";
        for (int i = 0; i < list.length; i++) {
            if (list[i] == (null)) {
                s += "";
            } else {
                s += list[i] + " ";
            }
        }
        return s += "]";
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     *
     */
    @Override
    public boolean isEmpty() {
        return list == null;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o - element whose presence in this list is to be tested
     *
     * @return true if this list contains the specified element
     *
     */
    @Override
    public boolean contains(Object o) {
        boolean check = false;

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(o)) {
                check = true;
            } else {
                check = false;
                break;
            }

        }
        /**
         * for (E list1 : list) { if (list1 == null) { throw new
         * NullPointerException("null param"); } else if (list1.equals(o)) {
         * check = true; } else { check = false; break; } }
         */
        return check;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element). The returned array will be "safe"
     * in that no references to it are maintained by this list. (In other words,
     * this method must allocate a new array). The caller is thus free to modify
     * the returned array. This method acts as bridge between array-based and
     * collection-based APIs. Returns: an array containing all of the elements
     * in this list in proper sequence
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */
    @Override
    public Object[] toArray() {
        Object[] list2 = new Object[list.length];
        for (int i = 0; i < list2.length; i++) {
            if (list[i] == null) {
                continue;
            }
            list2[i] = list[i];
        }
        return list2;
    }

    private void reflection()
            throws ClassNotFoundException {
        Class<?> asdvClass = ArrayListASDV.class;
        Class<?> superClassOfAsdvClass = Class.forName("asdvArrayList.ArrayListASDV").getSuperclass();

        // Get All Public Methods      
        Method[] publicMethods = Class.forName("asdvArrayList.ArrayListASDV").getMethods();

//prints public methods of ConcreteClass, BaseClass, Object
        for (Method m : publicMethods) {
            //System.out.println(m);
        }
        try {
            Method m = ArrayListASDV.class.getDeclaredMethod("toArray");
            Type[] genericParameterTypes = m.getGenericParameterTypes();
            for (int i = 0; i < genericParameterTypes.length; i++) {
                if (genericParameterTypes[i] instanceof ParameterizedType) {
                    Type[] parameters = ((ParameterizedType) genericParameterTypes[i]).getActualTypeArguments();
                    Arrays.toString(parameters);
                }
            }
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }

    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present. If the list does not contain the element, it is unchanged.
     * More formally, removes the element with the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     * Returns true if this list contained the specified element (or
     * equivalently, if this list changed as a result of the call).
     *
     * @param o - element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        int count = 0;
        boolean checkIt = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == o) {
                list[i] = null;
                o = null;
                checkIt = true;
                break;
            }
        }

        if (o == null) {
            E[] list2 = (E[]) new Object[list.length - 1];
            for (E list1 : list) {
                if (list1 != null) {
                    list2[count] = list1;
                    count++;
                }
            }
            list = list2.clone();
        }
        return checkIt;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after
     * this call returns. Note: Traverse the array and set all of its elements
     * to null. Set its index to zero.
     */
    @Override
    public void clear() {
        list = (E[]) new Object[0];
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * GE 0 || index GE size())
     */
    @Override
    public E get(int index) {
        if (index >= list.length) {
            throw new IndexOutOfBoundsException(index + " is out of bounds.");
        }
        return list[index];
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index - index of the element to replace
     * @param element - element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * GE 0 || index GE size())
     */
    @Override
    public E set(int index, E element) {
        E temp;
        if (index >= list.length) {
            throw new IndexOutOfBoundsException(index + " is out of bounds.");
        } else if (element == (null)) {
            throw new NullPointerException("null parameter");
        } else {
            temp = list[index];
            list[index] = element;
        }
        return temp;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index - index at which the specified element is to be inserted
     * element
     * @param - element to be inserted
     * @throws NullPointerException - if the specified element is null and this
     * collection does not permit null elements
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * GE 0 || index GE size())
     */
    @Override
    public void add(int index, E element) {
        if (index > list.length) {
            throw new IndexOutOfBoundsException(index + " is out of bounds.");
        } else if (element == (null)) {
            throw new NullPointerException("null parameter");
        }

        if (list.length == 0) {
            list = (E[]) new Object[1];
            list[index] = element;
            return;
        } else {
            E[] list2 = (E[]) new Object[list.length * 2];
            System.arraycopy(list, 0, list2, 0, list.length);
            list = list2.clone();
            list[index] = element;
            for (int i = index + 1; i < list.length; i++) {
                list[i] = list2[index];
                index++;
            }
        }
        for (E e : list) {
            if (e == null) {
                remove(e);
            }
        }
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
        final ArrayListASDV<?> other = (ArrayListASDV<?>) obj;
        if (this.index != other.index) {
            return false;
        }
        if (!Arrays.deepEquals(this.list, other.list)) {
            return false;
        }
        return true;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     *
     * @param index - the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * GE 0 || index GE size())
     */
    @Override
    public E remove(int index) throws UnsupportedOperationException {
        if (index >= list.length) {
            throw new IndexOutOfBoundsException(index + " is out of bounds");
        }
        E e = list[index];
        list[index] = null;

        remove(list[index]);
        return e;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such
     * index. Parameters:
     *
     * @param o - element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        int index = -1;
        if (list.length == -1) {
            return -1;
        }
        for (int i = 0; i < list.length; ++i) {
            if (o.equals(list[i])) {
                index = i;
                return index;
            }
        }
        return index;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element. More formally,
     * returns the highest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such
     * index. Parameters:
     *
     * @param o - element to search for
     * @return the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        if (list.length == -1) {
            return -1;
        }
        for (int i = 0; i < list.length; ++i) {
            if (o.equals(list[i])) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex
     * are equal, the returned list is empty.) The returned list is backed by
     * this list, so non-structural changes in the returned list are reflected
     * in this list, and vice-versa. The returned list supports all of the
     * optional list operations. This method eliminates the need for explicit
     * range operations (of the sort that commonly exist for arrays). Any
     * operation that expects a list can be used as a range operation by passing
     * a subList view instead of a whole list. For example, the following idiom
     * removes a range of elements from a list: list.subList(from, to).clear();
     *
     * Similar idioms may be constructed for ArrayList.indexOf(Object) and
     * ArrayList.lastIndexOf(Object), and all of the algorithms in the
     * Collections class can be applied to a subList. The semantics of the list
     * returned by this method become undefined if the backing list (i.e., this
     * list) is structurally modified in any way other than via the returned
     * list. (Structural modifications are those that change the size of this
     * list, or otherwise perturb it in such a fashion that iterations in
     * progress may yield incorrect results.)
     *
     * @param fromIndex - low endpoint (inclusive) of the subList
     * @param toIndex - high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException - for an illegal endpoint index value
     * (fromIndex LE 0 || toIndex > size || fromIndex > toIndex)
     * @throws IllegalArgumentException - if the endpoint indices are out of
     * order (fromIndex > toIndex)
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex >= list.length || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException(fromIndex + " is out of bounds.");
        }
        List<E> list2 = new ArrayListASDV(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            E e = list[i];
            list2.add(e);
        }
        return list2;

    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array. If the list fits in the specified
     * array, it is returned therein. Otherwise, a new array is allocated with
     * the runtime type of the specified array and the size of this list. If the
     * list fits in the specified array with room to spare (i.e., the array has
     * more elements than the list), the element in the array immediately
     * following the end of the collection is set to null. (This is useful in
     * determining the length of the list only if the caller knows that the list
     * does not contain any null elements.)
     *
     * @param a - the array into which the elements of the list are to be
     * stored, if it is big enough; otherwise, a new array of the same runtime
     * type is allocated for this purpose.
     * @return an array containing the elements of the list
     * @throws ArrayStoreException - if the runtime type of the specified array
     * is not a supertype of the runtime type of every element in this list
     * @throws NullPointerException - if the specified array is null
     */
    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     *
     */
    @Override
    public ListIterator<E> listIterator() {
        ListIterator<E> it = new ListIterator<E>() {

            int listIndex = 0;

            /**
             * Returns {@code true} if this list iterator has more elements when
             * traversing the list in the forward direction. (In other words,
             * returns {@code true} if {@link #next} would return an element
             * rather than throwing an exception.)
             *
             * @return {@code true} if the list iterator has more elements when
             * traversing the list in the forward direction
             */
            @Override
            public boolean hasNext() {
                return this.listIndex < ArrayListASDV.this.size();
            }

            /**
             * Returns the next element in the list and advances the cursor
             * position. This method may be called repeatedly to iterate through
             * the list, or intermixed with calls to {@link #previous} to go
             * back and forth. (Note that alternating calls to {@code next} and
             * {@code previous} will return the same element repeatedly.)
             *
             * @return the next element in the list
             * @throws NoSuchElementException if the iteration has no next
             * element
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                } else {
                    return ArrayListASDV.this.get(this.listIndex++);
                }
            }

            /**
             * Returns {@code true} if this list iterator has more elements when
             * traversing the list in the reverse direction. (In other words,
             * returns {@code true} if {@link #previous} would return an element
             * rather than throwing an exception.)
             *
             * @return {@code true} if the list iterator has more elements when
             * traversing the list in the reverse direction
             */
            @Override
            public boolean hasPrevious() {
                return this.listIndex > 0;
            }

            /**
             * Returns the previous element in the list and moves the cursor
             * position backwards. This method may be called repeatedly to
             * iterate through the list backwards, or intermixed with calls to
             * {@link #next} to go back and forth. (Note that alternating calls
             * to {@code next} and {@code previous} will return the same element
             * repeatedly.)
             *
             * @return the previous element in the list
             * @throws NoSuchElementException if the iteration has no previous
             * element
             */
            @Override
            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException("No more elements");
                } else {
                    return ArrayListASDV.this.get(this.listIndex--);
                }
            }

            /**
             * Returns the index of the element that would be returned by a
             * subsequent call to {@link #next}. (Returns list size if the list
             * iterator is at the end of the list.)
             *
             * @return the index of the element that would be returned by a
             * subsequent call to {@code next}, or list size if the list
             * iterator is at the end of the list
             */
            @Override
            public int nextIndex() {
                if (this.listIndex < list.length - 1) {
                    return this.listIndex + 1;
                } else {
                    return list.length;
                }
            }

            /**
             * Returns the index of the element that would be returned by a
             * subsequent call to {@link #previous}. (Returns -1 if the list
             * iterator is at the beginning of the list.)
             *
             * @return the index of the element that would be returned by a
             * subsequent call to {@code previous}, or -1 if the list iterator
             * is at the beginning of the list
             */
            @Override
            public int previousIndex() {
                if (this.listIndex > 0) {
                    return this.listIndex - 1;
                } else {
                    return -1;
                }
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

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            int itIndex = 0;

            public int getItIndex() {
                return itIndex;
            }

            /**
             * Returns {@code true} if the iteration has more elements. (In
             * other words, returns {@code true} if {@link #next} would return
             * an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return this.itIndex < ArrayListASDV.this.size();
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more
             * elements
             */
            @Override
            public E next() {
                if (hasNext() == false) {
                    throw new NoSuchElementException("no more elements");
                }
                return ArrayListASDV.this.get(this.itIndex++);
            }

        };
        return it;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list. The specified
     * index indicates the first element that would be returned by an initial
     * call to {@link ListIterator#next next}. An initial call to
     * {@link ListIterator#previous previous} would return the element with the
     * specified index minus one.
     *
     * @param index index of the first element to be returned from the list
     * iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range
     * ({@code index < 0 || index > size()})
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        if (index > list.length) {
            throw new IndexOutOfBoundsException(index + " is illegal");
        }
        ListIterator<E> it = new ListIterator<E>() {

            int nextIndex = index;

            public int getNextIndex() {
                return nextIndex;
            }

            /**
             * Returns true if this list iterator has more elements when
             * traversing the list in the forward direction. (In other words,
             * returns true if ListIterator.next would return an element rather
             * than throwing an exception.)
             *
             * @return true if the list iterator has more elements when
             * traversing the list in the forward direction
             */
            @Override

            public boolean hasNext() {
                return this.nextIndex < ArrayListASDV.this.size();
            }

            /**
             * Returns the next element in the list and advances the cursor
             * position. This method may be called repeatedly to iterate through
             * the list, or intermixed with calls to ListIterator.previous to go
             * back and forth. (Note that alternating calls to next and previous
             * will return the same element repeatedly.)
             *
             * @Returns: the next element in the list
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("no more elements");
                }
                return ArrayListASDV.this.get(this.nextIndex++);
            }

            /**
             * Returns {@code true} if this list iterator has more elements when
             * traversing the list in the reverse direction. (In other words,
             * returns {@code true} if {@link #previous} would return an element
             * rather than throwing an exception.)
             *
             * @return {@code true} if the list iterator has more elements when
             * traversing the list in the reverse direction
             */
            @Override
            public boolean hasPrevious() {
                return this.nextIndex > 0;
            }

            /**
             * Returns the previous element in the list and moves the cursor
             * position backwards. This method may be called repeatedly to
             * iterate through the list backwards, or intermixed with calls to
             * {@link #next} to go back and forth. (Note that alternating calls
             * to {@code next} and {@code previous} will return the same element
             * repeatedly.)
             *
             * @return the previous element in the list
             * @throws NoSuchElementException if the iteration has no previous
             * element
             */
            @Override
            public E previous() {
                if (hasPrevious() == false) {
                    throw new NoSuchElementException("Start of Array");
                }
                return ArrayListASDV.this.get(this.nextIndex-- - 1);
            }

            /**
             * Returns the index of the element that would be returned by a
             * subsequent call to {@link #next}. (Returns list size if the list
             * iterator is at the end of the list.)
             *
             * @return the index of the element that would be returned by a
             * subsequent call to {@code next}, or list size if the list
             * iterator is at the end of the list
             */
            @Override
            public int nextIndex() {
                if (nextIndex <= list.length) {
                    return nextIndex;
                } else {
                    return list.length;
                }
            }

            /**
             * Returns the index of the element that would be returned by a
             * subsequent call to {@link #previous}. (Returns -1 if the list
             * iterator is at the beginning of the list.)
             *
             * @return the index of the element that would be returned by a
             * subsequent call to {@code previous}, or -1 if the list iterator
             * is at the beginning of the list
             */
            @Override
            public int previousIndex() {
                if (this.nextIndex > 0) {
                    return this.nextIndex - 1;
                } else {
                    return -1;
                }
            }

            /**
             * Performs the given action for each remaining element until all
             * elements have been processed or the action throws an exception.
             * Actions are performed in the order of iteration, if that order is
             * specified. Exceptions thrown by the action are relayed to the
             * caller.
             *
             * @implSpec
             * <p>
             * The default implementation behaves as if:              <pre>{@code
             *     while (hasNext())
             *         action.accept(next());
             * }</pre>
             *
             * @param action The action to be performed for each element
             * @throws NullPointerException if the specified action is null
             * @since 1.8
             */
            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                if (action == null) {
                    throw new NullPointerException("parameter is null");
                }
                while (hasNext()) {
                    action.accept(next());
                }

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
     * Returns <tt>true</tt> if this list contains all of the elements of the
     * specified collection.
     *
     * @param c collection to be checked for containment in this list
     * @return <tt>true</tt> if this list contains all of the elements of the
     * specified collection
     * @throws ClassCastException if the types of one or more elements in the
     * specified collection are incompatible with this list
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified collection contains one or
     * more null elements and this list does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>), or if the
     * specified collection is null
     * @see #contains(Object)
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        boolean check = false;
        //Iterator it = c.iterator();

        if (c.equals(null)) {
            throw new NullPointerException("null parameter");
        } else if (c.getClass() != this.getClass()) {
            System.out.println(c.getClass().getName() + " ---------------- " + this.getClass().getName());
            throw new ClassCastException("class aint right");
        }
        System.out.println(c.getClass().getName() + " ************* " + this.getClass().getName());

        /**
         * while (it.hasNext()) { Iterator thisIt = this.iterator(); while
         * (thisIt.hasNext()) { if (thisIt.next().equals(it.hasNext())) { check
         * = true; } else { check = false; break; } } }
         */
        for (E e : ArrayListASDV.this.list) {

            if (c.contains(e)) {
                check = true;
            } else {
                check = false;
                break;
            }

        }
        return check;

    }

    public Class<?> getGenericClass() {
        Class<?> result = null;
        Type type = this.getClass().getGenericSuperclass();

        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type[] fieldArgTypes = pt.getActualTypeArguments();
            result = (Class<?>) fieldArgTypes[0];
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends E> c
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (E e : list) {
            if (e == c) {
                remove(e);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args)
            throws ClassNotFoundException {

        /**
         * ArrayListASDV<Integer> list1 = new ArrayListASDV();
         * ArrayListASDV<String> list2 = new ArrayListASDV(4); ArrayListASDV<A1>
         * list3 = new ArrayListASDV(4);
         *
         * System.out.println("------------------------------ "); try {
         * list2.add(null); } catch (NullPointerException e) {
         * System.err.println(e); };
         *
         * System.out.println("test add");
         *
         * list1.add(10); list1.add(20); list3.add(new A1(-1)); list3.add(new
         * A1(-2));
         *
         * list2.add("a"); System.out.print("");
         *
         * list2.add("b"); list2.add("c"); list2.add("d");
         *
         * System.out.println("------------------------------ ");
         * System.out.println("test toString");
         *
         * System.out.print("");
         *
         * System.out.println(list1); System.out.println(list2);
         * System.out.println(list3);
         *
         * System.out.println("------------------------------ ");
         * System.out.println("test contains"); System.out.println("contains
         * E"); System.out.println("contains c: " + list2.contains("c"));
         * System.out.println("contains null: " + list2.contains(null));
         * System.out.println("contains k: " + list2.contains('k'));
         * System.out.println(list2); System.out.println("contains A(-1): " +
         * list3.contains(new A1(-1))); System.out.println("contains A(-3): " +
         * list3.contains(new A1(-3)));
         *
         * System.out.println("------------------------------ ");
         * System.out.print("test toArray(): "); Object[] ar = list2.toArray();
         * System.out.print("[ "); for (int i = 0; i < ar.length; ++i) {
         * System.out.print(ar[i] + " ");
         * }
         * System.out.println(" ] ");
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test clear()");
         * list2.clear();
         * System.out.println(list2);
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test size");
         * System.out.println(list2.size());
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test add(index, element)");
         * for (char a = 'Z'; a >= 'A'; --a) { int tempIndex = 0;
         * list2.add(tempIndex, "" + a); tempIndex++; }
         *
         * System.out.println("current array size: " + new
         * ArrayListASDV(8).size()); System.out.println("current array size: " +
         * new ArrayListASDV(16).size()); System.out.println("current array
         * size: " + new ArrayListASDV(32).size());
         *
         * System.out.println(list2);
         *
         * list2.add(26, "z"); System.out.println(list2);
         *
         * list2.add(list2.size() - 2, "y"); System.out.println(list2);
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test remove(index)"); Object o =
         * list2.remove(27); System.out.println(o); System.out.println(list2);
         *
         * try { list2.remove(30); } catch (IndexOutOfBoundsException e) {
         * System.err.println(e); }
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test remove(Object)"); list2.remove("y");
         * System.out.println(list2); System.out.println(list2.remove("not in
         * there"));
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test set(index, Object)"); list2.set(0, "0");
         * list2.set(25, "25"); System.out.println(list2);
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test indexOf()");
         * System.out.println(list2.indexOf("0"));
         * System.out.println(list2.indexOf("B"));
         * System.out.println(list2.indexOf("25"));
         * System.out.println(list2.indexOf("Y"));
         * System.out.println(list2.indexOf("not there"));
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test lastndexOf()"); list2.add(10, "0");
         * System.out.println(list2.indexOf("0"));
         * System.out.println(list2.lastIndexOf("0"));
         * System.out.println(list2.indexOf("not there"));
         * System.out.println(list2);
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test sublist(from, to)");
         *
         * List<String> l1 = list2.subList(1, 10); ArrayListASDV<String> l2 =
         * (ArrayListASDV<String>) list2.subList(11, 26);
         *
         * System.out.println(l1); System.out.println(l2); List<String> l3 =
         * l2.subList(11, 11); System.out.println(l3); try { l2.subList(12, 11);
         * } catch (Exception e) { System.err.println(e); }
         *
         * System.out.println("\n---------------------------------------");
         * System.out.println("test toArray()"); Object[] ar1 = l2.toArray();
         * for (Object obj : ar1) { System.out.print(obj + " "); }
         * System.out.println("");
         *
         * //**started on itterator here System.out.println("");
         * System.out.println(list2); System.out.println("");
         *
         * Iterator<String> it = list2.iterator();
         *
         * while (it.hasNext()) {
         *
         * System.out.print(it.next() + " "); } System.out.println("");
         *
         * List<String> arr = Arrays.asList("a", "b"); it = arr.iterator();
         * while (it.hasNext()) { /** for (int i = list2.size(); i > 0; i--) {
         * if (list2.get(i) == null) { list2.remove(list2.get(i)); }}
         *
         * System.out.print(it.next() + " "); } System.out.println("");
         *
         */
        ArrayListASDV<String> list2 = new ArrayListASDV(4);
        ArrayListASDV<A1> list3 = new ArrayListASDV(4);
        list3.add(new A1(-1));
        list3.add(new A1(-2));
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        System.out.println("------------------------------ ");
        System.out.println("test iterator()");
        Iterator<String> itS = list2.iterator();
        Iterator<A1> itA1 = list3.iterator();
        while (itS.hasNext()) {
            System.out.print(itS.next());
        }
        System.out.println("");
        for (; itA1.hasNext();) {
            System.out.print(itA1.next());
        }
        System.out.println("------------------------------ ");
        System.out.println("test listIterator( 0 )");
        List<String> list1 = Arrays.asList("a", "b", "c", "d");
        ListIterator<String> lit1 = list1.listIterator(0);
        ListIterator<String> lit2 = list2.listIterator(0);
        while (lit2.hasNext() && lit2.hasNext()) {
            System.out.print(lit1.nextIndex() + ", " + lit1.next() + ", " + lit2.nextIndex() + ", "
                    + lit2.next() + "     ");
        }
        System.out.println("");
        while (lit1.hasPrevious() && lit2.hasPrevious()) {
            System.out.print(lit1.previousIndex() + ", " + lit1.previous() + ", " + lit2.previousIndex()
                    + ", " + lit2.previous() + "     ");
        }
        System.out.println("------------------------------ ");
        System.out.println("test listIterator( 2 )");
        lit2 = list2.listIterator(2);
        while (lit2.hasNext()) {
            System.out.print(lit2.previousIndex() + ", " + lit2.nextIndex() + ", " + lit2.next() + "     ");
        }
        System.out.println("------------------------------ ");
        System.out.println("test listIterator( 5 )");
        lit2 = list2.listIterator(4);
        try {
            lit2 = list2.listIterator(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        /**
         * ListIterator<A1> itL3 = list3.listIterator(0);
         * System.out.println(list3);
         *
         * itL3.forEachRemaining(list3.get(1)); System.out.println(list3);
         */
        //////////////////////////////////////////MycontainsAll
        System.out.println(list3);

        System.out.println("list1: " + list1);

        System.out.println("list2: " + list2);
        try {
            System.out.println("list2.containsAll(list1): "
                    + list2.containsAll(list1));
        } catch (ClassCastException ex) {
            System.err.println(ex);
        }
        System.out.println("");

        ArrayListASDV<String> list5 = new ArrayListASDV(4);
        list5.add("a");
        list5.add("X");
        System.out.println("list5: " + list5);
        System.out.println("list5.containsAll(list2): "
                + list5.containsAll(list2));

        System.out.println("-----------------------------------");
        list2 = new ArrayListASDV<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        System.out.println(list2);
        System.out.println("test containsAll(Collection<?> c)");
        
        Collection<?> cObject = Arrays.asList("d", 2);
        try {
            list2.containsAll(cObject);
        } catch (ClassCastException ex) {
            System.err.println(ex);
        }
        try{
            System.out.println("list1 contains list2? " + list1.containsAll(list2));
        }catch (ClassCastException ex){
            System.err.println(ex);
        }
    }

}

class A1 implements Consumer<A1> {

    int x;

    public A1(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "A1{" + "x=" + x + '}';
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
        final A1 other = (A1) obj;
        if (this.x != other.x) {
            return false;
        }
        return true;
    }

    /**
     * Performs this operation on the given argument. squares x
     *
     * @param t the input argument
     */
    @Override
    public void accept(A1 t) {
        t.x = t.x * t.x;
    }

    @Override
    public Consumer<A1> andThen(Consumer<? super A1> after) {
        return Consumer.super.andThen(after); //To change body of generated methods, choose Tools | Templates.
    }

}
