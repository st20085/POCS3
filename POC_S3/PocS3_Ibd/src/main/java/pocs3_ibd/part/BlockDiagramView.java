// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd.part;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pocs3_ibd_service_definitions.IBlocDiagramService;
import pocs3_ibd_service_definitions.IBlockDiagram;

/**
 * The class <b>BlockDiagramView</b> allows to
 */
public class BlockDiagramView {

    @Inject
    ESelectionService selectionService;

    @Inject
    IEclipseContext context;

    @Inject
    IBlocDiagramService blocDiagramService;

    TableViewer checkTableViewer;

    @Inject
    public BlockDiagramView() {
    }

    @PostConstruct
    public void postConstruct(Composite parent) {
        final GridLayout layout = new GridLayout(1, false);
        layout.marginWidth = layout.marginHeight = 0;
        parent.setLayout(layout);

        // temporary
        this.checkTableViewer = new TableViewer(parent, SWT.NONE);
        this.checkTableViewer.setContentProvider(ArrayContentProvider.getInstance());
        this.checkTableViewer.setInput(new IBlockDiagram[] {
            this.blocDiagramService.createNewBlockDiagram("KA return"),
            this.blocDiagramService.createNewBlockDiagram("Ibd1"),
            this.blocDiagramService.createNewBlockDiagram("Ibd2")});
        this.checkTableViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));

        //
        this.checkTableViewer.addSelectionChangedListener(event -> {
            final IStructuredSelection selection = (IStructuredSelection) event.getSelection();

            System.out.println("setSelection in thread "+Thread.currentThread());

            // set the selection to the service
            this.setSelection(selection.toArray());
        });

        this.checkTableViewer.getTable().addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("clearSeletion in thread "+Thread.currentThread());

//                BlockDiagramView.this.selectionService.setPostSelection(new Object[0]);
                final Object fake = "fake";
                BlockDiagramView.this.setSelection(fake);

                System.out.println("selection "+BlockDiagramView.this.getSelection());
                if (BlockDiagramView.this.getSelection() != fake) {
                    System.err.println("impossible d'effacer la sélection !!!"+" "+System.identityHashCode(BlockDiagramView.this.selectionService));
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                // use implicit @Focus private void setFocus()
//                final IStructuredSelection selection = (IStructuredSelection) BlockDiagramView.this.checkTableViewer.getSelection();
//                BlockDiagramView.this.setSelection(selection.toArray());
            }
        });
    }

    @Focus
    private void setFocus() {
        System.out.println("           setFocus");
        this.checkTableViewer.getControl().setFocus();

        final IStructuredSelection selection = (IStructuredSelection) BlockDiagramView.this.checkTableViewer.getSelection();
        BlockDiagramView.this.setSelection(selection.toArray());
    }

    private void setSelection(Object o) {
//        this.context.set(IServiceConstants.ACTIVE_SELECTION, o);
        this.selectionService.setSelection(o);
    }

    private Object getSelection() {
//        return this.context.get(IServiceConstants.ACTIVE_SELECTION);
        return this.selectionService.getSelection();
    }

    @Inject
    public void receiveSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Object selectedObject) {
        System.out.println("selectedObject "+selectedObject);
    }
}