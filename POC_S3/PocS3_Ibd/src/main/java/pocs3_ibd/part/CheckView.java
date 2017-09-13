// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * The class <b>CheckView</b> allows to
 */
public class CheckView {
  TableViewer checkTableViewer;

  @Inject
  public CheckView() {}

  @PostConstruct
  public void postConstruct(Composite parent) {
    final GridLayout layout = new GridLayout(1, false);
    layout.marginWidth = layout.marginHeight = 0;
    parent.setLayout(layout);

    // temporary
    checkTableViewer = new TableViewer(parent, SWT.NONE);
    checkTableViewer.setContentProvider(ArrayContentProvider.getInstance());
    checkTableViewer.setInput(new String[] { "Bridges", "Connections", "Ports" });
    checkTableViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
  }

  @Focus
  private void setOnFocus() {
    checkTableViewer.getControl().setFocus();
  }
}