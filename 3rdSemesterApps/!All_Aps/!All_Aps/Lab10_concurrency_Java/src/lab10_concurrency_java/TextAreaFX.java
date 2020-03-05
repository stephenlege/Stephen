package lab10_concurrency_java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;

public class TextAreaFX extends Application {

    protected TextArea textArea = new TextArea();
    String s="";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws InterruptedException{

        textArea.setPrefColumnCount(100);
        textArea.wrapTextProperty();

        // Create a button
        Button btShowTable = new Button("Show Threads");

        // Create a hbox
        HBox paneForControls = new HBox(10);
        paneForControls.setAlignment(Pos.CENTER);
        //paneForControls.getChildren().addAll(btShowTable);

        // Create a scrollPane
        ScrollPane scrollPane = new ScrollPane(textArea);

        // Create a pane
        BorderPane pane = new BorderPane();
        pane.setTop(paneForControls);
        pane.setCenter(textArea);
        print();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("TextArea"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void print() {
        //textArea.setText(" 1");
        // Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();

    }
    // The task for printing a specified character in specified times

    class PrintChar implements Runnable {

        private char charToPrint; // The character to print
        private int times; // The times to repeat
        //private int ms;

        /**
         * Construct a task with specified character and number of times to
         * print the character
         */
        public PrintChar(char c, int t) {
            charToPrint = c;
            times = t;
            //this.ms = ms;
        }

        @Override
        /**
         * Override the run() method to tell the system what the task to perform
         */
        public void run() {
            try {

                //System.out.print(charToPrint);
                textArea.setWrapText(true);
                textArea.appendText("\n");
                //textArea.appendText(charToPrint + "");
                //Thread.sleep(ms);
                Thread.sleep(1000);
                for (int i = 0; i < times; i++) {
                    //System.out.print(charToPrint);
                    textArea.appendText(charToPrint + "");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

// The task class for printing number from 1 to n for a given n
    class PrintNum implements Runnable {

        private int lastNum;

        /**
         * Construct a task for printing 1, 2, ... i
         */
        public PrintNum(int n) {
            lastNum = n;
        }

        @Override
        /**
         * Tell the thread how to run
         */
        public void run() {
            try {
//                Thread thread4 = new Thread(new PrintChar('c',200,300));
//        thread4.start();
                //System.out.print(" 1");
                textArea.appendText("\n");
                textArea.setWrapText(true);
                //textArea.appendText(" ");
                Thread.sleep(2000);
                for (int i = 2; i <= lastNum; i++) {
                    //System.out.print(" " + i);
                    textArea.appendText(" " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
