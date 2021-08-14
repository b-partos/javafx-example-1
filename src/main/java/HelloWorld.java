import data.ui.ButtonData;
import data.ui.Layout;
import data.ui.StageData;
import data.utils.AssertUtil;
import data.utils.ButtonUtil;
import data.utils.FontUtil;
import data.utils.StageUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HelloWorld extends Application {

    private static char INTEGRAL_SIGN = '\u222B';

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static void testFont() {
        Font font = FontUtil.loadFont(FontUtil.TEST_FONT_URL);
        final Font fontItalic = Font.font(font.getFamily(), FontWeight.NORMAL, FontPosture.ITALIC, 120);
        List<String> textStrings = Arrays.asList(
                ""+INTEGRAL_SIGN,
                "\u2202",
                "a",
                "b"
        );



        Stage stage = StageUtil.createStage(StageData.builder()
                .title("Text test")
                .sceneSupplier(() -> {


                    final Text textLarge = new Text("\u222B");
                    textLarge.setScaleY(1.2);
                    textLarge.setFont(fontItalic);



                    List<Text> texts = textStrings.stream().map(Text::new).collect(Collectors.toList());
                    texts.add(1, textLarge);
                    texts.forEach(text -> text.setFont(fontItalic));

                    HBox textContainer = new HBox(texts.toArray(new Text[texts.size()]));
                    Scene scene = new Scene(textContainer);

//                    texts.forEach(t -> System.out.println(t.getBoundsInParent().getHeight()));

                    return scene;
                })
                .build());


        stage.show();

    }

    public void start(Stage primaryStage) {
//        Font.getFamilies().forEach(System.out::println);
        testFont();

//        createWindows(primaryStage);

    }

    private void createWindows(Stage primaryStage) {
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
