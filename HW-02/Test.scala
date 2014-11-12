/*
 * Created by Mehmet ONLER on 12.11.2014
 * */

object testMutable extends App {

  println("Test For IyteMutableList =>");
  var m = new IyteMutableList();
  println("Befor adding anything: " + m.toString());
  m.add(10);
  m.add(25);
  println("after adding 10 and 25: " + m.toString());
  m.add(5);
  m.add(40);
  println("After adding 10,25,5 and 40: " + m.toString());
  println();
  println("Test For IyteImmutableList =>");
  val im1 = new IyteImmutableList();
  val im2 = im1.add(2);
  val im3 = im2.add(5);
  val im4 = im3.add(6);
  val im5 = im2.add(8);

  println("im1: " + im1.toString);
  println("im2: " + im2.toString);
  println("im3: " + im3.toString);
  println("im4: " + im4.toString);
  println("im5: " + im5.toString);
}