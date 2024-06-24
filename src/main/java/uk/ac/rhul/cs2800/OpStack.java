package uk.ac.rhul.cs2800;


/**
 * A public class of OpStack that is made with Stack. It has 3 methods. push(),pop() and isEmpty()
 *
 * @author mubin
 *
 */

public class OpStack {
  private Stack myOpstack;

  /**
   * A class constructor that takes no value. But it initialise the myOpstack.
   *
   */

  public OpStack() {
    this.myOpstack = new Stack();
  }

  /**
   * The push method add an element of Symbols data type.
   *
   * @param operator is the variable of Symbols data type that will be added in myOpstack
   */
  public void push(Symbols operator) {
    this.myOpstack.push(new Entry(operator));
  }

  /**
   * This pop() function will remove the element from myOpstack.
   *
   * @return will be giving the latest value of the stack
   *
   * @throws BadTypeException if the input is not Type.SYMBOL then it will throw this exception
   *
   * @throws StackEmptyException will be thrown if the stack is empty
   */
  public Symbols pop() throws StackEmptyException, BadTypeException {
    if (myOpstack.getSize() == 0) {
      throw new StackEmptyException("The Stack is empty");
    }
    return  this.myOpstack.pop().getSymbol();
  }

  /**
   * A method that returns the boolean value if the list is empty or not.
   *
   * @return true if the OpStack is empty else it will return false
   */
  public boolean isEmpty() {
    return  myOpstack.getSize() == 0;
    
  }
  
  
  /**
   * A method created to test the other methods to proceed tdd.
   *
   * @return the size of the stack that is created using the OpStack class
   */

  public int getStackSize() {
    
    return myOpstack.getSize();
  }
  
}


