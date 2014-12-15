/**
 * Created by Mehmet ONLER on 15.12.2014
 */

object Test extends App {

  println("add  mhmt: " + UserManager.add("mhmt", "Hotmail", 45));
  println("add  ahmet: " + UserManager.add("ahmet", "yandex", 35));
  println(UserManager.dataSet);
  println("add  burak: " + UserManager.add("burak", "outlook", 55));
  for (i <- 0 to 1000) {
    UserManager.add("burak"+i, "mail.ru" + i, 40+i);
  }

  println("add  kadir: " + UserManager.add("kadir", "yandex", 35));
  println("get user with Hotmail email: " + UserManager.getUser("Hotmail"));
  println("get user with gmail email: " + UserManager.getUser("gmail"));
  println("get user with mail.ru1 email: " + UserManager.getUser("mail.ru1"));
  println("get user with mail.ru980 email: " + UserManager.getUser("mail.ru980"));
  println("get user with mail.ru3000 email: " + UserManager.getUser("mail.ru3000"));
  println("get grade=45 List: " + UserManager.getUserListForGrade(45));
  println("get grade smaller than 50 List: " + UserManager.getCertainGrades(g => g < 50));
  println("get grade smaller than 5 List: " + UserManager.getCertainGrades(g => g < 5));

}