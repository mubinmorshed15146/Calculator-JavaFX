package uk.ac.rhul.cs2800;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StandardCalctest {
  Calculator calculation = new StandardCalc();

  /**
   * This is a test to check if the input is empty then the exception is run or not.
   */
  @Test
  void testEmptyException() {
    InvalidExpression e = assertThrows(InvalidExpression.class, () -> { 
      calculation.evaluate(" ");  });
    assertEquals(e.getMessage(), "Sorry there was no input");
  }
  
  /**
   * This is a test for checking about throwing an exception if the closing bracket is not given.
   */
  @Test
  void testParenthesisException() {
    InvalidExpression e = assertThrows(InvalidExpression.class, () -> { 
      calculation.evaluate("( 3 + 5 ");  });
    assertEquals(e.getMessage(), "There was no closing bracket.");
  }
  
  /**
   * This is also a parenthesis exception checking. 
   * But this time it is about without an opening bracket.
   * The  exception will be thrown if the opening bracket is not given 
     but the closing bracket is given
   */
  @Test
  void testanotherParenthesisException() {
    InvalidExpression e = assertThrows(InvalidExpression.class, () -> { 
      calculation.evaluate(" 3 + 5 )");  });
    assertEquals(e.getMessage(), "This is a closing bracket without an opening");
  }
  
  /**
   * This is a test for checking will the exception works if any invalid input is given. 
   */
  @Test
  void testInvalidInpuJtException() {
    InvalidExpression e = assertThrows(InvalidExpression.class, () -> { 
      calculation.evaluate(" 3 + a");  });
    assertEquals(e.getMessage(), "Incorrect parenthesis expression or incorrect input");
  }
  
  /**
   * This is a test to check that the minus for standard calculator does works perfectly or not.
   * Here the minus works perfectly 
     because we have changed the operator to STANDARD_MINUS for this purpose.
   *
   * @throws InvalidExpression will be thrown if the input is wrong 
     or the parenthesis is given incorrectly.
   */
  @Test
  void substracting2numbers() throws InvalidExpression {
    assertEquals(1, calculation.evaluate(" 4 - 3 "));
  }
  
  /**
   * A simple test for adding two numbers.
   *
   * @throws InvalidExpression will be thrown if the input is wrong 
     or the parenthesis is given incorrectly.
   */
  @Test
  void adding2numbers() throws InvalidExpression {
    assertEquals(7, calculation.evaluate(" 4 + 3 "));
  }
  
  /**
   * This is a test for multiplying between two numbers.
   *
   * @throws InvalidExpression will be thrown if the input is wrong 
     or the parenthesis is given incorrectly.
   */
  @Test
  void multiplying2numbers() throws InvalidExpression {
    assertEquals(12, calculation.evaluate(" 4 * 3 "));
  }
  
  /**
   * This is a test for dividing two numbers.
   *
   * @throws InvalidExpression will be thrown if the input is wrong 
     or the parenthesis is given incorrectly.
   */
  @Test
  void dividing() throws InvalidExpression {
    assertEquals(12, calculation.evaluate(" 36 / 3 "));
  }
  
  /**
   * This is a test for checking does it work with every purpose or not.
   * That is mean that using parenthesis and multiple operators and brackets does it works or not.
   *
   * @throws InvalidExpression will be thrown if the input is wrong 
     or the parenthesis is given incorrectly.
   */
  @Test
  void testCalculateWithBracket() throws InvalidExpression {
    assertEquals(3, calculation.evaluate("( ( 7 + 2 ) * 3 ) / 9"));
    assertEquals(36, calculation.evaluate("( 3 + 3 ) * 6"));
  }
  
}
