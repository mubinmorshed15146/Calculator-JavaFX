package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * This is a RevPolish class to calculate in reverse polish style.
 * This class was inspired from the old model calculator.jar published by @Dave Cohen
   and this act was done upon his permission.
 * In his class an abstract class named calculator was implemented.
 *
 * @author mubin
 *
 */
public class RevPolishCalc implements Calculator { 
  private NumStack values;

  /**
   * This is a constructor that initialize the values which is an instance of NumStack class.
   * This stack will be used to calculate the numbers in reverse polish method
   */
  public RevPolishCalc() {
    this.values = new NumStack();
  }
  
  /**
   *This is a method from abstract class Calculator.
   *This method is overridden by default with the help of eclipse.
   *In here we approached all the ways to perform a reverse polish calculation.
   *In first if condition the check will be for if the string that will be used for
   *calculation is given or not.
   *And then the scanner method will be used to read the string.
   *Switch case will be used for doing the reverse polish notation.
   *In reverse polish method all the numbers and operands are put in a stack then the numbers are
   *pushed in a different stack until we get an operand like '+', '-', '/', '*'.
   *The exceptions will be for not giving any inputs or any error input.
   */
  
  @Override
  public float evaluate(String what) throws InvalidExpression {
    if (what == null || what.equals("")) {
      throw new InvalidExpression("Sorry there was no input");
      
    }
    Scanner sc = new Scanner(what);
    float result;
    try {

      while (sc.hasNext()) { // checking if there is any input or not

        if (sc.hasNextFloat()) { // checking if the input is float or not
          //if the value is  float then it will be pushed into the values
          values.push(sc.nextFloat()); 
        } else {
          
          /*
           * creating a String variable token to store the inputs for 
           * comparing with the symbol enum because if the string value is anything other than float
           * then the input will be saved in the token. 
           * After that it will be compared with the Symbols 
           */
          
          String token = sc.next();
          
          /* 
           * Taking a operand variable of the Symbols class for the switch case.
           * Because if the elements of token does not belong to Symbols then
           * it will be throwing error.
           * Else it will enter in the switch case by storing in operand.
           */
          
          Symbols operand = Symbols.INVALID;
          Symbols[] symbol = new Symbols[]
            {Symbols.PLUS, Symbols.MINUS, Symbols.DIVIDE, Symbols.TIMES, 
                Symbols.STANDARD_MINUS, Symbols.STANDARD_DIVIDE};
          int lenght = symbol.length;
          for (int i = 0; i < lenght; i++) {
            Symbols op = symbol[i];
            if (op.toString().equals(token)) {
              operand = op;
              break;
            }
          }
          
          /*
           * In switch case the values will be popped then if it finds an operator and then
           * it will be operated as per as the operator.
           */
          switch (operand) { 
            case PLUS: 
              values.push(this.values.pop() + this.values.pop());
              continue;
              
            case MINUS: 
              
              final float argument1 = this.values.pop(); 
              final float argument2 = this.values.pop();
              this.values.push(argument2 - argument1);
              continue;
              
              /* The reason to use STANDARD_MINUS and STANDARD_DIVIDE
                 is to use this in standard calculator.
               */
            case STANDARD_MINUS: 
              this.values.push(values.pop() - values.pop());
              continue;
             
            case DIVIDE:
              final float secondNumber = this.values.pop();
              final float firstNumber = this.values.pop();
              
              if (secondNumber == 0.0f) {
                throw new InvalidExpression("The input style was not correct."
                    + "Put a space between or check weather your input was correct or not");
                
              } 
                
              this.values.push(firstNumber / secondNumber);
             
              continue;
            case STANDARD_DIVIDE: 
              float digit = values.pop();
              if (digit == 0.0f) {
                throw new InvalidExpression("The input style was not correct."
                    + "Put a space between or check weather your input was correct or not");
                
              } 
              
              this.values.push(digit / values.pop());
              
              continue;
              
            case TIMES:
              this.values.push(this.values.pop() * this.values.pop());
              continue;
              
            default: 
              throw new InvalidExpression("Unknown operator cannot operate");
               
          }
        }
       
      }
      
      sc.close();
      result = values.pop();

      if (!values.isEmpty()) {
        throw new InvalidExpression("please give the correct input." 
      + what + "Was not correct");
      }
    } catch (Exception e) {
      throw new InvalidExpression("The input style was not correct."
          + "Put a space between or check weather your input was correct or not");
     
    }
    return result;
  }
}
