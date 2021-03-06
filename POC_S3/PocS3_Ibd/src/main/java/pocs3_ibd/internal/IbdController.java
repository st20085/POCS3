// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package pocs3_ibd.internal;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import pocs3_ibd.Ibd_Constants;

/**
 *
 */
@Creatable
@Singleton
public class IbdController {
    @Inject
    private MApplication application;

    @Inject
    private EModelService modelService;

    // @Inject
    // private EPartService partService;

    /**
     * Change Ibd toolbar renderer
     *
     * @param renderer
     */
    public void changeIbdToolbarRenderer(boolean renderer) {
        //
        final MUIElement ibd_toolbar = this.modelService.find(Ibd_Constants.IBD_TOOLBAR_ID, this.application);
        if (ibd_toolbar != null) {
//            System.err.println("TEMPORAIRE active ibd_toolbar");
            ibd_toolbar.setToBeRendered(renderer);
        } else {
            System.err.println("Cannot found ibd_toolbar");
        }
    }


}
