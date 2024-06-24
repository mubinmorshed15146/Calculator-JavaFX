package uk.ac.rhul.cs2800;

/**
 * This is a Stack empty exception class.
 * It is created to use in the stack related class.
 * The purpose is if the stack is empty a message will be shown
 *
 * @author mubin
 *
 */
public class StackEmptyException extends Exception {

  /**
   * A default serialversion id created by eclipse.
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * A constructor to set the message meaningful manually.
   *
   * @param errorMessage is the string variable that will be message that will be shown
   */
  
  public StackEmptyException(String errorMessage) {
    super(errorMessage);
  }

}
