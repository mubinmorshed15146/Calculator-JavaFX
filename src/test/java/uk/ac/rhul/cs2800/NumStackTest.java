package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NumStackTest {
  NumStack myNumStack = new NumStack();
  final float num1 = 9.0f;
  final float num2 = 11.2f;
  final float num3 = 17.9f;

  /**
   * This is a test to check weather the pop() function throw a StackEmptyException or not.
   *
   */
  @Test
  void testNumStack() {
    StackEmptyException e = assertThrows(StackEmptyException.class, () -> { 
      myNumStack.pop();  });
    assertEquals(e.getMessage(), "The stack is empty");
  }
  
  /**
   * A test for push() method.
   * In here we are pushing every item and checking the size
   */
  @Test
  void testPush() {
    myNumStack.push(num1);
    assertEquals(1, myNumStack.getSize());
    myNumStack.push(num2);
    assertEquals(2, myNumStack.getSize());
    myNumStack.push(num3);
    assertEquals(3, myNumStack.getSize());
  }

  /**
   * A test for pop() function to see that does it remove the item from the stack or not.
   * But it will throw error becaus ethe items that is inserted in the list by push()
   * if not belong to Type.NUMBER
   *
   * @throws StackEmptyException will be thrown if the stack is empty
   *
   * @throws BadTypeException will be thrown if the input does not belong to Type.NUMBER
   */
  @Test
  void testPop() throws StackEmptyException, BadTypeException {
    myNumStack.push(num1);
    assertEquals(1, myNumStack.getSize());
    myNumStack.push(num2);
    assertEquals(2, myNumStack.getSize());
    myNumStack.push(num3);
    assertEquals(3, myNumStack.getSize());
    float popedItem1 = myNumStack.pop();
    assertEquals(num3, popedItem1);
    assertEquals(2, myNumStack.getSize());
  }

  /**
   * A simple test to check the isEmpty() function.
   * If the stack is empty the return will be true or else it will be false
   */
  @Test
  void testIsEmpty() {
    assertTrue(myNumStack.isEmpty());
    myNumStack.push(num1);
    assertFalse(myNumStack.isEmpty());
  }

}
