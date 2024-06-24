package uk.ac.rhul.cs2800;

/**
 * This class was inherited from the MVC-Separated, the author was @dave and it was taken 
   by his permission.
 * This was to create a new view and calculate the expression.
 *
 * @author mubin
 *
 */
public class CalcController implements CalcView {
  CalcModel model = new CalcModel();
  CalcView view;
  boolean infix;
  ViewInterface myview;
  
  
  /**
   * A method to add a view.
   *
   * @param view will be the new view that will be shown
   */
  public CalcController(ViewInterface view) {
    addView(view);
  }

  /**
   * A method to calculate the expression, received from the gui and set it on the answer screen.
   *
   * @throws InvalidExpression will be thrown  if the input is wrong
   */
  public void calculate() throws InvalidExpression {
    float answer = model.evaluate(myview.getExpression(), infix);
    myview.setAnswer(String.valueOf(answer));
    
  }

  /**
   * Take the mathematical operation that n the way it will be created.
   *
   * @param operation will be the type of the operation that will be shown.
   */
  public void expressionType(OpType operation) {
    myview.setAnswer("Changed to " + operation);
  }

  /**
   * This will add the view.
   */
  @Override
  public void addView(ViewInterface newView) {
    myview = newView;
    newView.addCalcObserver(() -> {
      try {
        calculate();
      } catch (InvalidExpression e) {
        e.printStackTrace();
      }
    });
    newView.addTypeObserver(this::expressionType);
    
  }

}
