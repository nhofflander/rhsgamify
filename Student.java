/*Student.java
Mr Hofflander 9/10
This class is used to store student info imported from Infinite Campus .csv file
*/
import java.util.Scanner;

public class Student
{
 public static void main (String[] args)
 {
  
  //int grade = 9;
  int pgy = 0; //projected graduation year
  String fName = "Nathan";
  String lName = "Hofflander";

  //future edit is to add GUI that allows admin to set the current grad year
  int CGY = 2017;

  Scanner scan = new Scanner (System.in);

  System.out.println("Enter your grade: ");
  int grade = scan.nextInt();

  System.out.println("Enter student ID: ");
  int sid = scan.nextInt();

  System.out.println("Student ID: " + sid);
  System.out.println("First name: " + fName);
  System.out.println("Last name: " + lName);
  System.out.println("Grade level: " + grade + "\n");

  if (grade == 9)
   pgy = CGY + 3;
   
  else
   if (grade == 10)
    pgy = CGY + 2;
   else
    if (grade == 11)
     pgy = CGY + 1;
    else
     if (grade == 12)
      pgy = CGY;

  System.out.println("Graduation year: " + pgy);

  /*
  System.out.println("Grade level: " + grade);
  System.out.println("You will graduate in " + gradYear);
  System.out.println("Award status: " + awardStatus);
  */
 }
}
