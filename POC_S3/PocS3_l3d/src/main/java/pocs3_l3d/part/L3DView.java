// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_l3d.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import pocs3_l3d_model.IL3dModel;

/**
 * The class <b>L3DView</b> allows to
 */
public class L3DView {
    @Inject
    IL3dModel l3dModel;

    @Inject
    public L3DView() {}

    @PostConstruct
    public void postConstruct(Composite parent) {
        parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

        parent.setLayout(new GridLayout(1, false));

//        new Label(parent, SWT.None).setText("commonModel="+this.l3dModel.getCommonModel());
//        new Label(parent, SWT.None).setText("l3dModel="+this.l3dModel);
    }
}