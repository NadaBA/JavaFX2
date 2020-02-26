import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;


public class User_interface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

       //titel for stage
        primaryStage.setTitle("lav en knap");

        //billede

        //Ved MAC brug nedenstående syntaks:
        //FileInputStream input = new FileInputStream("/Users/Nada/Desktop/Sejged2.jpg"); //MAC OS

        FileInputStream input = new FileInputStream("C:\\Users\\Payam\\Desktop\\EKG1.jpg");

        Image i = new Image(input);

        //billede view
        ImageView iw = new ImageView(i);

        Button b = new Button("On",iw);
        Button b1 = new Button("Off");

        TilePane tilePane = new TilePane();

        Label l = new Label("Patient Monitoring System Offline");
        tilePane.getChildren().add(0,b);
        tilePane.getChildren().add(1,l);
        //aktions event
        Scene scene = new Scene(tilePane);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                /*
                FileChooser fileChooser = new FileChooser();
                //Set extension file
                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg");
                FileChooser.getExtensions().addAll();

                 */

                l.setText("Patient Monitoring System Online!");
                //l.setText("Patient Monitoring System Offline!");
            }
        };
        //når knappen er trykket
        b.setOnAction(event);





        primaryStage.setScene(scene);
        primaryStage.show();



    }






    /*
    public void start(Stage stage) throws Exception{
        String version = System.getProperty("javafx.version");
        Label nannasLabel = new Label("Hej fra Nanna");

        Label label = new Label("Hello form JavaFX");
        Pane stackPane = new FlowPane(label);
        stackPane.getChildren().add(nannasLabel);
        Scene scene = new Scene(stackPane, 640, 480);
        stage.setScene(scene);
        stage.show();
        System.out.println("Hey");
        System.out.println("hej");
        System.out.println("mada er sej");
        System.out.println("hejsa");
        System.out.println("Hej Nanna");
    } */

    public static void main(String[] args) {
        Application.launch(args);


    }


}
