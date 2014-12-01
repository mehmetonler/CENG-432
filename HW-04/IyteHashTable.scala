/*
 * Created by Mehmet ONLER on 01.12.2014
 */
class IyteHashTable(val s: Int) {
  private var capacity: Int = s; // define capacity of array, if it's not specify, it's 64000 as a default value; 
  private var count: Int = 0; // count is always start as 0,
  private var hashTable = Array.ofDim[String](capacity, 2);
  private val loadFactor: Double = 0.75; // this value 0.75, if 75% of our table full than we should increase size of our table

  def this() {
    this(64000);
  }

  /**
   * this function get new key and value and try to add hashTable
   *
   * @param key : new key
   * @param value : new value
   *
   * firstly, check if hashTable reach its capacity, if so increase capacity => newCapacity = 2*oldCapacity
   * Then, create hashCode for key by calling hashCode function
   * Then, enter the while loop, until find a empty cell or the cell which have same key
   * if it found the cell which have same key, then change the value and return back
   * if it find next empty cell then put the key and value to there, increase count
   */
  def set(key: String, value: String): Unit = {

    // double table size if count reach to loadFactor
    if (count >= capacity * loadFactor) {
      resize(2 * capacity);
    }

    // get new hashValue
    var newHashValue = hashCode(key);
    //start looking for empty cell or the cell with same key
    while (hashTable(newHashValue)(0) != null) {
      if (hashTable(newHashValue)(0) == key) {
        hashTable(newHashValue)(1) = value;
        return ;
      }
      newHashValue = (newHashValue + 1) % capacity;
    }

    // There is no cell with this key 
    // put 'key' and 'value' to empty cell 
    hashTable(newHashValue)(0) = key;
    hashTable(newHashValue)(1) = value;
    // increase count by 1
    count = count + 1;

  }

  /**
   * This function search given key value if it found return value, if not return null
   * @param key :String
   *
   * firstly create new hashvalue for given key
   * then, start to check each cell from calculated hashvalue index to a null cell
   * if it found the cell return the value
   * if not return null
   */
  def get(key: String): String = {
    // create hashValue for given key
    var hashValue: Int = hashCode(key);
    while (hashTable(hashValue)(0) != null) {
      if (hashTable(hashValue)(0) == key) {
        // if keys are equal return the value cell
        return hashTable(hashValue)(1);
      }
      hashValue = (hashValue + 1) % capacity;
    }

    // There is no element with this key
    null;
  }

  /**
   * This is my hashCode function. It calculate hashValue for given key
   * @param key : String
   *
   * create hashValue = 0
   * then start to make this calculation for each character of given key ==>>> hashValue = hashValue * 31 + key(i)
   * then check if hashValue smaller than 0, multiply it by -1
   * return (hashValue mod capacity)
   */
  def hashCode(key: String): Int = {
    var hashValue: Int = 0;
    key.foreach((c: Char) => hashValue = hashValue * 31 + c.toInt);
    if (hashValue < 0) {
      hashValue = -1 * hashValue;
    }
    return hashValue % capacity;
  }

  /**
   * this function increase capacity of hashTable by given parameter
   * @param newCapacity : Integer
   *
   * firstly, create temporary IyteHashTable with given parameter --newCapacity--
   * then set all hashTable element's too this temporary object
   * then get hashTable which have new capacity and equalize to this.hashTable
   * and change the capacity value with newCapacity
   */
  def resize(newCapacity: Int): Unit = {
    // create new  temp iytehashtable
    val tempHT: IyteHashTable = new IyteHashTable(newCapacity); ;

    // set all element to new hashTable 
    for (i <- 0 until capacity) {
      if (hashTable(i)(0) != null) {
        tempHT.set(hashTable(i)(0), hashTable(i)(1));
      }
    }

    // get new hashTable and equalize to our hashTable
    hashTable = tempHT.getHashTable();
    // change the capacity with newCapacity
    capacity = newCapacity;
  }

  def isEmpty(): Boolean = {
    count == 0;
  }

  def getSize(): Int = {
    count;
  }
  def getCapacity(): Int = {
    capacity;
  }
  def getHashTable(): Array[Array[String]] = {
    hashTable;
  }
}
object IyteHashTable {
  def apply() = new IyteHashTable();
}