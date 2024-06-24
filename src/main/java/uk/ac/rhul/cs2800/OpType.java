package uk.ac.rhul.cs2800;

/**
 * An enum for the operation type of the calculator.
 *
 * @author mubin
 *
 */
public enum OpType {

  /**
   * A method to calculate things in a standard way like (4+5)-7.
   */
  INFIX, 
  /**
   * A way where operator comes after the numbers. Example : 457+-
   */
  POSTFIX;
}
