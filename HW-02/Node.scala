/*
 * Created by Mehmet ONLER on 12.11.2014
 * */

class Node(val newLink: Node, val newData: Int) {
  private var link: Node = newLink;
  private val data: Int = newData;

  def this() {
    this(null, 0);
  }
  def this(newData: Int) {
    this(null, newData);
  }

  def this(newLink: Node) {
    this(newLink, 0);
  }

  def getData(): Int = {
    data;
  }

  def getLink(): Node = {
    link;
  }

  def setLink(newLink: Node): Node = {
    link = newLink;
    this;
  }

}