import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.io.FileInputStream;


public class User_interface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //titel for stage
        primaryStage.setTitle("Sluk / Tænd");

        //billede

        //Ved MAC brug nedenstående syntaks:
        //FileInputStream input = new FileInputStream("/Users/Nada/Desktop/Sejged2.jpg"); //MAC OS

        FileInputStream input = new FileInputStream("C:\\Users\\Payam\\Desktop\\ON.png");

        Image i = new Image(input);

        //billede view
        ImageView iw = new ImageView(i);
        ImageView ie = new ImageView(i);

        Button b = new Button("On", iw);
        Button b1 = new Button("Off",ie);

        b.setStyle("-fx-background-color: green");
        b1.setStyle("-fx-background-color: red");


        TilePane tilePane = new TilePane();
        //FlowPane flowPane = new FlowPane();


        Label l = new Label("Patient Monitoring System Offline");
        Label l2 = new Label("Klik på 'On' eller 'Off, for at tænde eller slukke");
      //  Label l3 = new Label("For at tænde eller slukke");
        TextField textField = new TextField("Skriv noger her:");
       // textField.setPrefColumnCount(5);
        //Label l1 = new Label("Patient Monitoring System Online");
        tilePane.getChildren().add(0, b);
        tilePane.getChildren().add(1, b1);
        tilePane.getChildren().add(2,l);
        tilePane.getChildren().add(3,l2);
      //  tilePane.getChildren().add(4,l3);
        tilePane.getChildren().add(4,textField);
        tilePane.setStyle("-fx-background-color: lightblue");


        //tilePane.getChildren().add(3,l1);
        //aktions event
        Scene scene = new Scene(tilePane);
        //Scene scene1 = new Scene(flowPane);



        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                l.setText("Patient Monitoring System Online!");
                //l.setText("Patient Monitoring System Offline!");
            }
        };
        //når knappen er trykket
        b.setOnAction(event);

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setText("Patient Monitoring System.........Offline....");
            }
        };
        b1.setOnAction(event1);






        primaryStage.setScene(scene);
        //primaryStage.setScene(scene1);
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
