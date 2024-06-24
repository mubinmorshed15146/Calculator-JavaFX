package uk.ac.rhul.cs2800;

/**
 * An exception class that will throw an exception if there any mistake has been done.
 *
 * @author mubin
 *
 */
public class BadTypeException extends Exception {
  
  private static final long serialVersionUID = 1L;
 
  /**
   * A constructor that takes no parameter. If there is an exception occurs then the message in
   * the super method the message will be shown as an error message.
   * 
   */
  public  BadTypeException() {
    super("The input was invalid please give a correct input");

  }
}
