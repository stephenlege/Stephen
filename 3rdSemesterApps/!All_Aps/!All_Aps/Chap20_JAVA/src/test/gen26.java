/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.ArrayList;
/**
 *
 * @author Greg
 */
public class gen26 {
    
}

abstract class Animal{}
abstract class Plant{}
class Grass extends Plant{}

interface Hungry<E> { void eats( E x); }
interface Carnivore<E extends Animal> extends Hungry<E>{}
 interface Harnivore<E extends Animal> extends Hungry<E>{}



class Wolf extends Animal implements Carnivore<Sheep>
  {
  public void eats(Sheep x){}
  }


class Sheep extends Animal implements Harnivore<Sheep>
  {
  public void eats(Sheep x){}
  }