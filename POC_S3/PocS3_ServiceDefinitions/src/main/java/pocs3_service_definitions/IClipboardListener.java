package pocs3_service_definitions;

/**
 * This interface defines generic methods for components who want to be aware of clipboard events.
 */
public interface IClipboardListener {

  /**
   * @return
   */
  public boolean canDoCopy();

  /**
   * React to copy event.
   */
  public void doCopy();

  /**
   * React to paste event
   */
  public void doPaste();

  /**
   * React to cut event
   */
  public void doCut();

  /**
   * @return
   */
  public boolean canDoCut();

  /**
   * @return
   */
  public boolean canDoPaste();

//  /**
//   * React to delete event
//   */
//  public void doDelete();
}
