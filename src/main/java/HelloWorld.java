import data.ui.StageData;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class HelloWorld extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Hello World");

        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Hello World");
        btn.setOnAction(event -> System.out.println("Hello World"));

        root.getChildren().add(btn);

        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        stage.setTitle("New Window");
        stage.setScene(createScene(Collections.singletonList(() -> createButton("Kill",
                (e) -> {
                    stage.close();
                    primaryStage.close();
                }
        ))));
        stage.show();

        Stage textInputStage = StageData.builder().title("Text input").build().toStage();
        textInputStage.show();


    }

    private Scene createScene(List<Supplier<Node>> nodeSuppliers) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        nodeSuppliers.forEach(s -> root.getChildren().add(s.get()));
        return scene;
    }

    private Button createButton(String buttonText) {
        return createButton(buttonText, null);
    }

    private Button createButton(String buttonText, EventHandler<ActionEvent> value) {
        Button button = new Button();
        button.setLayoutX(100);
        button.setLayoutY(80);
        button.setText(buttonText);
        button.setOnAction(null != value ? value : event -> System.out.println(buttonText));
        return button;
    }

}
