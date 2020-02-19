import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class User_interface extends Application {

    @Override
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
    }

    public static void main(String[] args) {
        Application.launch(args);


    }
}
