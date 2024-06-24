package uk.ac.rhul.cs2800;

/**
 * An exception class for expression error.
 *
 * @author mubin
 *
 */
public class InvalidExpression extends Exception {
  /**
  * A final static serializable id.
  * When java deserialize an object,if the serialized 
  * id dosen't match then the exception will be thrown
  */
  private static final long serialVersionUID = 1L;

  public InvalidExpression(String message) {
    super(message);
  }
}
