/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lauren
 */
public class TestBreak1 
{
    public static void main(String[] args) 
    {
        int sum = 0;
        int number = 0;
        
        while (number < 20)
        {
            if (sum >= 100)
            {
                break;
            }
            
            sum += number;number++;
        }
        System.out.println("The number is " + number);
        System.out.println("The sum is " + sum);
    }
}
