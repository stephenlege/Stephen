
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lauren
 */
public class Palindrome2 
{
        public static void main(String[] args) 
    {
        //Create a Scanner
        Scanner input = new Scanner(System.in);
        
        //Prompt the user to enter a string
        System.out.println("Please enter a string: ");
        String s = input.nextLine();
        
        //Get the index of the first character in the string
       
        
        //Get the index of the last charcter in the string
        
        
        boolean isPalindrome = true;
        
        for (int low = 0, high = s.length() - 1; low < high; low++, high--)
        {
            if (s.charAt(low) != s.charAt(high))
            {
                isPalindrome = false;
                break;
            }

        }
        if (isPalindrome)
        {
            System.out.println(s + " is a palindrome.");
        }
        else
            System.out.println(s+ " is not a palindrome.");
    }
}
