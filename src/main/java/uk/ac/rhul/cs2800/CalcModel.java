package uk.ac.rhul.cs2800;

/**
 * This is a generic class for calculator.
 * The purpose of this class is to return the result of the calculatin either infix or postfix.
 *
 * @author mubin
 *
 */
public class CalcModel {
  private Calculator revPolish;
  private Calculator standard;
  

  /**
   * A class constructor that is used for initialising the fields.
   */
  public CalcModel() {
    this.revPolish = new RevPolishCalc();
    this.standard = new StandardCalc();
  }
  
  /**
   * This is a method for evaluating.
   * The responsibility of this method is first it will check if the mode is in infix or not.
     According to the mode it will return the result by calculating the exprsn in reverse polish 
     or standard calculation
   *
   * @param exprsn is the string that will be taken as the equation for calculation
   * @param infix is the mode or option to perform the calculation weather in standard 
      or reverse polish it will be standard calculation.
      If the parameter infix is true else it will perform reverse polish. 
   * @return the calculated answer.
   *
   * @throws InvalidExpression will be thrown if the given expression is wrong.
   */
  public float evaluate(String exprsn, boolean infix) throws InvalidExpression {
    infix = true;
    if (infix) {
      return standard.evaluate(exprsn);
    } else {
      return revPolish.evaluate(exprsn);
    }
  }

}
