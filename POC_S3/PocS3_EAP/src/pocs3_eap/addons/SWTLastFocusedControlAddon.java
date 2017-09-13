package pocs3_eap.addons;
import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class SWTLastFocusedControlAddon {

  private static final String SWT_MODEL_ELEMENT = "modelElement";

  /** MUIElement's transient data key which holds the last focused widget. */
  public static final String LAST_FOCUSED_CONTROL = "lastFocusedControl";

  @PostConstruct
  public void registerFilter(Display d) {
    final Listener l = new Listener() {
      @Override
      public void handleEvent(Event event) {
        /*
         * The following Widget#getData() call is the bi-directional link
         * between SWT widget and the ApplciationModel Element, which is
         * created during:
         * org.eclipse.e4.ui.workbench.renderers.swt.SWTPartRenderer#bindWidget(MUIElement, Object)
         */
        Object modelElement = event.widget.getData(SWT_MODEL_ELEMENT);
        MUIElement view = (modelElement instanceof MUIElement) ? (MUIElement) modelElement : null;

        if (view == null && event.widget instanceof Control) {
          // search the hierarchy upwards to find the MPart
          for (Composite p = ((Control) event.widget).getParent(); p != null; p = p.getParent()) {
            modelElement = p.getData(SWT_MODEL_ELEMENT);

            if (modelElement instanceof MUIElement) {
              view = (MUIElement) modelElement;
              break; // leave the loop, we've found the view/part
            }
          }
        }

        if (view != null) {
          // keep the reference so it can be accessed in the @Focus method
          System.err.println(">>>LAST_FOCUSED_CONTROL "+event.widget+"  "+event.type);
          view.getTransientData().put(LAST_FOCUSED_CONTROL, event.widget);
        }
      }
    };
    final Listener l2 = new Listener() {
      @Override
      public void handleEvent(Event event) {
        /*
         * The following Widget#getData() call is the bi-directional link
         * between SWT widget and the ApplciationModel Element, which is
         * created during:
         * org.eclipse.e4.ui.workbench.renderers.swt.SWTPartRenderer#bindWidget(MUIElement, Object)
         */
        Object modelElement = event.widget.getData(SWT_MODEL_ELEMENT);
        MUIElement view = (modelElement instanceof MUIElement) ? (MUIElement) modelElement : null;

        if (view == null && event.widget instanceof Control) {
          // search the hierarchy upwards to find the MPart
          for (Composite p = ((Control) event.widget).getParent(); p != null; p = p.getParent()) {
            modelElement = p.getData(SWT_MODEL_ELEMENT);

            if (modelElement instanceof MUIElement) {
              view = (MUIElement) modelElement;
              break; // leave the loop, we've found the view/part
            }
          }
        }

        if (view != null) {
          // keep the reference so it can be accessed in the @Focus method
          System.err.println(">>>LAST_FOCUSED_CONTROL in "+event.widget+"  "+event.type);
          view.getTransientData().put(LAST_FOCUSED_CONTROL, event.widget);
        }
      }
    };

    // install the global focus lost handler
    d.addFilter(SWT.FocusOut, l);
    d.addFilter(SWT.FocusIn, l2);

    // manual clean-up because @PreDestory would be too late (Display already
    // disposed); not really necessary because the display will be disposed
    // but clean-up after you have made a mess!
    d.addListener(SWT.Dispose, new Listener() {
      @Override
      public void handleEvent(Event event) {
        event.display.removeFilter(SWT.FocusOut, l);
        event.display.removeFilter(SWT.FocusIn, l2);
        event.display.removeListener(SWT.Dispose, this);
      }
    });
  }
}