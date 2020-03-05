/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10_concurrency_java;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Platform;

public class CarProblem extends Application {
  @Override 
  public void start(Stage primaryStage) {       
    CarPane car = new CarPane();
    
    
    Scene scene = new Scene(car, 600, 200);
    primaryStage.setTitle("CarProblem"); 
    primaryStage.setScene(scene); 
    primaryStage.show(); 
       
    scene.widthProperty().addListener(e -> car.setW(car.getWidth()));
    scene.heightProperty().addListener(e -> car.setH(car.getHeight()));
    
    car.setOnMousePressed(e -> car.suspend());
    car.setOnMouseReleased(e -> car.resume());
    
    car.requestFocus();
    car.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.UP) {
        car.faster();
      }
      else if (e.getCode() == KeyCode.DOWN) {
        car.slower();
      }
    });
  }

  
  public static void main(String[] args) {
    launch(args);
  }
} 

class CarPane extends Pane {
  private double w = 600;
  private double h = 200;
  private double baseX = 0;
  private double baseY = h;
  private Circle c1 = new Circle(baseX + 10 + 5, baseY - 10 + 5, 5);
  private Circle c2 = new Circle(baseX + 30 + 5, baseY - 10 + 5, 5);
    
  private Rectangle carBody = new Rectangle(baseX, baseY - 20, 50, 10);
  private Polygon carTop = new Polygon(baseX + 10, baseY - 20, 
            baseX + 20, baseY - 30, baseX + 30, baseY - 30, 
            baseX + 40, baseY - 20);   
  private int sleepTime = 50;
  
  private Thread thread = new Thread(() -> {
    try {
      while (true) {
        Platform.runLater(() -> move());
        Thread.sleep(sleepTime);
      }
    }
    catch (InterruptedException ex) {
    }
  });
      
  public CarPane() {
    carBody.setFill(Color.BLUE);
    carTop.setFill(Color.ORANGE);
    this.getChildren().addAll(c1, c2, carBody, carTop);
    
    thread.start();
  }
  
    
  public void setValues() {
    c1.setCenterX(baseX + 10 + 5);
    c1.setCenterY(baseY - 10 + 5);
    c2.setCenterX(baseX + 30 + 5);
    c2.setCenterY(baseY - 10 + 5);

    carBody.setX(baseX);
    carBody.setY(baseY - 20);
    
    carTop.getPoints().clear();
    carTop.getPoints().addAll(baseX + 10, baseY - 20, 
            baseX + 20, baseY - 30, baseX + 30, baseY - 30, 
            baseX + 40, baseY - 20);   
  }
  
  public void setW(double w) {
    this.w = w;
    setValues();
  }
  
  public void suspend() {
    thread.suspend();
  }
  
  public void resume() {
    thread.resume();
  }
  
  public void faster() {
    if (sleepTime > 1)
      sleepTime--;
  }
  
  public void slower() {
    sleepTime++;
  }
  
  public void move() {
    if (baseX > w)
      baseX = -20;
    else
      baseX += 1;
    
    setValues();
  }

  
  public void setH(double h) {
    this.h = h;
    baseY = h;
    setValues();
  }
}
