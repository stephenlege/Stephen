package chap19_java;

import java.util.ArrayList;
import java.util.List;

public class GenericsRule7 {

    public static void main(String[] args) {

        List<A> list1 = new ArrayList();
        list1.add(new C());
        list1.add(new B());
        list1.add(new B());

        List<? extends A> list = list1;

        ArrayList<B> list2 = new ArrayList();
        list1.add(new A());
        list = list2;

        System.out.println(list1.size());
        list2.add(new B());
        list2.add(new C());
        
        System.out.println(list.size());
        
        ArrayList<C> list3 = new ArrayList();
        list = list3;
        System.out.println(list.size());
    }
}
