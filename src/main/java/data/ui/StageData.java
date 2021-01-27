package data.ui;

import javafx.scene.Group;
import javafx.scene.Scene;
import lombok.Builder;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
@Builder(toBuilder = true)
public class StageData {
    @Builder.Default
    private final Supplier<Scene> sceneSupplier = () -> new Scene(new Group());
    @Builder.Default
    private final String title = "<Scene title not set>";

}
