
package pocs3_l3d.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

import pocs3_l3d.L3d_Constants;

public class OpenL3dHandler {
    final static String SATELLITE_ICON_URI = "platform:/plugin/PocS3_l3d/icons/satellite_icon.png";

    MTrimmedWindow trimmedWindow;

	@Execute
	public void execute(EPartService partService, EModelService modelService, MApplication application) {

	    // find L3D perspective
        final MUIElement perspectiveUIElement = modelService.find(L3d_Constants.L3D_PERSPECTIVE_ID, application);
//        System.out.println(perspectiveUIElement);

        if (perspectiveUIElement != null) {
//            final MPerspective l3dPerspective = (MPerspective) perspectiveUIElement;

            // clone perspective
            final MPerspective clonePerspective = (MPerspective) modelService.cloneElement(perspectiveUIElement, null);
//            System.out.println(clonePerspective);

            // clone toolbar
            final MUIElement toolbarUIElement = modelService.find(L3d_Constants.L3D_TOOLBAR_ID, application);
            final MToolBar cloneToolbar = (MToolBar) modelService.cloneElement(toolbarUIElement, null);
            cloneToolbar.setToBeRendered(true);
//            System.out.println(cloneToolbar);

            //
            final MWindow selectedWindow = application.getSelectedElement();
//            System.out.println("selectedWindow "+selectedWindow);

            // create
            this.trimmedWindow = modelService.createModelElement(MTrimmedWindow.class);
            this.trimmedWindow.setToBeRendered(false);
//            trimmedWindow.setVisible(false);
            this.trimmedWindow.setLabel("L3D editor");
            this.trimmedWindow.setWidth(640);
            this.trimmedWindow.setHeight(480);
            this.trimmedWindow.setX(selectedWindow.getX()+selectedWindow.getWidth());
            this.trimmedWindow.setY(selectedWindow.getY());
            this.trimmedWindow.setIconURI(SATELLITE_ICON_URI);
            application.getChildren().add(this.trimmedWindow);

            // create perspective stack
            final MPerspectiveStack perspectiveStack = modelService.createModelElement(MPerspectiveStack.class);
            this.trimmedWindow.getChildren().add(perspectiveStack);

            // add perspective to perspective stack
            perspectiveStack.getChildren().add(clonePerspective);

            // create trimbar and add cloned toolbar
            final MTrimBar trimBar = modelService.createModelElement(MTrimBar.class);
            this.trimmedWindow.getTrimBars().add(trimBar);
            trimBar.getChildren().add(cloneToolbar);


            this.trimmedWindow.setToBeRendered(true);
//            trimmedWindow.setVisible(true);
        }
	}


	@CanExecute
	public boolean canExecute() {
	    //
		return this.trimmedWindow == null || this.trimmedWindow.getWidget() == null;
	}

}