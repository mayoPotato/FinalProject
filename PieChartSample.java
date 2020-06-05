/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testingmaven;

/**
 *
 * @author mhenry
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import javafx.scene.control.*;
import java.util.Optional;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
//TODO
//import user txt file instead of beowulf
//use user input in PieChart
public class PieChartSample extends Application {

    // hideous global variables?! SIN
    private static TextField textField0;
    private static TextField textField1;
    private static TextField textField2;
    private static TextField textField3;
    private static TextField textField4;
    private static TextField textField5;
    private static TextField textField6;
    private static TextField textField7;
    private static TextField textField8;
    private static TextField textField9;

    public void startx(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Important Words");
        stage.setWidth(500);
        stage.setHeight(500);
        
        //take out to different method -->
        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        //TODO
                        //question 1
                        //find out how to implement textfield into pie chart
                        //question 2
                        //why does it loop
                        new PieChart.Data("word1", 1),
                        new PieChart.Data("word2", 2),
                        new PieChart.Data("word3", 3),
                        new PieChart.Data("word4", 4),
                        new PieChart.Data("word5", 5),
                        new PieChart.Data("word6", 6),
                        new PieChart.Data("word7", 7),
                        new PieChart.Data("word8", 8),
                        new PieChart.Data("word9", 9),
                        new PieChart.Data("word10", 10));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Important Words");
        //<--

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        dialog();
        stage.show();

    }

    @Override
    public void start(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Alert Functions");
        //here we have 10 rows with 2 columns
        //Column one is 
        textField0 = new TextField("Your word here");
        textField1 = new TextField("Your word here");
        textField2 = new TextField("Your word here");
        textField3 = new TextField("Your word here");
        textField4 = new TextField("Your word here");
        textField5 = new TextField("Your word here");
        textField6 = new TextField("Your word here");
        textField7 = new TextField("Your word here");
        textField8 = new TextField("Your word here");
        textField9 = new TextField("Your word here");
        GridPane grid = new GridPane();
        grid.addRow(0, new Label("Word one here"), textField0);
        grid.addRow(1, new Label("Word one here"), textField1);
        grid.addRow(2, new Label("Word one here"), textField2);
        grid.addRow(3, new Label("Word one here"), textField3);
        grid.addRow(4, new Label("Word one here"), textField4);
        grid.addRow(5, new Label("Word one here"), textField5);
        grid.addRow(6, new Label("Word one here"), textField6);
        grid.addRow(7, new Label("Word one here"), textField7);
        grid.addRow(8, new Label("Word one here"), textField8);
        grid.addRow(9, new Label("Word one here"), textField9);

        grid.setHgap(30);
        ColumnConstraints right = new ColumnConstraints();
        right.setHalignment(HPos.RIGHT);
        grid.getColumnConstraints().setAll(new ColumnConstraints(), right);

        //dialog boxes
        alert.getDialogPane().setContent(grid);
        
        //initial alert
        Button openButton = new Button("Show Text Input");
        openButton.setOnAction(event -> {
            alert.showAndWait();
            //TODO 
            //here i need to collect inputs from alert box
            //then create pie chart
            //layout.getChildren add chart here
            
                       
            
        });
        
        
        HBox layout = new HBox(10);
        layout.getChildren().addAll(
                openButton
        );
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout));
        stage.show();

        alert.initOwner(stage);
        alert.initModality(Modality.WINDOW_MODAL);
    }

    //i'm actually pretty sure this isn't even happening
    private static void dialog() {

//Dialog box
        TextInputDialog dialog = new TextInputDialog("Your word here");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter the words you want to see");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Your name: " + result.get());
        }

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("Your word: " + name));
    }

    InputStream openFile(String fileName) {
        File f = new File(fileName);
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
        }
        return is;
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("done shitsticks");
        System.out.println("Field 0: " + textField0.getText());
        System.out.println("Field 1: " + textField1.getText());
    }
}
