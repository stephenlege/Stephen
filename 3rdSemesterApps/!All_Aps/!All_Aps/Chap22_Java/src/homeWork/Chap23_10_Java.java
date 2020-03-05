package homeWork;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Greg
 */
public class Chap23_10_Java extends Application {

    private Heap<Integer> heap = new Heap<Integer>();
    private TextField tfKey = new TextField();
    private HeapView heapView = new HeapView();
    private Button btInsert = new Button("Insert");
    private Button btDelete = new Button("Remove Root");

    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        tfKey.setPrefColumnCount(2);
        hBox.getChildren().addAll(new Label("Enter key:"), tfKey, btInsert);
        hBox.setStyle("-fx-border-color: green");

        HBox hBox1 = new HBox(5);
        hBox1.getChildren().addAll(hBox, btDelete);
        hBox1.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(heapView);
        pane.setBottom(hBox1);

        Scene scene = new Scene(pane, 500, 300);
        primaryStage.setTitle("Exercise23_10");
        primaryStage.setScene(scene);
        primaryStage.show();

        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            heap.add(key);
            heapView.repaint();
            tfKey.requestFocus();
            
        });

        btDelete.setOnAction(e -> {
            heap.remove();
            heapView.repaint();
            tfKey.requestFocus();
        });
    }

    class Heap<E extends Comparable<E>> {

        java.util.ArrayList<E> list = new java.util.ArrayList<E>();

        public Heap() {
        }

        public Heap(E[] objects) {
            for (int i = 0; i < objects.length; i++) {
                add(objects[i]);
            }
        }

        public void add(E newObject) {
            list.add(newObject);
            int currentIndex = list.size() - 1;

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;
                if (list.get(currentIndex).compareTo(
                        list.get(parentIndex)) > 0) {
                    E temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex, temp);
                } else {
                    break;
                }
                currentIndex = parentIndex;
            }
        }

        public E remove() {
            if (list.size() == 0) {
                return null;
            }
            E removedObject = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int currentIndex = 0;
            while (currentIndex < list.size()) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                if (leftChildIndex >= list.size()) {
                    break;
                }
                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()) {
                    if (list.get(maxIndex).compareTo(
                            list.get(rightChildIndex)) < 0) {
                        maxIndex = rightChildIndex;
                    }
                }
                if (list.get(currentIndex).compareTo(
                        list.get(maxIndex)) < 0) {
                    E temp = list.get(maxIndex);
                    list.set(maxIndex, list.get(currentIndex));
                    list.set(currentIndex, temp);
                    currentIndex = maxIndex;
                } else {
                    break;
                }
            }

            return removedObject;
        }

        public double getSize() {
            return list.size();
        }
    }

    class HeapView extends Pane {

        private double radius = 20;
        private double verticalGap = 50;

        protected void repaint() {
            this.getChildren().clear();
            displayTree(0, getWidth() / 2, 30, getWidth() / 4);
        }

        private void displayTree(int index, double x, double y, double horizontalGap) {
            if (index < heap.getSize()) {

                Circle circle = new Circle(x, y, radius);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.GREEN);
                getChildren().add(circle);
                this.getChildren().add(new Text(x - 6, y + 4, heap.list.get(index) + ""));

                int indexOfLeft = 2 * index + 1;
                if (indexOfLeft < heap.getSize()) {
                    connectLeftChild(x - horizontalGap, y + verticalGap, x, y);
                }

                displayTree(indexOfLeft, x - horizontalGap, y + verticalGap, horizontalGap / 2);

                int indexOfRight = 2 * index + 2;
                if (indexOfRight < heap.getSize()) {
                    connectRightChild(x + horizontalGap, y + verticalGap, x, y);
                }
                displayTree(indexOfRight, x + horizontalGap, y + verticalGap, horizontalGap / 2);
            }
        }

        private void connectLeftChild(double x1, double y1, double x2, double y2) {
            double d = Math.sqrt(verticalGap * verticalGap + (x2 - x1) * (x2 - x1));
            double x11 = (int) (x1 + radius * (x2 - x1) / d);
            double y11 = (int) (y1 - radius * verticalGap / d);
            double x21 = (int) (x2 - radius * (x2 - x1) / d);
            double y21 = (int) (y2 + radius * verticalGap / d);
            getChildren().add(new Line(x11, y11, x21, y21));
        }

        private void connectRightChild(double x1, double y1, double x2, double y2) {
            double d = Math.sqrt(verticalGap * verticalGap + (x2 - x1) * (x2 - x1));
            double x11 = (int) (x1 - radius * (x1 - x2) / d);
            double y11 = (int) (y1 - radius * verticalGap / d);
            double x21 = (int) (x2 + radius * (x1 - x2) / d);
            double y21 = (int) (y2 + radius * verticalGap / d);
            getChildren().add(new Line(x11, y11, x21, y21));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
