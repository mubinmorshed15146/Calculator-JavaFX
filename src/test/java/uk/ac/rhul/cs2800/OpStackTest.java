package uk.ac.rhul.cs2800;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * A test class to implement TDD and check for bugs and error.
 *
 * @author mubin
 *
 */
class OpStackTest {
  OpStack myOpStack = new OpStack();
  Symbols plus = Symbols.PLUS;
  Symbols minus = Symbols.MINUS;
  Symbols divide = Symbols.DIVIDE;
  Symbols times = Symbols.TIMES;
  

  /**
   * A test to check weather the stack empty exception class works or not.
   */
  @Test
  void testOpStack() {
    StackEmptyException e = assertThrows(StackEmptyException.class, () -> { 
      myOpStack.pop();  });
    assertEquals(e.getMessage(), "The Stack is empty");
  }
  

  /**
   * Testing the push method for OpStack class.
   * In here we used a getStackSize() method.
   * It was not given in the UML but I have used to check the size after push to perform TDD
   */
  @Test
  void testPush() {
    myOpStack.push(divide);
    assertEquals(1, myOpStack.getStackSize());
    myOpStack.push(minus);
    myOpStack.push(plus);
    myOpStack.push(times);
    assertEquals(4, myOpStack.getStackSize());
    
  }

  /**
   * Testing the pop() function.
   * It will be throwing error because no matter what the input is it is actually not Type.SYMBOL
   *
   * @throws StackEmptyException will be thrown if the stack is empty
   *
   * @throws BadTypeException will be thrown if the item that has been input it is not Type.SYMBOL
   */
  @Test
  void testPop() throws StackEmptyException, BadTypeException {
    myOpStack.push(divide);
    assertEquals(1, myOpStack.getStackSize());
    assertEquals(divide, myOpStack.pop());
    assertEquals(0, myOpStack.getStackSize());
    myOpStack.push(minus);
    myOpStack.push(plus);
    myOpStack.push(times);
    assertEquals(3, myOpStack.getStackSize());
    assertEquals(times, myOpStack.pop());
    assertEquals(plus, myOpStack.pop());
    assertEquals(1, myOpStack.getStackSize());
    
  }
  

  /**
   * It is a test for isEmpty().
   * It will thrown true if the stack is empty.
   * Otherwise it will throw false
   */
  @Test
  void testIsEmpty() {
    assertTrue(myOpStack.isEmpty());
    myOpStack.push(divide);
    assertFalse(myOpStack.isEmpty());
  }

  
}
