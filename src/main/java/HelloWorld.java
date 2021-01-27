import data.ui.ButtonData;
import data.ui.Layout;
import data.ui.StageData;
import data.utils.AssertUtil;
import data.utils.ButtonUtil;
import data.utils.StageUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class HelloWorld extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage primaryStage) {

        final List<Stage> stageList = new ArrayList<>();
        stageList.add(primaryStage);

        primaryStage.setTitle("Hello World");

        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);


        ButtonData buttonData = ButtonData.builder()
                .layout(Layout.builder().x(100.0).y(80.0).build())
                .text("Hello World")
                .onAction(event -> System.out.println("Hello World")).build();

        root.getChildren().add(ButtonUtil.createButton(buttonData));

        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        stageList.add(stage);
        stage.setTitle("New Window");
        stage.setScene(
                createScene(
                        Collections.singletonList(
                                () ->
                                        createButton(
                                                "Kill",
                                                StageUtil.createListConsumingEvent(
                                                        stageList,
                                                        Stage::close)
                                        )

                        )
                )
        );
        stage.show();
        StageData stageData = StageData.builder().title("Text input").build();
        AssertUtil.assertTrue(null != stageData.getSceneSupplier());

        StageData.builder().title("Text input").build();
        Stage textInputStage = StageUtil.createStage(stageData);
        stageList.add(textInputStage);

        textInputStage.show();

    }

    private Scene createScene(List<Supplier<Node>> nodeSuppliers) {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        nodeSuppliers.forEach(s -> root.getChildren().add(s.get()));
        return scene;
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
