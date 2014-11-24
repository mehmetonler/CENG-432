/*
 * Created by Mehmet ONLER on 18.11.2014
 */

class IyteImmutableSet(nSet: Set){
  private val set: Set = nSet;

  def this(){
    this(new Set());
  }
  private def this(newSet:Set,newValue:Int){
    this(newSet);
    set.add(newValue);    
  }

  def add(x: Int): IyteImmutableSet = {
    new IyteImmutableSet(new Set(set,x));
  }

  def contains(x: Int): Boolean = {
    /**
     * Set contain function return a tuple 
     * ._1 - boolean value -> is value exist or not 
     * ._2 - int value -> if exist then in which index
     * */
    set.contain(x)._1;
  }

  override def toString(): String = {
    set.toString();
  }
}

object IyteImmutableSet {
  def apply() = new IyteMutableSet();
}