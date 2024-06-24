package uk.ac.rhul.cs2800;

/**
 * An exception class for the RevPolCalc and StandardCalc class.
 * It will be used if the input is wrong or empty
 *
 * @author mubin
 *
 */
public class InvalidExpressionException extends Exception {

  /**
   * A default serializable id created by eclipse.
   */
  private static final long serialVersionUID = 1L;

  public InvalidExpressionException(String errorMsg) {
    super(errorMsg);
  }

}
