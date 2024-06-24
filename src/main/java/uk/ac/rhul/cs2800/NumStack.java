package uk.ac.rhul.cs2800;


/**
 * A Numstack class for the calculator so that it can calculate the number.
 *It has 3 method push,pop and isEmpty.
 *
 * @author mubin
 *
 */
public class NumStack {
  private final Stack numberStack;

  public NumStack() {
    this.numberStack = new Stack();
  }

  /**
   
   * A push method that will push float values.
   *
   * @param value is the float value that will be pushed in the numStack.
   */
  public final void push(float value) {
    this.numberStack.push(new Entry(value));

  }

  /**
   * The pop function removes the value from the numberStack.
   *
   * @return if the stack has some value it will return the top item that will be popped
   * @throws BadTypeException will be thrown if the typw is not 
   *
   * @throws EmptyStackException if the numberstack is empty, it will throw an empty exception error
   */
 
  public final float pop() throws StackEmptyException, BadTypeException {
    if (numberStack.getSize() == 0) {
      throw new StackEmptyException("The stack is empty");
      
    }
    return numberStack.pop().getValue();

  }
  /**
   * A method to check weather the numberStack is empty or not.
   *
   * @return it will return true if the numberStack is empty
   */
  
  public boolean isEmpty() {
    return this.numberStack.getSize() == 0;
  }
  
  /**
   * A method created to test the other methods to proceed tdd.
   *
   * @return the size of the stack that is created using the StrStack class
   */
  
  public int getSize() {
    return numberStack.getSize();
  }
}

