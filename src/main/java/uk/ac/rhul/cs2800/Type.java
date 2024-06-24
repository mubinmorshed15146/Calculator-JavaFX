package uk.ac.rhul.cs2800;

/**
 * A test class that check all the methods of the stack class. This class inherits the stack class.
 *
 * @author mubin
 * 
 */
public enum Type {
  NUMBER("Number"), SYMBOL("Symbols"), STRING("String"), INVALID("Invalid");

  private String myInput;

  Type(String myInput) {
    this.myInput = myInput;
  }

  @Override
  public String toString() {
    return myInput;
  }
}

