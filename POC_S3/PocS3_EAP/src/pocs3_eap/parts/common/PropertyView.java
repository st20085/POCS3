// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_eap.parts.common;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The class <b>PropertyView</b> allows to
 */
public class PropertyView {
  @Inject
  private MDirtyable dirty;

  private Text nameText;
  private Text valueText;

  @Inject
  public PropertyView() {}

  @PostConstruct
  public void postConstruct(Composite parent) {
    final GridLayout layout = new GridLayout(2, false);
//    layout.marginWidth = layout.marginHeight = 0;
    parent.setLayout(layout);

    // temporary
    new Label(parent, SWT.NONE).setText("Name :");
    nameText = new Text(parent, SWT.NONE);
    nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    nameText.addModifyListener(e -> dirty.setDirty(true));

    new Label(parent, SWT.NONE).setText("Value :");
    valueText = new Text(parent, SWT.NONE);
    valueText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    valueText.addModifyListener(e -> dirty.setDirty(true));
  }

  @Focus
  public void setFocus() {
    nameText.setFocus();
  }

  @Persist
  public void save() {
    dirty.setDirty(false);
  }
}