import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class AnimatedBirthdayWish extends Application {

    @Override
    public void start(Stage primaryStage) {
        // *Load the AI-generated Background*
        Image backgroundImage = new Image("file:Your own pic");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(600);
        //

        // *Load Your Image*
        Image yourImage = new Image("file:/C:your own pic");
        ImageView imageView = new ImageView(yourImage);
        imageView.setFitHeight(400);
        imageView.setFitWidth(325);
        Text nameText = new Text("HAPPY BIRTHDAY DEAR \n Name");
        nameText.setFont(Font.font("time new roman", 50)); // Stylish font
        nameText.setStyle("-fx-font-weight: bold; -fx-fill: linear-gradient(to right, #ff7f50, #ff6347, #ff4500);");

        // Move the text below the image
        nameText.setTranslateY(500);

        // *Pane for Balloons*
        Pane balloonPane = new Pane();

        // *StackPane to organize layers*
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(backgroundView, imageView, balloonPane, nameText);

        // *Balloon Animation*
        createBalloons(balloonPane);

        // *Animate Text*
        animateText(nameText);

        // *Scene and Stage Setup*
        Scene scene = new Scene(stackPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Happy Birthday, Your Name!");
        primaryStage.show();
    }

    private void createBalloons(Pane pane) {
        Random random = new Random();
        for (int i = 0; i < 300; i++) {
            Circle balloon = new Circle(20);
            balloon.setFill(Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble()));
            balloon.setTranslateX(random.nextInt(800));
            balloon.setTranslateY(1200);

            pane.getChildren().add(balloon);

            TranslateTransition transition = new TranslateTransition(Duration.seconds(10 + random.nextInt(5)), balloon);
            transition.setToY(-100);
            transition.setOnFinished(e -> pane.getChildren().remove(balloon));
            transition.play();
        }
    }

    private void animateText(Text text) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(5), text);
        transition.setFromY(200);
        transition.setToY(100);
        transition.setAutoReverse(true);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}