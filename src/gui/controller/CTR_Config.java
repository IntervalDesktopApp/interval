package gui.controller;

import handling.File_Handler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Eike on 21.06.2017.
 */
public class CTR_Config {

    @FXML
    public CheckBox check_update;
    @FXML
    public CheckBox check_multiClock;
    @FXML
    Label label_console;

    public static boolean doUpdate = true;
    public static boolean multiClock = false;
    private ArrayList<String> configList = new ArrayList<>();

    public CTR_Config() {

    }

    public void initialize() {
        check_update.setSelected(doUpdate);
        check_multiClock.setSelected(multiClock);
    }

    public void loadConfig() throws IOException {
        configList.clear();
        if(File_Handler.fileExist("ver/config.txt")) {
            configList = File_Handler.fileLoader("ver/config.txt");
            try {
                if (configList.get(0).equals("0")) {
                    doUpdate = false;
                }
                if (configList.get(1).equals("1")) {
                    multiClock = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Config.txt vermutlich fehlerhaft");
            }
        }
    }

    public void save() {
        doUpdate = check_update.isSelected();
        multiClock = check_multiClock.isSelected();

        configList.add(getBoolAsString(doUpdate));
        configList.add(getBoolAsString(multiClock));
        try {
            File_Handler.fileWriter("ver/config.txt", configList);
            label_console.setText("erfolgreich gespeichert");
        } catch (IOException e) {
            e.printStackTrace();
            label_console.setText("speichern fehlgeschlagen!");
        }
    }

    private String getBoolAsString(boolean bool) {
        if(bool) return "1";
        else return "0";
    }
}
