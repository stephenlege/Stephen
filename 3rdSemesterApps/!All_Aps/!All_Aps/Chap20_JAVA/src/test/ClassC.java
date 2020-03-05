/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

class ClassA<U>
  {

  U u;

  public ClassA(U str) {  u = str;  }

 public U getU() { return u; }
  }

  class ClassB<T, V> extends ClassA<V>// LINE A
  {

    public ClassB(V v) { super(v); }

  public String myMethod()
    {
    V input = getU();
   String inputString = input.toString();
   String result = "";
    for (int i = inputString.toCharArray().length;   i > 0;  i--)
            {
          int ch = inputString.toLowerCase().toCharArray()[i - 1];
           int newNumber = 0;
           while (ch > 0)
                      {
                      newNumber = newNumber * 10 + ch % 10;
                     ch = ch / 10;
                     }
             result += ((char) ((newNumber / 65) + 66));
             }
    return result;
    }
}

class ClassC
 {

   public static void main(String[] args)
     {
      ClassB<Integer, StringBuilder> obj =
                       new ClassB<Integer, StringBuilder>
                                                         (  new StringBuilder("MERIT")  );
       System.out.println(obj.myMethod());
     }
 }