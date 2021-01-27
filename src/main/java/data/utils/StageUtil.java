package data.utils;

import data.ui.StageData;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.List;
import java.util.function.Consumer;

public class StageUtil {

    public static Stage createStage(StageData stageData) {
        Stage stage = new Stage();
        if ( null == stageData.getSceneSupplier()) {
            throw new IllegalStateException("SceneSupplier is null");
        }
        stage.setScene(stageData.getSceneSupplier().get());
        stage.setTitle(stageData.getTitle());
        return stage;
    }

    public static void closeStages(List<Stage> stageList) {
        stageList.forEach(Stage::close);
    }

//    public static EventHandler<? extends Event> createClosingEvent(List<Stage> stageList, Consumer<Stage> stageConsumer) {
//        return (e) -> stageList.forEach(stageConsumer);
//    }

    public static <T, E extends Event> EventHandler<E> createListConsumingEvent(List<T> list, Consumer<T> objectConsumer) {
        return (e) -> list.forEach(objectConsumer);
    }

}
