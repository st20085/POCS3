
package pocs3_ibd.part.handler;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.adapter.Adapter;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import pocs3_ibdmodel.action.IBlockDiagramAction;

/**
 * The class <b>OpenDiagramHandler</b> allows to open diagram
 */
public class OpenDiagramHandler {

    @Inject
    ESelectionService selectionService;

    @CanExecute
    public boolean canExecute(MPart part, Adapter adapter) {
        final Object object = part.getObject();
        System.out.println("OpenDiagramHandler canExecute on view " + object);

        final IBlockDiagramAction blockDiagramAction = adapter.adapt(object, IBlockDiagramAction.class);
        if (blockDiagramAction != null && blockDiagramAction.canOpenBlockDiagrams()) {
            return true;
        }

        return false;
    }

    @Execute
    public void execute(MPart part, Adapter adapter) {

        final Object object = part.getObject();

        final IBlockDiagramAction blockDiagramAction = adapter.adapt(object, IBlockDiagramAction.class);
        if (blockDiagramAction != null) {
            blockDiagramAction.openBlockDiagrams();
        }
    }

}