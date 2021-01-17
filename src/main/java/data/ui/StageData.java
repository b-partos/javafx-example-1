package data.ui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Builder;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
@Builder
public class StageData {

    private final Supplier<Scene> sceneSupplier = () -> new Scene(new Group());
    private final String title;
    public Stage toStage() {
        Stage stage = new Stage();
        stage.setScene(sceneSupplier.get());
        stage.setTitle(title);
        return stage;
    }

}
