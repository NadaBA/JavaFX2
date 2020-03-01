import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.io.FileInputStream;


public class User_interface extends Application {



        @Override
        public void start (Stage primaryStage) throws Exception {


            //titel for stage
            primaryStage.setTitle("Sluk / Tænd");

            //billede

            //Ved MAC brug nedenstående syntaks:
            //FileInputStream input = new FileInputStream("/Users/Nada/Desktop/Sejged2.jpg"); //MAC OS

            FileInputStream input = new FileInputStream("C:\\Users\\Payam\\Desktop\\ON.png");

            Image image = new Image(input);


            //billede view
            ImageView iw = new ImageView(image);
            ImageView ie = new ImageView(image);

            Button bOn = new Button("On", iw);
            Button bOff = new Button("Off", ie);
            Button bUpdateTemp = new Button("Update Temp");

            bOn.setStyle("-fx-background-color: green");
            bOff.setStyle("-fx-background-color: red");


            TilePane tilePane = new TilePane();


            Label systemOfflineLabel = new Label("Patient Monitoring System Offline");
            Label labelKlik = new Label("Klik på 'On' eller 'Off, for at tænde eller slukke");
            Label labelIntet = new Label("IT Projekt 1, 2. Semester");
            Label tempLabel = new Label("Patientens Temperatur: " + getValue());
            TextField textField = new TextField("Skriv en kommentar:");
            tilePane.getChildren().add(0, bOn);
            tilePane.getChildren().add(1, bOff);
            tilePane.getChildren().add(2, systemOfflineLabel);
            tilePane.getChildren().add(3, labelKlik);
            tilePane.getChildren().add(4,labelIntet);
            tilePane.getChildren().add(5, textField);
            tilePane.getChildren().add(6, tempLabel);
            tilePane.getChildren().add(7, bUpdateTemp);
            tilePane.setStyle("-fx-background-color: lightblue");







            //aktions event
            Scene scene = new Scene(tilePane);


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
                    systemOfflineLabel.setText("Patient Monitoring System.........Offline....");
                }
            };
            bOff.setOnAction(event1);


                EventHandler<ActionEvent> eventTemp = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        tempLabel.setText("Patientens Temperatur: " + getValue());
                        if (getValue() >= 39){
                            Label warningLabel = new Label("Patientens temperatur er over 39!!");
                            System.out.println("gør noget!");
                            tilePane.getChildren().add(8,warningLabel);
                            warningLabel.setStyle("-fx-text-fill: red");
                        }
                    }
                };
                bUpdateTemp.setOnAction(eventTemp);

                primaryStage.setScene(scene);
                //primaryStage.setScene(scene1);
                primaryStage.show();
            }



        double getValue () {

            while(true) {
                double value = Math.random() * 60 + 150;
                // tilfældigt tal, der ganges med 60 + 150 for at få en given værdi

                double temp = value * 4 / 50 + 24;
                // Given værdi fra ovenstående kode (math.random konverteres til grader celsius)
                temp = Math.round(temp * 100d / 100d);

                return temp;
            }
    }





    public static void main(String[] args) {
        Application.launch(args);

    }

}
