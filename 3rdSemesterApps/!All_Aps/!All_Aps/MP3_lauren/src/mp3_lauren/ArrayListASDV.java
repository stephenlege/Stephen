/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3_lauren;

/**
 *
 * @author Greg
 */
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Lauren
 * @param <E>
 */
public class ArrayListASDV<E>
        implements Serializable, Cloneable, List<E> {

    private E[] list;
    private int index;

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
            throw new IllegalArgumentException("initialCapacity is negative: " + initialCapacity);
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
        if (c == null) {
            throw new NullPointerException("null parameter");
        }
        list = (E[]) c.toArray();

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
    public boolean add(E e) throws ClassCastException,
            IllegalArgumentException {
        if (e == null) {
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
        System.out.print("ArrayListASDV[");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.print("]");
        System.out.println();
        return "";
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     *
     */
    @Override
    public boolean isEmpty() {
        return list.length == 0;
    }

    /**
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e
     * such that (o==null ? e==null : o.equals(e)).
     *
     * @param o - element whose presence in this list is to be tested
     *
     * @return true if this list contains the specified element
     *
     */
    @Override
    public boolean contains(Object o) {
        for (E list1 : list) {
            if (o == null ? list1 == null : o.equals(list1)) {
                return true;
            }
        }
        return false;
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
        E[] ar = list.clone();
        return ar;
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
     * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
     * Returns true if this list contained the specified element (or
     * equivalently, if this list changed as a result of the call).
     *
     * @param o - element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        int count = 0;
        boolean isRemoved = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == o) {
                list[i] = null;
                o = null;
                isRemoved = true;
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
        return isRemoved;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after
     * this call returns. Note: Traverse the array and set all of its elements
     * to null. Set its index to zero.
     */
    @Override
    public void clear() {
        list = (E[]) new Object[0];
        index = 0;
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
    public E get(int index) throws IndexOutOfBoundsException {
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
    public E set(int index, E element) throws IndexOutOfBoundsException {
        return list[index] = element;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).
     *
     * @param index - index at which the specified element is to be inserted
     * element
     * @param element
     * @param - element to be inserted
     * @throws NullPointerException - if the specified element is null and this
     * collection does not permit null elements
     * @throws IndexOutOfBoundsException - if the index is out of range (index
     * GE 0 || index GE size())
     */
    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (element == null) {
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
        for (E list1 : list) {
            if (list1 == null) {
                remove(list1);
            }
        }
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
    public E remove(int index) {
        if (index >= list.length) {
            throw new IndexOutOfBoundsException(index + " is out of bounds");
        }
        E removed = list[index];
        list[index] = null;

        remove(list[index]);
        return removed;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element. More
     * formally, returns the lowest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index. Parameters:
     *
     * @param o - element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        int index1 = -1;
        for (int i = 0; i < list.length; i++) {
            if ((o != null) && (list[i] != null)) {
                if (list[i].equals(o)) {
                    index1 = i;
                    break;
                }
            }
        }
        return index1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element. More formally,
     * returns the highest index i such that (o==null ? get(i)==null :
     * o.equals(get(i))), or -1 if there is no such index. Parameters:
     *
     * @param o - element to search for
     * @return the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object o) {
        int index1 = -1;
        for (int i = list.length - 1; i >= 0; i--) {
            if ((o != null) && (list[i] != null)) {
                if (list[i].equals(o)) {
                    index1 = i;
                    break;
                }
            }
        }
        return index1;
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
    public List<E> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex (" + fromIndex
                    + ") must be smaller than or equal to toIndex (" + toIndex + ").");
        }
        List<E> subList1 = new ArrayListASDV<>(toIndex - fromIndex);
        for (int i = 0; i < subList1.size(); i++) {
            subList1.set(i, list[fromIndex]);
            fromIndex++;
        }

        return subList1;
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

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator(int index
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ArrayListASDV<Integer> list1 = new ArrayListASDV();
        ArrayListASDV<String> list2 = new ArrayListASDV(4);
        ArrayListASDV<A1> list3 = new ArrayListASDV(4);

        System.out.println("------------------------------ ");
        System.out.println("test add");
        list1.add(10);
        list1.add(20);
        list3.add(new A1(-1));
        list3.add(new A1(-2));

        list2.add("a");
        try {
            list2.add(null);
        } catch (NullPointerException e) {
            System.err.println(e);
        };

        list2.add("b");
        list2.add("c");
        list2.add("d");
        System.out.println("------------------------------ ");
        System.out.println("test toString");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        System.out.println("------------------------------ ");
        System.out.println("test contains");
        System.out.println("contains E");
        System.out.println("contains c: " + list2.contains("c"));
        System.out.println("contains null: " + list2.contains(null));
        System.out.println("contains k: " + list2.contains('k'));
        System.out.println(list2);
        System.out.println("contains A(-1): " + list3.contains(new A1(-1)));
        System.out.println("contains A(-3): " + list3.contains(new A1(-3)));

        System.out.println("------------------------------ ");
        System.out.print("test toArray(): ");
        Object[] ar = list2.toArray();
        System.out.print("[ ");
        for (int i = 0; i < ar.length; ++i) {
            System.out.print(ar[i] + " ");
        }
        System.out.println(" ] ");

        System.out.println("\n---------------------------------------");
        System.out.println("test clear()");
        list2.clear();
        System.out.println(list2);

        System.out.println("\n---------------------------------------");
        System.out.println("test size");
        System.out.println(list2.size());

        System.out.println("\n---------------------------------------");
        System.out.println("test add(index, element)");
        for (char a = 'Z'; a >= 'A'; --a) {
            list2.add(0, "" + a);
        }
        System.out.println(list2);

        list2.add(26, "z");
        System.out.println(list2);

        list2.add(list2.size() - 2, "y");
        System.out.println(list2);

        System.out.println("\n---------------------------------------");
        System.out.println("test remove(index)");
        Object o = list2.remove(27);
        System.out.println(o);
        System.out.println(list2);

        try {
            list2.remove(30);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
        }

        System.out.println("\n---------------------------------------");
        System.out.println("test remove(Object)");
        list2.remove("y");
        System.out.println(list2);
        System.out.println(list2.remove("not in there"));

        System.out.println("\n---------------------------------------");
        System.out.println("test set(index, Object)");
        list2.set(0, "0");
        list2.set(25, "25");
        System.out.println(list2);

        System.out.println("\n---------------------------------------");
        System.out.println("test indexOf()");
        System.out.println(list2.indexOf("0"));
        System.out.println(list2.indexOf("B"));
        System.out.println(list2.indexOf("25"));
        System.out.println(list2.indexOf("Y"));
        System.out.println(list2.indexOf("not there"));

        System.out.println("\n---------------------------------------");
        System.out.println("test lastIndexOf()");
        list2.add(10, "0");
        System.out.println(list2.indexOf("0"));
        System.out.println(list2.lastIndexOf("0"));
        System.out.println(list2.indexOf("not there"));
        System.out.println(list2);

        System.out.println("\n---------------------------------------");
        System.out.println("test sublist(from, to)");
        List<String> l1 = list2.subList(1, 10);
        ArrayListASDV<String> l2 = (ArrayListASDV<String>) (list2.subList(11, 26));

        System.out.println(l1);
        System.out.println(l2);
        List<String> l3 = l2.subList(11, 11);
        System.out.println(l3);
        try {
            l2.subList(12, 11);
        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println("\n---------------------------------------");
        System.out.println("test toArray()");
        Object[] ar1 = l2.toArray();
        for (Object obj : ar1) {
            System.out.print(obj + " ");
        }
        System.out.println("");

    }

}

class A1 {

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

}
