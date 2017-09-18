
package pocs3_eap.parts;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

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

import pocs3_eap.layout.CenterRowLayout;
import pocs3_eap.parts.internal.PocS3EapController;
import pocs3_service_definitions.IApplication;
import pocs3_service_definitions.IProfile;

public class ApplicationBoardPart {

  @Inject
  private PocS3EapController eapController;

  @Inject
  private MApplication application;

  @Inject
  private EModelService modelService;

  @Inject
  public ApplicationBoardPart() {}

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

    final List<MPerspective> perspectiveList = this.modelService.findElements(this.application, null, MPerspective.class, null);

    // recreate switch perspective buttons
    for (final IApplication application : profile.getApplications()) {
      // find perspective

      final java.util.Optional<MPerspective> opt = perspectiveList.stream().filter(perspective -> application.getName().equals(perspective.getLabel())).findFirst();
      if (opt.isPresent()) {
        final MPerspective perspective = opt.get();
        this.createSwitchPerspectiveButton(parent, application, perspective);
      } else {
        // this.createNotFoundPerspectiveButton(parent, application);
      }

    }
  }

  /**
   * @param parent
   * @param application
   */
  private void createNotFoundPerspectiveButton(Composite parent, IApplication application) {
    final Button button = new Button(parent, SWT.FLAT);

    button.setText(application.getName());
    button.setToolTipText("Cannot found perspective=" + application.getName());
    button.setEnabled(false);

    final RowData rowData = new RowData();
    rowData.width = rowData.height = 100;
    button.setLayoutData(rowData);
  }

  /**
   * @param parent
   * @param application
   */
  private void createSwitchPerspectiveButton(Composite parent, IApplication application, MPerspective perspective) {
    final Button button = new Button(parent, SWT.FLAT);

    button.setText(application.getName());
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
  public void onFocus(Composite parent) {
      final Control[] children = parent.getChildren();
      if (children != null && children.length > 0) {
        children[0].setFocus();
    }
  }

}