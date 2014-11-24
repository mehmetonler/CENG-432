/*
 * Created by Mehmet ONLER on 24.11.2014
 */

class Set() {
  private var sizeOfArray: Int = 10;
  private var data: Array[Int] = new Array[Int](sizeOfArray);
  private var lastIndex: Int = -1;

  /**
   * This is a alternative constructor for IyteImmutableSet
   * @param oldSet - Set => preivous exist Set object
   * @param newValue - Int => new Integer value which will be added to Set
   */
  def this(oldSet: Set, newValue: Int) {
    this();
    //make a copy of oldSet and assign to data
    data = oldSet.getData().clone();
    // get sizeOfArray from oldSet and assign to sizeOfArray
    sizeOfArray = oldSet.getSizeOfArray();
    // get lastIndex of oldSet and assing to lastIndex
    lastIndex = oldSet.getLastIndex();
    // add new value to new set
    add(newValue);
  }

  def getSizeOfArray(): Int = {
    sizeOfArray;
  }

  def getData(): Array[Int] = {
    data;
  }

  def getLastIndex(): Int = {
    lastIndex;
  }

  /**
   * @param value : Int
   *
   * take a integer value and try to add set
   *
   * firstly, if array is full, increase size of array
   * Then, 	if array is empty then add it into index= 0
   * 		if 'value' smaller than smallest element of the list than add to index = 0
   *   		if 'value' bigger than biggest element of the set than add to index = lastIndex + 1
   * 		otherwise continue to process
   * Then, call the contain function
   * 	'contain' function return a tuple (Boolean,Int)
   *  		tuple can be (true,-2) which means value already exist or (false,some integer number) which means value do not exist we should add it
   *    if ._1 false then call the shiftElementsToAddNew function in order to add new element
   *    otherwise do nothing
   */
  def add(value: Int): Unit = {
    if (data.length - 1 == lastIndex) {
      increaseSizeOf();
    }

    if (lastIndex == -1) {
      data(0) = value;
      lastIndex = 0;
    } else if (value < data(0)) {
      shiftElementsToAddNew(0, value);
    } else if (value > data(lastIndex)) {
      lastIndex = lastIndex + 1;
      data(lastIndex) = value;
    } else {

      val temp: (Boolean, Int) = contain(value);
      if (!temp._1) {
        shiftElementsToAddNew(temp._2, value);
      }
    }
  }

  /**
   * create new tempArray with 2*size of existent array
   * then copy all element from existent array to tempArray
   * and finally assign tempArray to existent array
   */
  def increaseSizeOf(): Unit = {
    var tempArray: Array[Int] = new Array[Int](data.length * 2);

    for (i <- 0 until data.length) {
      tempArray(i) = data(i);
    }
    data = tempArray;
  }

  /**
   * @param index
   * @param value
   *
   * This function start to shifting from lastIndex to @param index
   * Then assign @param value to data(index)
   * then increase lastIndex by 1
   */
  def shiftElementsToAddNew(index: Int, value: Int): Unit = {
    for (i <- lastIndex to index by -1) {
      data(i + 1) = data(i);
    }
    data(index) = value;
    lastIndex = lastIndex + 1;
  }

  /**
   * @param value Int
   * if value exist then return (true,-2)
   * else return (false,index) index: where should program set 'value'
   */
  def contain(value: Int): (Boolean, Int) = {
    val temp: Int = whereTo(value);
    if (temp == -2) {
      return (true, temp);
    } else if (temp >= 0) {
      if (data(temp) == value) {
        return (true, -2);
      } else if (temp >= 1 && data(temp - 1) == value) {
        return (true, -2);
      }
    }
    return (false, temp);
  }

  /**
   * @param value
   * This function basically search for 'value'
   * 	if it is exist than return -2
   *  	else return where to put 'value' in the array
   *
   * assign lastIndex to top
   * assign 0 to bottom
   * then start the loop until top bigger than bottom plus one
   * 	create middle variable with top and bottom values
   *  	if variable at middle index of data equal to value then return -2
   *    else if variable at middle index of data smaller than value then bottom equal to middle
   *    else top equal to middle
   *    when loop end return top
   */
  def whereTo(value: Int): Int = {
    var top: Int = lastIndex;
    var bottom: Int = 0;

    while (top > bottom + 1) {
      var middle: Int = ((top - bottom) / 2) + bottom;
      if (data(middle) == value) {
        return -2;
      } else if (data(middle) < value) {
        bottom = middle;
      } else {
        top = middle;
      }
    }
    top;
  }

  override def toString(): String = {
    var s: String = "";
    if (lastIndex == -1) {
      return "<<Empty Set>>"
    } else {
      for (i <- 0 to lastIndex) {
        s = s + data(i) + ",";
      }
      s.dropRight(1);
    }
  }

  object Set {
    def apply() = new Set();
  }
}