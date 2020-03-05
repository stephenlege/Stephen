package chap19_java;

public class Exercise19_02 {
  public static void main(String[] args) {
    GenericStack<String> stack = new GenericStack<>();
    stack.push("Tom");
    stack.push("George");
    stack.push("Peter");
    System.out.println(stack.getSize());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
      System.out.println(stack.getSize());
    System.out.println(stack.peek());
    
  }

  // GenericStack.java: Implementing a stack using inheritance
  static class GenericStack<E> extends java.util.ArrayList<E> {
    @Override
    public boolean isEmpty() {
      return super.isEmpty();
    }

    public int getSize() {
      return size();
    }

    public Object peek() {
      return get(getSize() - 1);
    }

    public Object pop() {
      Object o = get(getSize() - 1);
      remove(getSize() - 1);
      return o;
    }

    public Object push(E o) {
      add(o);
      return o;
    }

    public int search(Object o) {
      return indexOf(o);
    }

    @Override
    public String toString() {
      return "stack: " + toString();
    }
  }
}
