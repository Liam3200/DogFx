package greene.ctis310;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * JavaFX App
 */
public class DogMain extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        VBox root = new VBox();
        Dog dog = new Dog();
        root.getChildren().add(new MainView(dog));
        scene = new Scene(root, 640, 220);
        stage.setScene(scene);
        stage.show();
    }

    // static void setRoot(String fxml) throws IOException {
    //     scene.setRoot(loadFXML(fxml));
    // }

    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    //     return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        launch();
    }

}