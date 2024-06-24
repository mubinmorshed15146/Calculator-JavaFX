package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A launcher class for javafx in order to give a UI to the user.
 * This class was created for GuiView class in order to launch the view.
 *
 *
 * @author mubin
 *
 */
public class JavaFxLauncher extends Application {

  /**
   * Main method is required for javafx to provide to UI(User Interface).
   *
   * @param args the args passes the arguments in the class that JavaFx will accept
   */
  public static void main(String[] args) {
    launch(args);

  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root =  FXMLLoader.load(getClass().getClassLoader().getResource("guiview.fxml"));
    Scene scene = new Scene(root, 640, 480);
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }

}
