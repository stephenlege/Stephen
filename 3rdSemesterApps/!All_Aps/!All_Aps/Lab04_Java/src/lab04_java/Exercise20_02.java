/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04_java;

/**
 *
 * @author Greg
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Exercise20_02 extends Application {

    protected TextField textF = new TextField();
    protected TextArea tArea = new TextArea();
    protected LinkedList<Integer> list = new LinkedList<>();

    @Override
    public void start(Stage primaryStage) {

        Button btSort = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");

        HBox paneForTextField = new HBox(10);
        paneForTextField.getChildren().addAll(new Label("Enter some numbers: "), textF);
        paneForTextField.setAlignment(Pos.CENTER);

        HBox paneForButtons = new HBox(5);
        paneForButtons.getChildren().addAll(
                btSort, btShuffle, btReverse);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setSpacing(20);
        paneForButtons.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));

        tArea.setEditable(false);
        tArea.setWrapText(true);

        //tried to center the text here
        //tArea.setStyle("-fx-font-alignment: center");
        paneForTextField.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));;

        BorderPane pane = new BorderPane();
        pane.setTop(paneForTextField);
        pane.setCenter(tArea);
        //pane.getCenter().set
        pane.setBottom(paneForButtons);

        textF.setOnAction((ActionEvent e) -> {
            add();
        });

        btSort.setOnAction((ActionEvent e) -> {
            Collections.sort(list);
            displayText();
        });

        btShuffle.setOnAction((ActionEvent e) -> {
            Collections.shuffle(list);
            displayText();
        });

        btReverse.setOnAction((ActionEvent e) -> {
            Collections.sort(list, Collections.reverseOrder());
            displayText();
        });

        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Linked List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void add() throws NumberFormatException{
        Boolean bool = true;
        if (bool) {
            for (Integer e : list) {
                if (e == Integer.parseInt(textF.getText())) {
                    bool = false;
                    textF.setText("");
                }
            }
        }
        if (bool == true) {
            list.addLast(Integer.parseInt(textF.getText()));
            displayText();
        }
    }

    private void displayText() {
        String output = "";
        for (Integer e : list) {
            output += e + " ";
        }

        tArea.setText(output);
        textF.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
