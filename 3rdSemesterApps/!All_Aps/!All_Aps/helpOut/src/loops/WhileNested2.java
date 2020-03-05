/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ar114
 */
public class WhileNested2
{
    public static void main(String[] args)
    {
        int i = 0;
        while ( i < 3){
            System.out.print("(i, j) + ");
            for (int j = 0; j < 4; ++j)
                System.out.print("(" + i + ", " + j + ") ");
            System.out.println();
            
            ++i;
        }
    }
}
