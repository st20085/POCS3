// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.airbus.pocs3_eap.parts.common;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The class <b>BlockDiagramView</b> allows to
 */
public class PropertyView {
  @Inject
  public PropertyView() {}

  @PostConstruct
  public void postConstruct(Composite parent) {
    final GridLayout layout = new GridLayout(2, false);
//    layout.marginWidth = layout.marginHeight = 0;
    parent.setLayout(layout);

    // temporary
    new Label(parent, SWT.NONE).setText("Name :");
    new Text(parent, SWT.NONE).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    new Label(parent, SWT.NONE).setText("Value :");
    new Text(parent, SWT.NONE).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
  }
}