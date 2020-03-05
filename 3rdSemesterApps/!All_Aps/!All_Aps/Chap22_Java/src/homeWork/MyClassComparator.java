/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeWork;
import java.util.Comparator;

public class MyClassComparator
		implements Comparator<MyClass>, java.io.Serializable {
	public int compare(MyClass o1, MyClass o2) {
		if (o1.getInstant() < o2.getInstant())
			return -1;
		else if (o1.getInstant() == o2.getInstant())
			return 0;
		else
			return 1;
	}
}
