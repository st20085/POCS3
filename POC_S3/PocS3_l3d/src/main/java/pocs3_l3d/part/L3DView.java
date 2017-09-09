// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_l3d.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

/**
 * The class <b>L3DView</b> allows to
 */
public class L3DView {
    @Inject
    public L3DView() {
    }

    @PostConstruct
    public void postConstruct(Composite parent) {
        System.err.println(parent.getLayout());
        parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
    }
}