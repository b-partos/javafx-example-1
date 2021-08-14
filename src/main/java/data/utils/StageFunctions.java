package data.utils;

import javafx.collections.ObservableList;
import javafx.stage.Screen;

/**
 * A collection of potentially useful code bits encountered during reading.
 * The functions are not necessary useful. They serve as notes.
 */
public class StageFunctions {

    /**
     * Returns the list of available screens.
     * @return
     */
    public static ObservableList<Screen> getScreens() {
        return Screen.getScreens();
    }

    /**
     * Returns the reference to the primary screen.
     * @return
     */
    public static Screen getPrimaryScreen() {
        return Screen.getPrimary();
    }

    /**
     * Get screen DPI
     * @param screen
     * @return
     */
    public static double getScreenDPI(Screen screen) {
        return screen.getDpi();
    }

}
