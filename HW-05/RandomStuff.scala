/**
 * Created by Mehmet ONLER on 07.12.2014
 */

trait RandomStuffTrait {
  def transform(list: List[Int], op: (Int) => Int): List[Int];
  def allValid(list: List[Int], op: (Int) => Boolean): Boolean;
  def executeWithRetry(retryCount: Int, op: => Int): Option[Int];
}
object RandomStuff extends RandomStuffTrait {
  /**
   * take a list and a function
   * apply the function to list and return the list
   */
  def transform(list: List[Int], op: (Int) => Int): List[Int] = {
    var result: List[Int] = List();
    for (l <- list) {
      result = result :+ op(l)
    }
    result;
  }
  /**
   * take a list and a function
   * apply the function to all element of the list
   * if one of them return false then return false else return true
   */
  def allValid(list: List[Int], op: (Int) => Boolean): Boolean = {
    list.foreach(l => if (!op(l)) {
      return false;
    });
    true;
  }

  /**
   * take a retryCount and a function
   * try run the function if it is ok then return the value of function else try it again until retryCount
   * if it hit to retryCount then return None;
   */
  def executeWithRetry(retryCount: Int, op: => Int): Option[Int] = {
    for (i <- 1 to retryCount) {
      println(i);
      try {
        return Option(op)
      } catch {
        case ex: Exception => {
        }
      }
    }
    None;
  }

}