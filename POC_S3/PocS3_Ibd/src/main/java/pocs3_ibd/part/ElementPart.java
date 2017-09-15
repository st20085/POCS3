
package pocs3_ibd.part;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pocs3_common_model.ICommonElementModel;
import pocs3_common_model.event.CommonElementModelEvent;
import pocs3_common_model.event.CommonElementModelListener;
import pocs3_ibdmodel.IbdModel;
import pocs3_service_definitions.IElement;
import pocs3_service_definitions.IElementAction;
import pocs3_service_definitions.IElementService;

public class ElementPart implements IElementAction {
    @Inject
    IbdModel ibdModel;

//    @Inject
//    private MDirtyable dirty;

    TableViewer tableViewer;

    @Inject
    IElementService elementService;

    @Inject
    ESelectionService selectionService;

    @PostConstruct
    public void createComposite(Composite parent) {
        final GridLayout layout = new GridLayout(1, false);
        layout.marginWidth = layout.marginHeight = 0;
        parent.setLayout(layout);

        this.tableViewer = new TableViewer(parent);

        this.tableViewer.setContentProvider(new CommonElementModelContentProvider());

        this.tableViewer.setInput(this.ibdModel.getCommonElementModel());
        this.tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));

        //
        this.tableViewer.addSelectionChangedListener(event -> {
            final IStructuredSelection selection = (IStructuredSelection) event.getSelection();

            // set the selection to the service
            this.selectionService.setSelection(selection.toArray());
        });

        // refresh table when element model changes
        this.ibdModel.getCommonElementModel().addCommonElementModelListener(new CommonElementModelListener() {
            @Override
            public void modelChanged(CommonElementModelEvent commonElementModelEvent) {
                ElementPart.this.tableViewer.refresh();
            }
        });
    }

    @Focus
    private void setFocus() {
        // System.out.println(" setFocus");
        this.tableViewer.getControl().setFocus();

        // final IStructuredSelection selection = (IStructuredSelection) this.tableViewer.getSelection();
        // this.setSelection(selection.toArray());
    }

    @Override
    public boolean canCreateElement() {
        return true;
    }

    @Override
    public void createElement(String elementName) {
        final IElement element = this.elementService.createNewElement(elementName);

        this.ibdModel.getCommonElementModel().addElements(Collections.singletonList(element));

        this.tableViewer.refresh();
    }

    /**
     *
     */
    class CommonElementModelContentProvider implements IStructuredContentProvider {

        /**
         * Returns the elements in the input, which must be either an array or a
         * <code>Collection</code>.
         */
        @Override
        public Object[] getElements(Object inputElement) {
            if (inputElement instanceof ICommonElementModel) {
                return ((ICommonElementModel) inputElement).getElements().toArray();
            }
            return new Object[0];
        }
    }

//    @Persist
//    public void save(IProgressMonitor progressMonitor) {
//        System.out.println("progressMonitor " + progressMonitor);
//        this.dirty.setDirty(false);
//    }
//
//    private List<String> createInitialDataModel() {
//        return Arrays.asList("Sample item 1", "Sample item 2", "Sample item 3", "Sample item 4", "Sample item 5");
//    }
}