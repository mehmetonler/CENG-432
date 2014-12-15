/**
 * Created by Mehmet ONLER on 15.12.2014
 */

object Test extends App {

  println("add  mhmt: " + UserManager.add("mhmt", "Hotmail", 45));
  println("add  ahmet: " + UserManager.add("ahmet", "asda", 35));
  println(UserManager.dataSet);
  println("add  burak: " + UserManager.add("burak", "outlook", 55));
  println(UserManager.dataSet);
  println("add  ahmet: " + UserManager.add("ahmet", "asda", 35));
  println("get  Hotmail user: " + UserManager.getUser("Hotmail"));
  println("get  gmail user: " + UserManager.getUser("gmail"));
  println(UserManager.dataSet);
  println("get grade=45 List: " + UserManager.getUserListForGrade(45));
  println("get grade smaller than 50 List: " + UserManager.getCertainGrades(g => g < 50));
  println("get grade smaller than 5 List: " + UserManager.getCertainGrades(g => g < 5));
  println(UserManager.dataSet);
}