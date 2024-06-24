package uk.ac.rhul.cs2800;

/**
 * This is a simple interface that is used in RevPolishCalc and StandardCalc class.
 *It has a abstract method that will be used in both RevPolishCalc and StandardCalc
 *
 * @author mubin
 *
 */
public interface Calculator {
  /**
   * An abstract method that will be used for evaluation for the both reverse polish
   * and standard calculation.
   *
   * @param what is the string that will be entered for calculation
   *
   * @return it will return the calculated result.
   *
   * @throws InvalidExpressionException will be thrown if there is no input or any unbalanced string
   * 
   */
  
  public float evaluate(String what)throws  InvalidExpression;
}
