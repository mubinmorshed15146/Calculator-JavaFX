package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * A test class for StrStack class to perform TDD.
 *
 * @author mubin
 *
 */
class StrStackTest {
  StrStack stackForTest = new StrStack();
  String item1;
  String item2;
  String item3;


  /**
   * A stack test method that is to test the exception.
   * The pop() function will throw an exception if the stack is empty.
   */
  @Test
  void testStrStack() {
    StackEmptyException e = assertThrows(StackEmptyException.class, () -> { 
      stackForTest.pop();  });
    assertEquals(e.getMessage(), "The Stack is empty");
  }

  /**
   * A test to check if the the s push() working or not.
   * After pushing we are checking if the size has increased or not
   * If the size increases we can confirm that the string has been pushed 
   *
   */
  @Test
  void testPush() {
    item1 = "Random string for testing push";
    item2 = "Another String for testing push";
    stackForTest.push(item1);
    assertEquals(1, stackForTest.getStrStackSize());
    stackForTest.push(item2);
    assertEquals(2, stackForTest.getStrStackSize());
    
    
  }
  
  /**
   * We are checking if the push() method is working even 1000 are pushed.
   * Reason is to check in more detail if there is any error or not
   */
  @Test
  void testing1000Push() {
    for (int i = 0; i < 1000; i++) {
      stackForTest.push(String.valueOf(i));
    }
    assertEquals(1000, stackForTest.getStrStackSize());
  }

  /**
   * testPop() is to check the pop() method from StrStack
   * This test will have an error because the strings do not belong to Symbol.STRING.
   *
   * @throws StackEmptyException if the stack is empty
   *
   * @throws BadTypeException if the in put type is not the expected input type
   */
  @Test
  void testPop() throws StackEmptyException, BadTypeException {
    item1 = "Random string for testing pop";
    item2 = "Another String for testing pop";
    item3 = "A 3rd String for check pop function";
    stackForTest.push(item2);
    stackForTest.push(item1);
    assertEquals(2, stackForTest.getStrStackSize());
    stackForTest.pop();
    assertEquals(1, stackForTest.getStrStackSize());
    assertEquals(item2, stackForTest.pop());
    
    
  }
  
  /**
   * A simple test to check if isEmpty() method working.
   * isEmpty will be true if  the stackForTest is empty otherwise will be false
   * assertTrue will be passed if the stackForTest is empty or it will fail the test
   * assertFalse will pass the test if the stackForTest is not empty
   */
  @Test
  void testIsEmpty() {
    assertTrue(stackForTest.isEmpty());
    item1 = "Random string for testing pop";
    item2 = "Another String for testing pop";
    item3 = "A 3rd String for check pop function";
    stackForTest.push(item1);
    stackForTest.push(item2);
    stackForTest.push(item3);
    assertFalse(stackForTest.isEmpty());
  }

}
