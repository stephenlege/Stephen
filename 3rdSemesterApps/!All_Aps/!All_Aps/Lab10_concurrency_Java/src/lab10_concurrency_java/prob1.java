/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10_concurrency_java;



import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class prob1 extends Application {
    String s = "";
    @Override
    public void start(Stage primaryStage) {

        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);
        
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        thread1.start();
        thread2.start();
        thread3.start();
        
        TextArea text = new TextArea();
        text.setWrapText(true);
        text.setPrefColumnCount(100);
        text.appendText(s);
         // Create a scrollPane
        ScrollPane scrollPane = new ScrollPane(text);

        // Create a pane
        BorderPane pane = new BorderPane();
       
        pane.setCenter(text);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Text Area");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    class PrintChar implements Runnable {

        private char charToPrint;
        private int times;

        public PrintChar(char c, int t) {
            charToPrint = c;
            times = t;
        }

        @Override
        public void run() {
            
            for (int i = 0; i < times; i++) {
                s += " " + charToPrint;
            }
            //s+="\n";
        }
    }

    class PrintNum implements Runnable {

        private int lastNum;

        public PrintNum(int n) {
            lastNum = n;
        }

        @Override
        public void run() {
          
            for (int i = 1; i <= lastNum; i++) {
                s += " " + i;
            }
        }


    }
}
