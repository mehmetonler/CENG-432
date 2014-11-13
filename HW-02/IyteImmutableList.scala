/*
 * Created by Mehmet ONLER on 12.11.2014
 * */

class IyteImmutableList(val list: Node) {
  val head: Node = list;

  def this() { //if user don't pass a node than assume it null
    this(null);
  }

  /* adding x to list
   * return instance of IyteImmutableList
   * */
  def add(x: Int): IyteImmutableList = {
    new IyteImmutableList(	if (head == null) {
						      new Node(x);
						    } else {
						      new Node(head, x);
						    });
  }

  override def toString(): String = {
    var result: String = "";
    var temp: Node = head;
    if (temp != null) {
      while (temp.getLink() != null) {
        result = result + temp.getData() + ",";
        temp = temp.getLink();
      }
      result = result + temp.getData();
    } else {
      result = "<<empty list>>";
    }
    result;
  }
}

object IyteImmutableList {

  def apply(list:Node) = new IyteMutableList();
}