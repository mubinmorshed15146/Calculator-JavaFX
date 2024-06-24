package uk.ac.rhul.cs2800;

/**
 * This interface was inspired from MVC-separated created by @dave and it was done after taking 
   his permission.
   
 * This was to created So that a view can be created in controller it self.
 *
 * @author mubin
 *
 */
public interface CalcView {
 
  /**
   * A method to register itself with the controller.
   *
   * @param newView a reference for a new view with the controller
   */
  public void addView(ViewInterface newView);

}
