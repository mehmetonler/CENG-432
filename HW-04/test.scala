/*
 * Created by Mehmet ONLER on 01.12.2014
 */

import scala.util.Random

object test extends App {

  val rand: Random = new Random();
  for (j <- 0 to 100000) {
    var hash: IyteHashTable = new IyteHashTable();
    println(j + ". " + "Before: Size - " + hash.getSize() + " Capacity - " + hash.getCapacity());
    for (i <- 0 to 1000000) {
      hash.set(rand.nextString(3), rand.nextString(3));
    }
    println(j + ". " + "After: Size - " + hash.getSize() + " Capacity - " + hash.getCapacity());
  }

}