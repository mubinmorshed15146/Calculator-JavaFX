package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * A test class that check all the methods of the stack class. This class inherits the stack class.
 *
 * @author mubin.
 *
 */

class StacktTest {

  Stack rhulstack = new Stack();
  Entry obj1 = new Entry(9.0f);
  Entry obj2 = new Entry(7.0f);

  /**
   * The test method for pushing the items in to the stack then checking the size.
   * Also checking the object that we have input is the same or not.
   *
   * @throws StackEmptyException will be thrown if the stack is empty
   */
  @Test
  void testPush() throws StackEmptyException {
    rhulstack.push(obj1);
    assertEquals(obj1, rhulstack.getelement(0));
    rhulstack.push(obj2);
    assertEquals(obj2, rhulstack.getelement(1));
    assertEquals(2, rhulstack.getSize());

  }

  //

  /**
   * Testing the popping method and then checking the value is same or not.
   *
   * @throws StackEmptyException will be thrown if the stack is empty.
   *
   * @throws BadtypeException It will be throwing error if the stack is empty
   */
  @Test

  void testPop() throws BadTypeException, StackEmptyException {

    rhulstack.push(obj1);
    rhulstack.push(obj2);

    assertEquals(2, rhulstack.getSize());
    assertEquals(obj2, rhulstack.pop(), "object j will be poped out");

  }

  /**
   * A test method that will check the top item of the stack.
   *
   * @throws StackEmptyException will be thrown if the stack is empty.
   */
  @Test
  void testTop() throws StackEmptyException {
    rhulstack.push(obj1);
    rhulstack.push(obj2);
    assertEquals(obj2, rhulstack.top());
  }

  /**
   * A test method that check the size.
   *
   * @throws BadtypeException if the stack is empty
   */
  @Test
  void testSize() throws BadTypeException {
    rhulstack.push(obj1);
    rhulstack.push(obj2);
    assertEquals(2, rhulstack.getSize());
  }
  
  @Test
  void pushing100ObjectAndTestingSize() {
    for (int i = 0; i < 100; i++) {
      rhulstack.push(new Entry((float) i));
    }
    assertEquals(100, rhulstack.getSize(), "The size will be 100");
  }
  //
}
