/*
 * Created by Mehmet ONLER on 18.11.2014
 */

class IyteMutableSet {
  
  private val set: Set = new Set();

  def add(x: Int) {
    set.add(x);
  }

  def contains(x: Int): Boolean = {
    set.contain(x)._1;
  }

  override def toString(): String = {
    set.toString();
  }
}

object IyteMutableSet {
  def apply() = new IyteMutableSet();
}