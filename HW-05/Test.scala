/**
 * Created by Mehmet ONLER on 07.12.2014
 */
object Test extends App {
  println("Test for transform: ");
  println(RandomStuff.transform(List(10, 2, 3), (x: Int) => x * 5));
  println(RandomStuff.transform(List(1, 12, 6), (x: Int) => x * x));
  println(RandomStuff.transform(List(1, 78, 2), (x: Int) => (x * 5) / 10));

  println("\nTest for allValid: ");
  println(RandomStuff.allValid(List(1, 24, 13), (x: Int) => x * x < 622));
  println(RandomStuff.allValid(List(3, 22, 34), (x: Int) => x + x < 52));
  println(RandomStuff.allValid(List(47, 45, 63), (x: Int) => (x -20)*(x-50) < 560));

  println("\nTest for executeWithRetry: ");
  println(RandomStuff.executeWithRetry(5, (13 / 0)));
  println(RandomStuff.executeWithRetry(7, (22 / 5)));
}