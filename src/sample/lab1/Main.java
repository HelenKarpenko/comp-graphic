package sample.lab1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab 1");
        Group root = new Group();
        Scene scene = new Scene(root, 400,240);

        //Flower Petals
        Polygon petals = new Polygon(50, 80, 140, 80, 170, 10, 210, 80, 310, 80, 230, 130, 260, 200, 180, 155, 110, 195, 125, 130);
        petals.setFill(Color.YELLOW);
        root.getChildren().add(petals);

        //Flower Stalk
        Line stalk = new Line(178, 155, 178, 230);
        stalk.setStroke(Color.YELLOW);
        stalk.setStrokeWidth(8);
        root.getChildren().add(stalk);

        //Flower Center
        Polygon flowerCenter = new Polygon(140, 80, 210, 80, 230, 130, 180, 155, 125, 130);
        flowerCenter.setFill(Color.rgb(0, 128, 255));
        root.getChildren().add(flowerCenter);

        scene.setFill(Color.RED);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}