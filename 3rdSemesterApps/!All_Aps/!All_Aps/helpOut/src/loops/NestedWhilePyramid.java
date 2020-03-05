package loops;


public class NestedWhilePyramid 
{
        public static void main(String[] args) 
    {
        int rowNum = 8;
        int i = 1;
        int x = rowNum;
        
        while (x >= 1)
        {
          int j = 1;
          
            //Print the spaces before each row
         while ( j <= x * 2) 
        {
            System.out.print("  ");
            j++;
        }  
         
         int k = 0; 
         
         //Pyramid left half
            while (k <= i - 1)
            { 
            System.out.printf("%4d", (int)Math.pow(2, k));
            k++; 
            }
        int m = i - 1;
        
            //Pyramid right half
            while (m >= 1)
            {                    
            System.out.printf("%4d", (int)Math.pow(2, m - 1));
            m--;
            }  
            System.out.println();
            i++; 
            x--;
        }
    }

    }

