/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author Aiden Janey
 */
public class PasswordGenerator extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        GridPane pane = new GridPane();
        Button genBtn = new Button("Generate");
        Label lengthLabel = new Label("Password Length: ");
        ComboBox combo = new ComboBox();
        Label charLabel = new Label("Special Characters: ");
        CheckBox cBox = new CheckBox();
        Label pswdLabel = new Label("Password: ");
        TextField pswdField = new TextField();
        CreatePass cPass = new CreatePass();

        pane.add(lengthLabel, 0, 0);
        pane.add(combo, 1, 0);
        pane.add(charLabel, 3, 0);
        pane.add(cBox, 4, 0);
        pane.add(pswdLabel, 2, 1);
        pane.add(pswdField, 2, 2);
        pane.add(genBtn, 2, 3);

        combo.getItems().addAll("Short", "Medium", "Long");
        combo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                cPass.passwdLength((String) combo.getValue());
            }
        });
        genBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(cBox.isSelected())
                    pswdField.setText(cPass.withSpecial());
                else
                    pswdField.setText(cPass.withoutSpecial());
            }
        });

        Scene scene = new Scene(pane, 500, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Password Generator - Aiden Janey");
        primaryStage.show();
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
