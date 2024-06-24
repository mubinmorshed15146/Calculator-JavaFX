package uk.ac.rhul.cs2800;



/**
 * The enum class that have elements under the names of mathematical expression.
 *
 * @author mubin
 *
 */
public enum Symbols {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      " "), STANDARD_DIVIDE("!"), STANDARD_MINUS("_");

  private String expression;

  Symbols(String expression) {
    this.expression = expression;
  }

  @Override
  public String toString() {
    return expression;
  }

}
