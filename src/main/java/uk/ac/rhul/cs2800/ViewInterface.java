package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

/**
 * An interface for a calculator project.
 * The purpose of creating this interface is to create a view assembly of ascii view and GUI view.
 *
 * @author mubin
 *
 */
public interface ViewInterface {
  public void setAnswer(String str);

  public String getExpression();

  public void addCalcObserver(Runnable f);

  public void addTypeObserver(Consumer<OpType> l);

}

