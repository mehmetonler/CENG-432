/**
 * Created by Mehmet ONLER on 15.12.2014
 */

case class User(name: String, email: String, grade: Int);

trait UserManagerTrait {
  def add(name: String, email: String, grade: Int): Option[User];
  def getUser(email: String): Option[User];
  def getUserListForGrade(grade: Int): List[User];
  def getCertainGrades(gradeSelector: (Int) => Boolean): List[String];
}

object UserManager extends UserManagerTrait {
  val dataSet = collection.mutable.Set[User]();

  /**
   * @param name : String
   * @param email : String
   * @param grade : Int
   * @return Option [User]
   *
   * check if the given email exist or not
   * if not, add the tempUser to Set and return tempUser
   * create tempUser with given parameter
   * if exist then return None
   */
  def add(name: String, email: String, grade: Int): Option[User] = {
    if (!dataSet.exists(u => u.email == email)) {
      val tempUser = User(name, email, grade);
      dataSet += tempUser;
      Option(tempUser);
    } else {
      None;
    }
  }

  /**
   * @param email : String
   * @return Option [User]
   *
   * apply find function on Set if found given email return the User
   */
  def getUser(email: String): Option[User] = {
    dataSet.find(u => u.email == email);
  }

  /**
   * @param grade : Int
   * @return List [User]
   *
   * apply filter function on set, get the set with given grade
   * convert set to List with toList and return it
   */
  def getUserListForGrade(grade: Int): List[User] = {
    dataSet.filter(u => u.grade == grade).toList;
  }

  /**
   * @param gradeSelector :function => Boolean
   * @return List [String]
   *
   * apply filter with given function
   * apply map to the result to get name
   * convert the result to List with toList and return it
   */
  def getCertainGrades(gradeSelector: (Int) => Boolean): List[String] = {
    dataSet.filter(u => gradeSelector(u.grade)).map(u => u.name).toList;
  }
}