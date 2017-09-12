// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd.part;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import pocs3_ibd.part.handler.IBlockDiagramPart;
import pocs3_ibd_service_definitions.IBlocDiagramService;
import pocs3_ibd_service_definitions.IBlockDiagram;
import pocs3_service_definitions.IEditAction;

/**
 * The class <b>BlockDiagramView</b> allows to
 */
public class BlockDiagramView implements IBlockDiagramPart, IEditAction {

    @Inject
    ESelectionService selectionService;

    @Inject
    IEclipseContext context;

    @Inject
    IBlocDiagramService blocDiagramService;

    TableViewer checkTableViewer;

    List<IBlockDiagram> blockDiagramList = new ArrayList<>();

    // fake
    List<IBlockDiagram> fakeBlockDiagramListClipboard = new ArrayList<>();

    @Inject
    public BlockDiagramView() {}

    @PostConstruct
    public void postConstruct(Composite parent) {
        final GridLayout layout = new GridLayout(1, false);
        layout.marginWidth = layout.marginHeight = 0;
        parent.setLayout(layout);

        // init
        this.initBlockDiagramList();

        // temporary
        this.checkTableViewer = new TableViewer(parent, SWT.NONE | SWT.MULTI);
        this.checkTableViewer.setContentProvider(ArrayContentProvider.getInstance());
        this.checkTableViewer.setInput(this.blockDiagramList);
        this.checkTableViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));

        //
        this.checkTableViewer.addSelectionChangedListener(event -> {
            final IStructuredSelection selection = (IStructuredSelection) event.getSelection();

            System.out.println("setSelection in thread " + Thread.currentThread());

            // set the selection to the service
            this.setSelection(selection.toArray());
        });
    }

    /**
     *
     */
    private void initBlockDiagramList() {
        this.blockDiagramList.add(this.blocDiagramService.createNewBlockDiagram("KA return"));
        this.blockDiagramList.add(this.blocDiagramService.createNewBlockDiagram("Ibd1"));
        this.blockDiagramList.add(this.blocDiagramService.createNewBlockDiagram("Ibd2"));
    }

    @Focus
    private void setFocus() {
        this.checkTableViewer.getControl().setFocus();

        //
        final IStructuredSelection selection = (IStructuredSelection) BlockDiagramView.this.checkTableViewer.getSelection();
        BlockDiagramView.this.setSelection(selection.toArray());
    }

    private void setSelection(Object o) {
        this.selectionService.setSelection(o);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * @see pocs3_service_definitions.IEditAction#canCopy()
     */
    @Override
    public boolean canCopy() {
        final IStructuredSelection selection = (IStructuredSelection) BlockDiagramView.this.checkTableViewer.getSelection();
        return !selection.isEmpty();
    }

    /*
     * @see pocs3_service_definitions.IEditAction#copy()
     */
    @Override
    public void copy() {
        final IStructuredSelection selection = (IStructuredSelection) BlockDiagramView.this.checkTableViewer.getSelection();
        System.out.println("copied " + Arrays.toString(selection.toArray()));

        this.fakeBlockDiagramListClipboard.clear();
        for (final Object o : selection.toArray()) {
            this.fakeBlockDiagramListClipboard.add((IBlockDiagram) o);
        }
    }

    /**
     *
     */
    @Override
    public String getCopyTooltip() {
        final IStructuredSelection selection = (IStructuredSelection) BlockDiagramView.this.checkTableViewer.getSelection();
        return IEditAction.super.getCopyTooltip() + " " + Arrays.toString(selection.toArray());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * @see pocs3_service_definitions.IEditAction#canPaste()
     */
    @Override
    public boolean canPaste() {
        return !this.fakeBlockDiagramListClipboard.isEmpty();
    }

    /**
    *
    */
    @Override
    public String getPasteTooltip() {
        return IEditAction.super.getPasteTooltip() + " " + this.fakeBlockDiagramListClipboard;
    }

    /*
     * @see pocs3_service_definitions.IEditAction#paste()
     */
    @Override
    public void paste() {

        // TODO faire un undoRedo operation
        this.blockDiagramList.addAll(this.fakeBlockDiagramListClipboard);
        this.fakeBlockDiagramListClipboard.clear();
        this.checkTableViewer.refresh();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * @see pocs3_service_definitions.IEditAction#canCut()
     */
    @Override
    public boolean canCut() {
        final IStructuredSelection selection = (IStructuredSelection) BlockDiagramView.this.checkTableViewer.getSelection();
        return !selection.isEmpty();
    }

    /*
     * @see pocs3_service_definitions.IEditAction#cut()
     */
    @Override
    public void cut() {
        final IStructuredSelection selection = (IStructuredSelection) BlockDiagramView.this.checkTableViewer.getSelection();
        System.out.println("cutted " + Arrays.toString(selection.toArray()));

        this.fakeBlockDiagramListClipboard.clear();
        for (final Object o : selection.toArray()) {
            this.fakeBlockDiagramListClipboard.add((IBlockDiagram) o);
        }

        // TODO faire un undoRedo operation
        this.blockDiagramList.removeAll(this.fakeBlockDiagramListClipboard);
        this.checkTableViewer.refresh();
    }

    /**
     *
     */
    @Override
    public String getCutTooltip() {
        final IStructuredSelection selection = (IStructuredSelection) BlockDiagramView.this.checkTableViewer.getSelection();
        return IEditAction.super.getCutTooltip() + " " + Arrays.toString(selection.toArray());
    }

}