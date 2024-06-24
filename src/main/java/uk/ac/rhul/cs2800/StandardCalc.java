package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * This is a class for standard calculation.
 * This class was inspired from the calculator.jar project that was published by @Dave Cohen and 
   this act is done by his permission.
   
 * In this class an object from RevPolishCalc to calculate.
 * The values field is used for storing the operators. And proceed the 
   calculation as per the operators
 * The field called rpCalc is used for the main calculation. 
 * The field called resiltStack is used to re-arrange the inputs for a reverse polish calculation.
 *
 * @author mubin
 *
 */
public class StandardCalc implements Calculator {
  private OpStack values;
  private RevPolishCalc rpCalc;
  private StrStack resultStack;
  
  /**
   * This is a class constructor in where values and rpCalc is initialized.
   * resultStack is al initialized but as zero
   */
  public StandardCalc() {
    this.rpCalc = new RevPolishCalc();
    this.values = new OpStack();
    this.resultStack = null;
  }

  /**
   *This is a method from the interface Calculator that has been overridden.
   *In here the String expression what will be read with the help of scanner class and it will
    be pushed into the resultStack. And then in result stack if there is any element exist
    it will be stored in a String variable named 'variable'. If the variable is consist of numbers,
    then it will be added or appended in a StringBuilder named result. And then a for loop will be 
    used to check if there is any operator is in the variable. And the it will be appended in the 
    StringBuilder result. The the string value of the result will be put through the rpCalc and that
    will be the output.
    
   * In case of bracket first it will pop it out then use a for loop to pop all the operators 
     and store it in the result which is the StringBuilder.
     Then it will perform the calculation accordingly. If there is no closing brackets 
     or a closing bracket without a opening bracket then it will throw an error with a message. 
      
   * 
    
   */
  @Override
  public float evaluate(String what) throws InvalidExpression {
    Scanner sc = new Scanner(what);
    StringBuilder result = new StringBuilder();
    this.resultStack = new StrStack();
    while (sc.hasNext()) {
      resultStack.push(sc.next());
    }
    sc.close();
    boolean numbers = true;
    while (!resultStack.isEmpty()) {
      String variables = null;
      try {
        variables = resultStack.pop();
      } catch (StackEmptyException | BadTypeException e) {
        e.printStackTrace();
      }
      if (Character.isDigit(variables.charAt(0)) && numbers) {
        result.append(String.valueOf(variables) + " ");
        numbers = false;
      } else {
        Symbols operator = Symbols.INVALID;
        Symbols [] symbol = Symbols.values();
        for (int i = 0; i < symbol.length; i++) {
          Symbols op = symbol[i];
          if (op.toString().equals(variables)) {
            operator = op;
            break;
          }
        
        }
        if (operator == Symbols.LEFT_BRACKET) {
         
          try {
            for (Symbols newOp = values.pop(); newOp != Symbols.RIGHT_BRACKET;
                newOp = values.pop()) {
              result.append(String.valueOf(newOp.toString()) + " ");
            }
            continue;
          } catch (Exception e) {
            throw new InvalidExpression("There was no closing bracket.");
          }
        }        
        if (operator != Symbols.RIGHT_BRACKET && numbers) {
          throw new InvalidExpression("Incorrect parenthesis expression or incorrect input");
        }
        /*Changing the minus and divide operator
         * The reason behind i if we are using the reverse polish method 
           in the string builders first item to pop is actually the 1st number o the stack.
         * That's why we changed it because for this there is different calculation 
           in RevPolishcalc class.
         */
        if (operator == Symbols.MINUS) {
          
          operator = Symbols.STANDARD_MINUS;
        } else if (operator == Symbols.DIVIDE) {
          
          operator = Symbols.STANDARD_DIVIDE;
        }
        this.values.push(operator);
        numbers = true;

      }
      
    }
    while (!values.isEmpty()) {
      Symbols newOperator = Symbols.INVALID;
      try {
        newOperator  = values.pop();
      } catch (Exception e) {
        throw new InvalidExpression("Wrong input");
      }
      if (newOperator == Symbols.RIGHT_BRACKET) {
        throw new InvalidExpression("This is a closing bracket without an opening");
      }
      result.append(String.valueOf(newOperator.toString()) + " ");
    }
    
    return rpCalc.evaluate(result.toString());
  }

}
