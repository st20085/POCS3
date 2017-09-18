// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pocs3_ibdcontroller.BlockDiagramController;
import pocs3_ibdcontroller.BlockDiagramEditController;
import pocs3_ibdmodel.action.IBlockDiagramAction;
import pocs3_service_definitions.IEditAction;

/**
 * The class <b>ApplicationModuleView</b> allows to
 */
public class ApplicationModuleView implements IAdaptable {
    @Inject
    public ApplicationModuleView() {
    }

    @PostConstruct
    public void postConstruct(Composite parent) {
        final GridLayout layout = new GridLayout(1, false);
        layout.marginWidth = layout.marginHeight = 0;
        parent.setLayout(layout);

        // temporary
        final TableViewer checkTableViewer = new TableViewer(parent, SWT.NONE);
        checkTableViewer.setContentProvider(ArrayContentProvider.getInstance());
        checkTableViewer.setInput(new String[] {"Mod1", "Mod2", "Mod3"});
        checkTableViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    @Inject
    BlockDiagramController blockDiagramController;

    @Inject
    BlockDiagramEditController blockDiagramEditController;

    @Override
    public <T> T getAdapter(Class<T> adapter) {
//        if (IEditAction.class.equals(adapter)) {
//            return adapter.cast(this.blockDiagramEditController);
//        }
        if (IBlockDiagramAction.class.equals(adapter)) {
            return adapter.cast(this.blockDiagramController);
        }
        if (IEditAction.class.equals(adapter)) {
            return adapter.cast(this.blockDiagramEditController);
        }
        return null;
    }

}