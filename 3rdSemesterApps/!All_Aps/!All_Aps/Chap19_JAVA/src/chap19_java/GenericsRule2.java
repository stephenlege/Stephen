package chap19_java;
import java.util.ArrayList;
import java.util.List;

public class GenericsRule2
{   
    public static  void f2(List<Number> list ){}    
    public static void main(String[] args)
    {
        f2( new ArrayList<Number>());
    }
}
