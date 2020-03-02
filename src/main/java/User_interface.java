import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Scanner;


public class User_interface extends Application {



        @Override
        public void start (Stage primaryStage) throws Exception {


            //titel for stage
            primaryStage.setTitle("Sluk / Tænd");

            //billede

            //Ved MAC brug nedenstående syntaks:
            //FileInputStream inputOn = new FileInputStream("/Users/Nada/Desktop/Sejged2.jpg"); //MAC OS

            FileInputStream inputOn = new FileInputStream("C:\\Users\\Payam\\Desktop\\UON.jpg");
            FileInputStream inputOff =  new FileInputStream("C:\\Users\\Payam\\Desktop\\UOFF.jpg");

            Image imageON = new Image(inputOn);
            Image imageOFF = new Image(inputOff);


            //billede view
            ImageView iw = new ImageView(imageON);
            ImageView ie = new ImageView(imageOFF);

            //KNAPPER
            Button bOn = new Button("", iw);
            Button bOff = new Button("", ie);
            Button bUpdateTemp = new Button("Opdater Temp");
            Button bUpdateBpm = new Button("Opdater BPM");

            bOn.setStyle("-fx-background-color: white");
            bOff.setStyle("-fx-background-color: white");

            //FORSKELLIGE PANES OPRETTELSE
            BorderPane borderPane = new BorderPane();
            AnchorPane anchorPane = new AnchorPane();
            GridPane gridPaneCenter = new GridPane();
            FlowPane flowPane = new FlowPane();
            GridPane gridPaneRight = new GridPane();
            GridPane gridPaneLeft = new GridPane();




            //LABELS
            Label systemOfflineLabel = new Label("Patient Monitoring System Offline");
            Label labelKlik = new Label("Klik på 'On' eller 'Off, for at tænde eller slukke");
            Label tempLabel = new Label("Patientens Temperatur: " + getTemp());
            Label bpmLabel = new Label("Patientens BPM: " + getBPM());
            TextField textField = new TextField("Skriv en kommentar:");
            textField.setPrefSize(300,400);

            //ANCHORPANE
/*
            HBox hb = new HBox();
            anchorPane.getChildren().addAll(bOn);
            anchorPane.getChildren().addAll(bOff);
            anchorPane.getChildren().addAll(hb);
            anchorPane.setMinSize(300,100);
            AnchorPane.setBottomAnchor(bOff,10.0);
            AnchorPane.setTopAnchor(bOn,10.0);
            anchorPane.setStyle("-fx-background-color: white");

 */
            //GRIDPANE VENSTRE
            gridPaneLeft.setPadding(new Insets(10,10,10,10));
            gridPaneLeft.setMinSize(300,300);
            gridPaneLeft.setVgap(5);
            gridPaneLeft.setHgap(5);

            gridPaneLeft.add(bOn,0,20);
            gridPaneLeft.add(bOff,0,21);
            gridPaneLeft.setStyle("-fx-background-color: white");





            //GRIDPANE HØJRE
            gridPaneRight.setPadding(new Insets(10,10,10,10));
            gridPaneRight.setMinSize(300,300);
            gridPaneRight.setVgap(5);
            gridPaneRight.setHgap(5);

            Text Navn = new Text("Navn:");
            gridPaneRight.add(Navn,0,0);

            TextField textNavn = new TextField();
            textNavn.setPrefColumnCount(10);
            gridPaneRight.add(textNavn,1,0);

            Text efterNavn = new Text("Efternavn:");
            gridPaneRight.add(efterNavn,0,1);

            TextField textEfterNavn = new TextField();
            textEfterNavn.setPrefColumnCount(10);
            gridPaneRight.add(textEfterNavn,1,1);

            Text Alder = new Text("Alder:");
            gridPaneRight.add(Alder,0,2);

            TextField textAlder = new TextField();
            textAlder.setPrefColumnCount(10);
            gridPaneRight.add(textAlder,1,2);

            gridPaneRight.add(textField,1,8);

            gridPaneRight.setStyle("-fx-background-color: lightblue");




            //GRIDPANE CENTER
            gridPaneCenter.setPadding(new Insets(10,10,10,10));
            gridPaneCenter.setMinSize(300,300);
            gridPaneCenter.setVgap(5);
            gridPaneCenter.setHgap(5);
            gridPaneCenter.add(systemOfflineLabel,0,0);
            gridPaneCenter.add(labelKlik,0,1);
            gridPaneCenter.add(tempLabel,0,10);
            gridPaneCenter.add(bUpdateTemp,3,10);
            gridPaneCenter.add(bpmLabel,0,20);
            gridPaneCenter.add(bUpdateBpm,3,20);
            gridPaneCenter.setStyle("-fx-background-color: white");




            //BORDERPANE
            borderPane.setLeft(gridPaneLeft);
            borderPane.setRight(gridPaneRight);
            borderPane.setCenter(gridPaneCenter);



            //Aktions event af scene og knapper under
            Scene sceneBorderPane = new Scene(borderPane);



            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {

                    systemOfflineLabel.setText("Patient Monitoring System Online!");

                }
            };
            //når knappen er trykket
            bOn.setOnAction(event);

            EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    systemOfflineLabel.setText("Patient Monitoring System Offline");
                }
            };
            bOff.setOnAction(event1);

                //EVENT AF TEMP MED KLIK PÅ KNAP
                EventHandler<ActionEvent> eventTemp = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        tempLabel.setText("Patientens Temperatur: " + getTemp());
                        if (getTemp() >= 39){
                            Label warningTempLabel = new Label("Patientens temperatur er over 39!!");
                            System.out.println("ALARM TEMP!");
                            gridPaneCenter.add(warningTempLabel,0,15);
                            warningTempLabel.setStyle("-fx-text-fill: red");
                        }
                    }
                };
                bUpdateTemp.setOnAction(eventTemp);

                //EVENT AF BPM MED KLIK AF KNAP
                EventHandler<ActionEvent> eventBPM = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        bpmLabel.setText("Patientens BPM: " + getBPM());
                        if (getBPM() >= 120){
                            Label warningBpmLabel = new Label("Patientens BPM er over 120!");
                            System.out.println("ALARM BPM");
                            gridPaneCenter.add(warningBpmLabel,0,25);
                            warningBpmLabel.setStyle("-fx-text-fill: red");

                        }
                    }
                };
                bUpdateBpm.setOnAction(eventBPM);


                primaryStage.setScene(sceneBorderPane);
                //primaryStage.setScene(scene1);
                primaryStage.show();
            }



        double getTemp() {

            while(true) {
                double value = Math.random() * 60 + 150;
                // tilfældigt tal, der ganges med 60 + 150 for at få en given værdi

                double temp = value * 4 / 50 + 24;
                // Given værdi fra ovenstående kode (math.random konverteres til grader celsius)
                temp = Math.round(temp * 100d / 100d);

                return temp;
            }
    }

    double getBPM(){

            while(true) {
                double alder = 25;
                double maxBPM = 220 - alder;
                double targetHrRandom = Math.random() * maxBPM;
                double targetHrMin = 0.45 * maxBPM;
                //System.out.println(targetHrMin);
                double targetHR = (targetHrRandom + targetHrMin) / 2;
                targetHR = Math.round(targetHR);
                //System.out.println(targetHR);

                return targetHR;
            }
    }



    public static void main(String[] args) {
        Application.launch(args);

    }

}
