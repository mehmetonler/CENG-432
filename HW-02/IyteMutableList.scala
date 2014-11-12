/*
 * Created by Mehmet ONLER on 12.11.2014
 * */

class IyteMutableList {
  private var head: Node = IyteMutableList.newNode; // initialize head
  private var tail: Node = IyteMutableList.newNode; // initialize tail

  // add x to list
  def add(x: Int) {

    /*
     * if head equal to tail (this means list is empty)
     * create new node with link=null, data=x and assign to head
     * */
    if (head == tail) {
      head = new Node(x);

      /*
       * if head link is null (this means list has only one node)
       * then create new node with link=null,data=x and assign to tail
       * then set tail as head's link
       * */
    } else if (head.getLink() == null) {
      tail = new Node(x);
      head.setLink(tail);

      /*
       * in here, it's certain that list have more than one element
       * then, create new Node with link=null,data=x and assign to newNode
       * then, set newNode as tail's link
       * then, assign newNode to tail
       * */
    } else {
      val newNode = new Node(x);
      tail.setLink(newNode);
      tail = newNode;
    }
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

object IyteMutableList {
  var newNode: Node = null;
}