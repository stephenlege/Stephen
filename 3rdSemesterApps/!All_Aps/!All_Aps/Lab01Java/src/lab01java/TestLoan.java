package lab01java;

import java.io.*;

public class TestLoan {

    public static void testLoan() throws IOException, ClassNotFoundException {
        try (
                ObjectOutputStream output = new ObjectOutputStream(
                        new FileOutputStream("Loan.dat"));) {
            output.writeObject(new Loan(1.2, 4, 10000));
            output.writeObject(new Loan(2.2, 5, 20000));
            output.writeObject(new Loan(3.2, 6, 30000));
            output.writeObject(new Loan(4.2, 7, 40000));
            output.writeObject(new Loan(5.2, 8, 50000));
        }
        try (
                ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(
                        new FileInputStream("loan.dat")));) {
            
            while(true){
                String loop = (String) input.readObject().toString();
                System.out.println(loop);
            }

        } catch (EOFException ex) {
            System.out.println("EOF occured as expected");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        testLoan();
    }

}
