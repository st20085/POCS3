
package com.airbus.pocs3_eap.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.airbus.pocS3.definitions.IProfile;
import com.airbus.pocs3_eap.layout.CenterRowLayout;
import com.airbus.pocs3_eap.parts.internal.PocS3EapController;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ApplicationBoardPart {

    @Inject
    private PocS3EapController eapController;

    @Inject
    private MApplication application;

    @Inject
    private EModelService modelService;

    @Inject
    public ApplicationBoardPart() {
    }

    @PostConstruct
    public void postConstruct(Composite parent, IProfile profile) {
        parent.setLayout(new CenterRowLayout());

        this.setProfile(profile, parent);
    }

    @Inject
    private void setProfile(@Optional IProfile profile, Composite parent) {

        if (parent == null || parent.isDisposed()) {
            return;
        }

        // dispose all switch perspective buttons
        for (final Control child : parent.getChildren()) {
            child.dispose();
        }

        if (profile == null) {
            return;
        }

        // recreate switch perspective buttons
        for (final String perspectiveId : profile.getPerspectiveIds()) {
            final MPerspective perspective = (MPerspective) this.modelService.find(perspectiveId, this.application);
            if (perspective != null) {
                this.createSwitchPerspectiveButton(parent, perspective);
            } else {
                this.createNotFoundPerspectiveButton(parent, perspectiveId);
            }

        }
    }

    /**
     * @param parent
     * @param perspectiveId
     */
    private void createNotFoundPerspectiveButton(Composite parent, String perspectiveId) {
        final Button button = new Button(parent, SWT.FLAT);

        button.setToolTipText(perspectiveId);
        button.setText("Not found perspective");
        button.setEnabled(false);

        final RowData rowData = new RowData();
        rowData.width = rowData.height = 100;
        button.setLayoutData(rowData);
    }

    /**
     * @param parent
     * @param perspectiveId
     */
    private void createSwitchPerspectiveButton(Composite parent, MPerspective perspective) {
        final Button button = new Button(parent, SWT.FLAT);

        button.setText(perspective.getLabel());
        button.setToolTipText(perspective.getElementId());

        button.addSelectionListener(new SelectionListener() {
            // String oldLabel;
            // String newLabel;

            @Override
            public void widgetSelected(SelectionEvent e) {
                // go to perspective
                ApplicationBoardPart.this.eapController.switchToApplicationPerspective(perspective);

                // final MWindow window = ApplicationBoardPart.this.partService.getActivePart().getContext().get(MWindow.class);
                // if (this.oldLabel == null || this.newLabel != window.getLabel()) {
                // this.oldLabel = window.getLabel();
                // this.newLabel = this.oldLabel+" : "+perspective.getLabel();
                // } else {
                // this.newLabel = this.oldLabel+" : "+perspective.getLabel();
                // }
                // window.setLabel(newLabel); // TODO marche pas
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {}
        });

        final RowData rowData = new RowData();
        rowData.width = rowData.height = 100;
        button.setLayoutData(rowData);
    }

    @Focus
    public void onFocus() {

    }

}