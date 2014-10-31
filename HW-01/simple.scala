/*
 * Mehmet ÖNLER
 * 180201042
 * 01.11.2014
 * */

object simple extends App{

  val num = Array(10,25,30);
  
  num.foreach((i:Int) => if(i % 2 == 0) println(i*2) else println(i*3));
}