package data.utils;

import data.ui.ButtonData;
import javafx.scene.control.Button;

public class ButtonUtil {

    public static Button createButton(ButtonData buttonData) {
        Button btn = new Button();

        btn.setLayoutX(buttonData.getLayout().getX());
        btn.setLayoutY(buttonData.getLayout().getY());
        btn.setText(buttonData.getText());
        btn.setOnAction(buttonData.getOnAction());

        return btn;
    }

}
