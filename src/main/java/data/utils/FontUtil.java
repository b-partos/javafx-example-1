package data.utils;

import javafx.scene.text.Font;

public class FontUtil {

    public static final String TEST_FONT_URL = "file:resources/fonts/latinmodern-math-1959/latinmodern-math.otf";

    public static Font loadFont(String url) {
        return Font.loadFont(url,120);
    }
}
