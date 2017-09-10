
package pocs3_eap.parts;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import pocs3_eap.parts.internal.PocS3EapController;

public class HomeControl {
    @Inject
    private PocS3EapController eapController;

    private ResourceManager resManager;

    @PostConstruct
    public void createGui(Composite parent) {
        final Composite comp = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.marginWidth = layout.marginHeight = 0;
        comp.setLayout(layout);

        final Button homeButton = new Button(comp, SWT.FLAT);
        // homeButton.setVisible(false);
        homeButton.setLayoutData(GridDataFactory.fillDefaults()
            .hint(20, 20)// .minSize(20, 20)
            .grab(false, false)
            .create());
        homeButton.setToolTipText("Profile Perspective");
        final ImageDescriptor imageDescriptor =
            AbstractUIPlugin.imageDescriptorFromPlugin(PocS3_Constants.POCS3_EAP_PLUGIN_ID, "icons/home_perspective.png");
        resManager = new LocalResourceManager(JFaceResources.getResources(), comp);
        final Image image = resManager.createImage(imageDescriptor);
        homeButton.setImage(image);
        homeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                HomeControl.this.eapController.switchToProfilePerspective();
            }
        });

        this.eapController.switchToProfilePerspective();
    }

    @PreDestroy
    private void dispose() {
      if (resManager != null)
        resManager.dispose();
    }

    // /**
    // * Set profile
    // *
    // * @param profile
    // */
    // @Inject
    // void setProfile(@Optional IProfile profile) {
    // //
    // final MUIElement pocS3_TrimbarTop = HomeControl.this.modelService.find(PocS3_Constants.POCS3_TRIMBAR_TOP, HomeControl.this.application);
    // pocS3_TrimbarTop.setVisible(profile != null);
    //
    // // set visible home button
    // if (homeButton != null && !homeButton.isDisposed()) {
    // homeButton.setVisible(profile != null);
    // }
    // }
}