// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd.part;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pocs3_common_model.event.BlockDiagramModelEvent;
import pocs3_common_model.event.BlockDiagramModelListener;
import pocs3_ibdcontroller.BlockDiagramController;
import pocs3_ibdcontroller.BlockDiagramEditController;
import pocs3_ibdmodel.action.IBlockDiagramAction;
import pocs3_service_definitions.IBlockDiagram;
import pocs3_service_definitions.IEditAction;

/**
 * The class <b>BlockDiagramView</b> allows to
 */
public class BlockDiagramView implements IAdaptable {

    @Inject
    ESelectionService selectionService;

    @Inject
    IEclipseContext context;

    @Inject
    MDirtyable dirtyable;

    // public pour le POC
    public TableViewer blockDiagramTableViewer;

    @Inject
    BlockDiagramEditController blockDiagramEditController;

    @Inject
    BlockDiagramController blockDiagramController;

    BlockDiagramModelListener ibdModelListener;

    @Inject
    public BlockDiagramView() {}

    @PostConstruct
    public void postConstruct(Composite parent) {
        final GridLayout layout = new GridLayout(1, false);
        layout.marginWidth = layout.marginHeight = 0;
        parent.setLayout(layout);

        // temporary
        this.blockDiagramTableViewer = new TableViewer(parent, SWT.NONE | SWT.MULTI);
        this.blockDiagramTableViewer.setContentProvider(ArrayContentProvider.getInstance());
        this.blockDiagramTableViewer.setInput(this.blockDiagramController.getBlockDiagrams());
        this.blockDiagramTableViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));

        //
        this.blockDiagramTableViewer.addSelectionChangedListener(event -> {
            final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
            final IBlockDiagram[] selectedBlockDiagrams = getSelectedBlockDiagrams(selection);

            this.blockDiagramEditController.setBlockDiagrams(selectedBlockDiagrams);

            // set the selection to the service
            this.setSelection(selection.toArray());
        });

        // add listener to refresh treeViewer
        this.ibdModelListener = new BlockDiagramModelListener() {
            @Override
            public void modelChanged(BlockDiagramModelEvent ibdModelEvent) {
                // refresh treeViewer
                BlockDiagramView.this.blockDiagramTableViewer.setInput(BlockDiagramView.this.blockDiagramController.getBlockDiagrams());

                BlockDiagramView.this.dirtyable.setDirty(true);
            }
        };
        this.blockDiagramController.addIbdModelListener(this.ibdModelListener);
    }

    @Focus
    private void setFocus() {
        this.blockDiagramTableViewer.getControl().setFocus();
    }

    @PreDestroy
    private void dispose() {
        this.blockDiagramController.removeIbdModelListener(this.ibdModelListener);
    }

    @Persist
    private void save() {
        // do nothing
        this.dirtyable.setDirty(false);
    }

    private void setSelection(Object o) {
        this.selectionService.setSelection(o);
    }

    /**
     * Get selected block diagrams
     *
     * @param selection
     */
    private static IBlockDiagram[] getSelectedBlockDiagrams(final IStructuredSelection selection) {
        final Object[] selectedArray = selection.toArray();
        final IBlockDiagram[] selectedBlockDiagrams = new IBlockDiagram[selectedArray.length];
        System.arraycopy(selectedArray, 0, selectedBlockDiagrams, 0, selectedArray.length);
        return selectedBlockDiagrams;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (IEditAction.class.equals(adapter)) {
            return adapter.cast(this.blockDiagramEditController);
        }
        if (IBlockDiagramAction.class.equals(adapter)) {
            return adapter.cast(this.blockDiagramController);
        }
        return null;
    }
}