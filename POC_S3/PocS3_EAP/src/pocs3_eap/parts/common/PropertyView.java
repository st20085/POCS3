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
    this.nameText = new Text(parent, SWT.BORDER);
    this.nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    this.nameText.addModifyListener(e -> this.dirty.setDirty(true));

    new Label(parent, SWT.NONE).setText("Value :");
    this.valueText = new Text(parent, SWT.BORDER);
    this.valueText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    this.valueText.addModifyListener(e -> this.dirty.setDirty(true));
  }

  @Focus
  public void setFocus() {
    this.nameText.setFocus();
  }

  @Persist
  public void save() {
    this.dirty.setDirty(false);
  }
}