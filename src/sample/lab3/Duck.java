package sample.lab3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;

public class Duck extends Application {

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 1400, 600);

        // Print Duck

        // body
        Path body = new Path();
        MoveTo body_moveTo = new MoveTo();
        body_moveTo.setX(300);
        body_moveTo.setY(400);

        QuadCurveTo body_bottom = new QuadCurveTo();
        body_bottom.setX(450);
        body_bottom.setY(400);
        body_bottom.setControlX(375);
        body_bottom.setControlY(420);

        QuadCurveTo body_right = new QuadCurveTo();
        body_right.setX(450);
        body_right.setY(300);
        body_right.setControlX(500);
        body_right.setControlY(350);

        QuadCurveTo body_top = new QuadCurveTo();
        body_top.setX(320);
        body_top.setY(290);
        body_top.setControlX(350);
        body_top.setControlY(320);

        QuadCurveTo body_tail = new QuadCurveTo();
        body_tail.setX(290);
        body_tail.setY(300);
        body_tail.setControlX(295);
        body_tail.setControlY(250);

        QuadCurveTo body_left = new QuadCurveTo();
        body_left.setX(300);
        body_left.setY(400);
        body_left.setControlX(260);
        body_left.setControlY(350);

        body.getElements().add(body_moveTo);
        body.getElements().add(body_bottom);
        body.getElements().add(body_right);
        body.getElements().add(body_top);
        body.getElements().add(body_tail);
        body.getElements().add(body_left);
        body.setFill(Color.YELLOW);

        // head
        Ellipse head = new Ellipse();
        head.setCenterX(400);
        head.setCenterY(260);
        head.setRadiusX(60);
        head.setRadiusY(55);

        head.setFill(Color.YELLOW);
        head.setStroke(Color.BLACK);

        // Eye
        Ellipse eye = new Ellipse();
        eye.setCenterX(410);
        eye.setCenterY(245);
        eye.setRadiusX(7);
        eye.setRadiusY(10);

        eye.setRotate(-15);
        eye.setFill(Color.BLACK);

        Ellipse eye_white = new Ellipse();
        eye_white.setCenterX(412);
        eye_white.setCenterY(242);
        eye_white.setRadiusX(3);
        eye_white.setRadiusY(5);

        eye_white.setRotate(-15);
        eye_white.setFill(Color.WHITE);

        // wing
        Path wing = new Path();
        MoveTo wing_moveTo = new MoveTo();
        wing_moveTo.setX(300);
        wing_moveTo.setY(370);

        QuadCurveTo wing_bottom = new QuadCurveTo();
        wing_bottom.setX(370);
        wing_bottom.setY(390);
        wing_bottom.setControlX(335);
        wing_bottom.setControlY(410);

        QuadCurveTo wing_right = new QuadCurveTo();
        wing_right.setX(360);
        wing_right.setY(345);
        wing_right.setControlX(380);
        wing_right.setControlY(368);

        QuadCurveTo wing_top = new QuadCurveTo();
        wing_top.setX(300);
        wing_top.setY(335);
        wing_top.setControlX(320);
        wing_top.setControlY(350);

        QuadCurveTo wing_feather1 = new QuadCurveTo();
        wing_feather1.setX(310);
        wing_feather1.setY(350);
        wing_feather1.setControlX(290);
        wing_feather1.setControlY(340);

        QuadCurveTo wing_feather2 = new QuadCurveTo();
        wing_feather2.setX(310);
        wing_feather2.setY(360);
        wing_feather2.setControlX(285);
        wing_feather2.setControlY(340);

        QuadCurveTo wing_feather3 = new QuadCurveTo();
        wing_feather3.setX(300);
        wing_feather3.setY(370);
        wing_feather3.setControlX(290);
        wing_feather3.setControlY(350);

        wing.getElements().add(wing_moveTo);
        wing.getElements().add(wing_bottom);
        wing.getElements().add(wing_right);
        wing.getElements().add(wing_top);
        wing.getElements().add(wing_feather1);
        wing.getElements().add(wing_feather2);
        wing.getElements().add(wing_feather3);
        wing.setFill(Color.YELLOW);

        // beak
        Path beak = new Path();
        MoveTo beak_moveTo = new MoveTo();
        beak_moveTo.setX(410);
        beak_moveTo.setY(280);

        QuadCurveTo beak_left = new QuadCurveTo();
        beak_left.setX(450);
        beak_left.setY(240);
        beak_left.setControlX(435);
        beak_left.setControlY(270);

        QuadCurveTo beak_top = new QuadCurveTo();
        beak_top.setX(480);
        beak_top.setY(240);
        beak_top.setControlX(465);
        beak_top.setControlY(245);

        QuadCurveTo beak_right = new QuadCurveTo();
        beak_right.setX(450);
        beak_right.setY(270);
        beak_right.setControlX(490);
        beak_right.setControlY(260);

        QuadCurveTo beak_right1 = new QuadCurveTo();
        beak_right1.setX(470);
        beak_right1.setY(280);
        beak_right1.setControlX(465);
        beak_right1.setControlY(285);

        QuadCurveTo beak_bottom = new QuadCurveTo();
        beak_bottom.setX(410);
        beak_bottom.setY(280);
        beak_bottom.setControlX(450);
        beak_bottom.setControlY(300);

        beak.getElements().add(beak_moveTo);
        beak.getElements().add(beak_left);
        beak.getElements().add(beak_top);
        beak.getElements().add(beak_right);
        beak.getElements().add(beak_right1);
        beak.getElements().add(beak_bottom);
        beak.setFill(Color.ORANGE);

        // open beak
        Path openBeak = new Path();
        MoveTo openBeak_moveTo = new MoveTo();
        openBeak_moveTo.setX(430);
        openBeak_moveTo.setY(275);

        QuadCurveTo openBeak_left = new QuadCurveTo();
        openBeak_left.setX(470);
        openBeak_left.setY(262);
        openBeak_left.setControlX(455);
        openBeak_left.setControlY(270);

        QuadCurveTo openBeak_right = new QuadCurveTo();
        openBeak_right.setX(470);
        openBeak_right.setY(280);
        openBeak_right.setControlX(475);
        openBeak_right.setControlY(260);

        QuadCurveTo openBeak_bottom = new QuadCurveTo();
        openBeak_bottom.setX(430);
        openBeak_bottom.setY(275);
        openBeak_bottom.setControlX(440);
        openBeak_bottom.setControlY(280);

        openBeak.getElements().add(openBeak_moveTo);
        openBeak.getElements().add(openBeak_left);
        openBeak.getElements().add(openBeak_right);
        openBeak.getElements().add(openBeak_bottom);
        openBeak.setFill(Color.RED);

        // nose
        Path nose = new Path();
        MoveTo nose_moveTo = new MoveTo();
        nose_moveTo.setX(450);
        nose_moveTo.setY(265);

        QuadCurveTo nose_arc = new QuadCurveTo();
        nose_arc.setX(480);
        nose_arc.setY(240);
        nose_arc.setControlX(475);
        nose_arc.setControlY(230);

        nose.getElements().add(nose_moveTo);
        nose.getElements().add(nose_arc);
        nose.setFill(Color.ORANGE);

        root.getChildren().add(head);
        root.getChildren().add(eye);
        root.getChildren().add(eye_white);
        root.getChildren().add(beak);
        root.getChildren().add(openBeak);
        root.getChildren().add(nose);
        root.getChildren().add(body);
        root.getChildren().add(wing);

        // Animation
        int cycleCount = 2;
        int time = 4000;

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(time), root);
        translateTransition.setFromX(50);
        translateTransition.setToX(750);
        translateTransition.setCycleCount(cycleCount+2);
        translateTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(time), root);
        rotateTransition.setByAngle(180);
        rotateTransition.setCycleCount(cycleCount);
        rotateTransition.setAutoReverse(true);

        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(time), root);
        scaleTransition2.setToX(0.5);
        scaleTransition2.setToY(0.5);
        scaleTransition2.setCycleCount(cycleCount);
        scaleTransition2.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                translateTransition,
                rotateTransition,
                scaleTransition2
        );

        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();

        primaryStage.setTitle("Lab3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
