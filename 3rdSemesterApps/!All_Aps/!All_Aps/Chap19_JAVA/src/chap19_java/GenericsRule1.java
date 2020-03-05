package chap19_java;
import java.util.ArrayList;

public class GenericsRule1
{   
    public static  void f1( ArrayList<Number> list ){}    
    public static void main(String[] args)
    {
        //f1( new ArrayList<Integer>());
    }
}
