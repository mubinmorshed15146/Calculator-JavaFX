package uk.ac.rhul.cs2800;

/**
 * This is an entry class that will take the numbers and symbols as entry.
 *It has four field and some getter method.
 *
 * @author mubin
 *
 */
public class Entry {
  private float number;
  private Symbols other;
  private String str;
  private Type type;



  /**
   * This is a constructor to create an object with a float value.
   *
   * @param value will take a float value that will store it in number
   */
  public Entry(float value) {
 
    this.type = Type.NUMBER;
    this.number = value;

  }

  /**
   * This is a constructor to create an object with a symbol's variable.
   *
   * @param which will take a value that will store it in other
   */

  public Entry(Symbols which) {
  
    this.type = Type.SYMBOL;
    this.other = which;
  }

  /**
   * The constructor take the parameter of String.
   * This is created for the StrStack so that the push() function can work fine
   *
   * @param str will be set as the str that we have declared as a field
   */



  public Entry(String str) {

    this.type = Type.STRING;
    this.str = str;
  }

  /**
   * The method returns the value.
   *
   * @return the number
   *
   * @throws BadtypeException if the input is not a number that is declared in enum
   */
  public float getValue() throws BadTypeException {
    if (this.type != Type.NUMBER) {
      throw new BadTypeException();
    }
    return this.number;
  }


  /**
   * It is a get type method for the Entry class.
   *
   * @return the other that is a variable of Symbol enum.
   *
   * @throws BadtypeException throws a exception if the input is not in symbol
   */
  public Symbols getSymbol() throws BadTypeException {
    if (this.type != Type.SYMBOL) {
      throw new BadTypeException();
    }
    return other;
  }

  /**
   * A getter that returns the string.
   *
   * @return the string which was an input in the constructor
   *
   * @throws BadTypeException will show a message if the input is somehow wrong
   */
  public String getString() throws BadTypeException {
    if (this.type != Type.STRING) {
      throw new BadTypeException();
    }
    return this.str;
  }
  
  /**
   * A method that should return the type.
   *
   * @return the type
   */
  public Type getType() {
    return this.type;
  }
 
}


