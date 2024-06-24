package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a stack class that create a stack and have some methods as push(),pop(),top() methods.
 *
 * @author mr mubin
 *
 */
public class Stack {
  private int size = 0;
  private List<Entry> myStack;

  /**
   * A constructor that initialise the stack list.
   *
   */
  public Stack() {
    myStack = new ArrayList<Entry>();


  }


  /**
   * The method that will add an elements in the stack.
   *
   * @param i is the entry type variable that will be the input of the list
   * @return the value that is supposed to be pushed
   */
  public Entry push(Entry i) {
    myStack.add(i);
    this.size = size + 1;
    return i;
  }

  /**
   * A method that will remove the latest pushed item.
   *
   * @return the removed item of the list at index or the top of the stack
   *
   * @throws StackEmptyException will be thrown if the stack is empty
   */
  public Entry pop() throws StackEmptyException {
    if (myStack.size() == 0) {
      throw new StackEmptyException("Cannot pop an item from an empty stack");
    }
    Entry obj = myStack.remove(size - 1);
    this.size = size - 1;
    return obj;
  }

  
  /**
   * A method that returns the top element of the stack.
   *
   * @return the top element of the Stack
   *
   * @throws StackEmptyException if the stack is empty then this exception will be thrown  
   */
  public Entry top() throws StackEmptyException {
    if (myStack.size() == 0) {
      throw new StackEmptyException("Cannot get the top item from an empty stack");
    }
    return myStack.get(this.size - 1);


  }

  /**
   * A method that return the size of the array.
   * The reason to use the actual size() from java.util.ArrayList 
     is to prove that the items are being pushed and getting the size logically
   *
   * @return the size of the stack
   */
  public int getSize() {
    return myStack.size();
  }

  /**
   * This is the method to check the elements of the stack by using index.
   * The purpose of this method is to perform TDD and 
     junit test to show things are working logically.
   *
   * @param index is the index value that we want to check
   * 
   * @return it returns the item that is in the i index
   *
   * @throws StackEmptyException will be thrown if the stack is empty
   */
  
  public Entry getelement(int index) throws StackEmptyException {
    if (myStack.size() == 0) {
      throw new StackEmptyException("Cannot get any item from an empty stack");
    }
    return myStack.get(index);
  }

}
