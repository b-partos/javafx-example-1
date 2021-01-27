package data.ui;

import data.utils.DefaultValues;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder(toBuilder = true)
public class ButtonData implements NodeData {

    @Builder.Default
    Layout layout = Layout.builder().build();

    @Builder.Default
    String text = DefaultValues.getButtonDefaultText();

    @Builder.Default
    EventHandler<ActionEvent> onAction = DefaultValues.getDefaultActionEventHandler();

}
