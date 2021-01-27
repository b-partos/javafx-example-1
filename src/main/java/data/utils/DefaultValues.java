package data.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class DefaultValues {

    public static String getButtonDefaultText() {
        return "<Button text not set>";
    }

    public static EventHandler<ActionEvent> getDefaultActionEventHandler() {
        return (e) -> {};
    }

}
