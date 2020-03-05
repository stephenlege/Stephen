/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Question4
{

}
abstract class Animal1{}
abstract class Plant1{}
class Grass1 extends Plant1{}
interface Hungry1<E> { void eats( E x); }

interface Harnivore1<E extends Plant1> extends Hungry1<E>{}

class Goat1 extends Animal1 implements Harnivore1<Plant1>
    {

      @Override
     public void eats(Plant1 x) { System.out.println("eats"); }

     public static void main(String[] args)
     {
     Goat1 goat1 = new Goat1(); //line 1
      goat1.eats( new Grass1()); //line 2


      goat1.eats( new Plant1() { } ); //line 3

//the braces in bold in line 3 means it has implemented all abstract methods
           //  goat1.eats( new Harnivore1<Plant1>()) ;//line 4
   Harnivore1 h1 = new Harnivore1<Plant1>() //line 5
       {
        @Override
          public void eats(Plant1 x){}
    };

 }
}
