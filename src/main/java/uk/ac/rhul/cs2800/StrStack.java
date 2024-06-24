package uk.ac.rhul.cs2800;

/**
 * A StrStack class that create a stack with the stack class. It has a constructor and some methods
 *
 * @author mubin
 *
 */
public class StrStack {
  private Stack myStrStack;

  /**
   * This is a constructor that initialise myStr stack every time any object is created with this
   * class.
   */
  public StrStack() {
    this.myStrStack = new Stack();
  }

  /**
   * push() method will insert an element at the end of the stack.
   *
   * @param element will be string item that will be added upon calling this method
   */
  public void push(String element) {
    this.myStrStack.push(new Entry(element));

  }

  /**
   * This is a method to remove an item from top of the stack.
   *
   * @return the removed item from the stack
   *
   * @throws BadTypeException will be thrown if any input is wrong
   * @throws StackEmptyException will be thrown if the stack is empty
   */
  public String pop() throws StackEmptyException, BadTypeException {
    if (myStrStack.getSize() == 0) {
      throw new StackEmptyException("The Stack is empty");
    }
    Entry obj = myStrStack.pop();
    return obj.getString();

  }

  /**
   * This is a method to find out if the stack is empty or not.
   *
   * @return will be true if the stack is empty means size is zero. Otherwise it will return false
   */
  public boolean isEmpty() {
    if (myStrStack.getSize() == 0) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * A method created to test the other methods to proceed tdd.
   *
   * @return the size of the stack that is created using the StrStack class
   */
  
  public int getStrStackSize() {
    
    return myStrStack.getSize();
  }
  
}



