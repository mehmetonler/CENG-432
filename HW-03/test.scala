/**
 * created by Mehmet ONLER on 22.11.2014
 */
object test extends App {
  println("---------------------------------------------------------------");
  println("IyteMutableSet Test");
  println("---------------------------------------------------------------");

  val m: IyteMutableSet = new IyteMutableSet();
  println("Set: " + m.toString());
  m.add(5);
  println("Set: " + m.toString());
  m.add(10);
  println("Set: " + m.toString());
  m.add(100);
  println("Set: " + m.toString());
  m.add(5);
  println("Set: " + m.toString());
  m.add(2);
  println("Set: " + m.toString());
  m.add(8);

  println("Set: " + m.toString());
  println("contains 10 ? - " + m.contains(10));
  println("contains 5 ? - " + m.contains(5));
  println("contains 9 ? - " + m.contains(9));

  println("\n\n---------------------------------------------------------------");
  println("IyteImmutableSet Test");
  println("---------------------------------------------------------------");

  val i1: IyteImmutableSet = new IyteImmutableSet();

  val i2 = i1.add(5);
  println("Set i1: " + i1.toString());
  println("Set i2: " + i2.toString());
  println("---------------------------------------------------------------");
  val i3 = i2.add(15);
  println("Set i1: " + i1.toString());
  println("Set i2: " + i2.toString());
  println("Set i3: " + i3.toString());
  println("---------------------------------------------------------------");
  val i4 = i3.add(2);
  println("Set i1: " + i1.toString());
  println("Set i2: " + i2.toString());
  println("Set i3: " + i3.toString());
  println("Set i4: " + i4.toString());
  println("---------------------------------------------------------------");
  val i5 = i2.add(12);
  println("Set i1: " + i1.toString());
  println("Set i2: " + i2.toString());
  println("Set i3: " + i3.toString());
  println("Set i4: " + i4.toString());
  println("Set i5: " + i5.toString());
  println("---------------------------------------------------------------");
  val i6 = i4.add(0);
  println("Set i6: " + i6.toString());
  println("---------------------------------------------------------------");
  println("set i2 - 5 ? " + i2.contains(5));
  println("set i3 - 15 ? " + i3.contains(15));
  println("set i4 - 6 ? " + i4.contains(6));
  println("set i4 - 1 ? " + i4.contains(1));
  println("set i5 - 12 ? " + i5.contains(12));
  println("set i6 - 0 ? " + i6.contains(0));
}