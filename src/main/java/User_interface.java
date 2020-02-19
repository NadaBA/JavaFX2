import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




public class User_interface extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        String version = System.getProperty("javafx.version");

        Label label = new Label("Hello form JavaFX");
        StackPane stackPane = new StackPane(label);
        Scene scene = new Scene(stackPane, 640, 480);
        stage.setScene(scene);
        stage.show();

    }
}
