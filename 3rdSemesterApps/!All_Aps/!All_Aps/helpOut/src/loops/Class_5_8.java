/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;
import java.util.Scanner;

public class Class_5_8 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the number of students: ");
        int numStudents = scan.nextInt();
        int count = 1;
        double highScore = 0;
        String winnerFirstName = "";
        String winnerLastName = "";
        
        do
        {
            System.out.println("Enter student's first and last name (separated by a space): ");
            String firstName = scan.next();
            String lastName = scan.next();
            System.out.println("Enter " + firstName + "'s score: ");
            double score = scan.nextDouble();
            count++;
            if (score > highScore) {
                highScore = score;
                winnerFirstName = firstName;
                winnerLastName = lastName; }
        }
        while (count <= numStudents);
        
        System.out.println("\nThe student with the highest score is " + winnerFirstName + " " + winnerLastName);
    }
}