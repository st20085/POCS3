// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_l3d.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * The class <b>UnitView</b> allows to
 */
public class UnitView  {
    @Inject
    public UnitView() {
    }

    @PostConstruct
    public void postConstruct(Composite parent) {
        final GridLayout layout = new GridLayout(1, false);
        layout.marginWidth = layout.marginHeight = 0;
        parent.setLayout(layout);

        // temporary
        final TableViewer checkTableViewer = new TableViewer(parent, SWT.NONE);
        checkTableViewer.setContentProvider(ArrayContentProvider.getInstance());
        checkTableViewer.setInput(new String[] {"Unit1", "Unit2", "Unit3"});
        checkTableViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
    }
}