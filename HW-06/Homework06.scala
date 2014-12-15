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

  def add(name: String, email: String, grade: Int): Option[User] = {
    val tempUser = User(name, email, grade);
    if (dataSet.find((u:User) => u.email == tempUser.email).size == 0) {
    	dataSet += tempUser;    	 
    	Option(tempUser);
    	
    } else {
    	None;
    }
   
  }
  def getUser(email: String): Option[User] = {
    dataSet.find(u => u.email == email);
  }
  def getUserListForGrade(grade: Int): List[User] = {
    dataSet.filter(u => u.grade == grade).toList;
  }
  def getCertainGrades(gradeSelector: (Int) => Boolean): List[String] = {
    dataSet.filter(u => gradeSelector(u.grade)).map(u => u.name).toList;
  }
}