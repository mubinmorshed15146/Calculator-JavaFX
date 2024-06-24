package uk.ac.rhul.cs2800;

import java.util.function.Consumer;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;


/**
 * This class was inspired from MVCseparated,the author was @dave and it was done by his permission.
 * This is a view class that was created for GUI view that was implemented from the view interface  
 *
 * @author mubin
 *
 */
public class GuiView implements ViewInterface {
  private String expression;
  private String answer;

  
  /**
   * A hook to allow to displayed the evaluated answer.
   *
   * @param str str is the string where the answer will be stored and this will be displayed.
   */
  @Override
  public void setAnswer(String str) {
    answrBox.setText(str);

  }

  /**
   * A hook to expose the the expression to another class.
   *
   * @return the text that was retrived from the gui view
   */
  @Override
  public String getExpression() {
    
    return questionField.getText();
  }

  /**
   * Allows to change the calculation methods.
   *
   * @param f is to notify  
   */
  @Override
  public void addCalcObserver(Runnable f) {
    calculate.setOnAction(new EventHandler<ActionEvent>() {
      
      @Override
      public void handle(ActionEvent event) {
        f.notify();
        
      }
    });

  }
  
  /**
   * Allows to change the calculation methods.
   *
   * @param l is to notify  
   */

  @Override
  public void addTypeObserver(Consumer<OpType> l) {
    calcl.selectedToggleProperty().addListener((InvalidationListener) new ChangeListener<Toggle>() {

      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle from, Toggle to) {
        l.accept(to == inFixButton ? OpType.INFIX : OpType.POSTFIX);
        
      } 
      });
  }


  /**
   * A text field that is used to display the answers.
   */
  @FXML // fx:id="answrBox"
  private TextField answrBox; // Value injected by FXMLLoader

  /**
   * The object that connect the radio buttons.
   */
  @FXML // fx:id="calcl"
  private ToggleGroup calcl; // Value injected by FXMLLoader

  /**
   * A button that will be used for calculation.
   */
  @FXML // fx:id="calculate"
  private Button calculate; // Value injected by FXMLLoader

  /**
   * A pair of radio buttons.
   */
  @FXML // fx:id="inFixButton"
  private RadioButton inFixButton; // Value injected by FXMLLoader

  @FXML // fx:id="postFixButton"
  private RadioButton postFixButton; // Value injected by FXMLLoader

  /**
   * A text field where the input will be taken.
   */
  @FXML // fx:id="questionField"
  private TextField questionField; // Value injected by FXMLLoader
  

  
  
}
