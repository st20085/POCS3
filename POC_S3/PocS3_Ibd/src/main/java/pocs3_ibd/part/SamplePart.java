
package pocs3_ibd.part;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import pocs3_ibdmodel.IbdModel;

public class SamplePart {
    @Inject
    IbdModel ibdModel;

    private Text txtInput;
    private TableViewer tableViewer;

    @Inject
    private MDirtyable dirty;

    // @Inject
    // ESelectionService selectionService;

    @PostConstruct
    public void createComposite(Composite parent) {
        final GridLayout layout = new GridLayout(1, false);
        layout.marginWidth = layout.marginHeight = 0;
        parent.setLayout(layout);

        this.txtInput = new Text(parent, SWT.BORDER);
        this.txtInput.setMessage("Enter text to mark part as dirty");
        this.txtInput.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                SamplePart.this.dirty.setDirty(true);
            }
        });
        this.txtInput.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        this.tableViewer = new TableViewer(parent);

        this.tableViewer.setContentProvider(ArrayContentProvider.getInstance());

        this.tableViewer.setInput(this.createInitialDataModel());
        this.tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));

//        new Label(parent, SWT.None).setText("commonModel=" + this.ibdModel.getCommonModel());
//        new Label(parent, SWT.None).setText("ibdModel=" + this.ibdModel);

        // //
        // this.tableViewer.addSelectionChangedListener(event -> {
        // final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        //
        // System.out.println("setSelection in thread " + Thread.currentThread());
        //
        // // set the selection to the service
        // this.setSelection(selection.toArray());
        // });
    }

    // private void setSelection(Object o) {
    // // this.context.set(IServiceConstants.ACTIVE_SELECTION, o);
    // this.selectionService.setSelection(o);
    // }

    @Focus
    private void setFocus() {
        // System.out.println(" setFocus");
        this.tableViewer.getControl().setFocus();

        // final IStructuredSelection selection = (IStructuredSelection) this.tableViewer.getSelection();
        // this.setSelection(selection.toArray());
    }

    @Persist
    public void save(IProgressMonitor progressMonitor) {
        System.out.println("progressMonitor " + progressMonitor);
        this.dirty.setDirty(false);
    }

    private List<String> createInitialDataModel() {
        return Arrays.asList("Sample item 1", "Sample item 2", "Sample item 3", "Sample item 4", "Sample item 5");
    }
}