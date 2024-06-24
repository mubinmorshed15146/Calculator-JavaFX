package uk.ac.rhul.cs2800;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * This is a test class for RevPolishCalc for postfix notation.
 * In this J-Unit test class all the calculation has been shown.
 *
 * @author mubin
 *
 */
class ReversePolishTest {
  Calculator calculation = new RevPolishCalc();
  final float four = 4.0f;
  final float five = 5.0f;
  final float seven = 7.0f;
  final float eleven = 11.0f;
  final float twentyNine = 29.0f;
 
  /**
   * This is a test for checking if the exception works if the given string is blank or not.
   * If the string is blank or null it will show "Sorry there was no input" - this message
   */
  @Test
  void testRevPolish() {
    InvalidExpression e = assertThrows(InvalidExpression.class, () -> { 
      calculation.evaluate("");  });
    assertEquals(e.getMessage(), "Sorry there was no input");
    
  }
  
  /**
   * This is a simple test for checking  if the input is wrong type.
   * That's mean if there is any value except any float or operator
   */
  @Test
  void testInvalidInput() {
    InvalidExpression e = assertThrows(InvalidExpression.class, () -> { 
      calculation.evaluate("4 5 a b");  });
    assertEquals(e.getMessage(), "The input style was not correct."
        + "Put a space between or check weather your input was correct or not");
  }
  
  /**
   * This is a test for adding two number with reverse polish method.
   * First two element will be operated according to the operated according to the operator
     after the float values.
   *
   * @throws InvalidExpression will be thrown if the string is
     empty or null or any other error
   */
  @Test
  void tesAddingTwoNumber() throws InvalidExpression {
    assertEquals(four + five, calculation.evaluate("4 5 +"));
    assertEquals(44, calculation.evaluate("19 25 +"));
  }
  
  /**
   * This is a simple test class to test for adding 3 numbers.
   */
  @Test
  void testAddingThreeNumber() {
    try {
      assertEquals(11, calculation.evaluate("3 4 4 + +"));
    } catch (InvalidExpression e) {
      
      fail("The input style was not correct."
          + "Put a space between or check weather your input was correct or not");
    }
  }
  
  /**
   * This is another test for adding first 10 numbers.
   *
   * @throws InvalidExpression will be thrown if the values are wrong or 
     input is null or empty
   */
  @Test
  void testAddingtenNumber() throws InvalidExpression {
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
      sum = sum + i;
    }
    assertEquals(sum, calculation.evaluate("1 2 3 4 5 6 7 8 9 10 + + + + + + + + +"));
  }
  
  /**
   * This is a simple test to subtract from two numbers.
   *
   * @throws InvalidExpression if the input is wrong or
     or empty or null 
   */
  @Test
  void testMinusTwoNumber() throws InvalidExpression {
    assertEquals(twentyNine - eleven, calculation.evaluate("29 11 -"),
        "This will be doing substraction");
    assertEquals(9, calculation.evaluate("13 4 -"));
  }
  
  /**
   * This is a test for  substracting three numbers.
   *
   * @throws InvalidExpression  if the input is wrong or
     or empty or null
   *
   */
  @Test
  void testMinusThreeNumber() throws  InvalidExpression {
    float result = twentyNine - eleven;
    assertEquals(result - seven, calculation.evaluate("29 11 - 7 -"));        
  }
  
  /**
   * This is a test for checking if the number is divided by zero 
     then it does throws any exception or not.
   */
  @Test
  void testDivideByzeroException() throws InvalidExpression {
    InvalidExpression e = assertThrows(InvalidExpression.class, () -> { 
      calculation.evaluate("4 0 /");  });
    assertEquals(e.getMessage(), "The input style was not correct."
        + "Put a space between or check weather your input was correct or not");
    
  }
  
  /**
   * This is a test for checking the divide does works or not.
   *
   * @throws InvalidExpression  will be thrown if the string is
     empty or null or any other error
   */
  @Test
  void testdivide() throws InvalidExpression {
    assertEquals(16 / 4, calculation.evaluate("16 4 /"));
    float answer = 36.0f / 3.0f;
    assertEquals(answer / 4, calculation.evaluate("36 4 / 3  /"));
  }
  
  /**
   * This is a test for checking the multiply does works or not.
   * Multiplying between two or three numbers have been shown.
   *
   * @throws InvalidExpression  will be thrown if the string is
     empty or null or any other error
   */
  
  @Test
  void testTimes() throws InvalidExpression {
    assertEquals(eleven * twentyNine, calculation.evaluate("11 29 *"));
    assertEquals(144, calculation.evaluate("12 12 *"));
    assertEquals(144, calculation.evaluate("2 12 * 6 *"));
  }
  
  /**
   * This test is for trying all the operands and getting the values.
   *
   * @throws InvalidExpression  will be thrown if the string is
     empty or null or any other error
   */
  @Test
  void testAllOperators() throws InvalidExpression {
    assertEquals(2, calculation.evaluate("2 7 * 6 + 10 - 5 /"));
    
  }

}
