/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ar114
 */
public class WhileNested3
{
    public static void main(String[] args)
    {
        int i = 0;
        int j = 0;
        
        while (i < 3)
        {
          j = 0;
           System.out.print("(i,j) = ");
            
            while (j < 4)
                    {
                        System.out.print("(" + i + ", " + j + ") ");
                    ++j;
                    
                    }
            System.out.println();
             ++i;
            
        }
    }
}
