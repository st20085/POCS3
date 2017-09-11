
package pocs3_eap.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;

import pocs3_eap.parts.internal.PocS3EapController;

public class GoToProfilePerspectiveHandler {
  @Inject
  private PocS3EapController eapController;

  @Execute
  public void execute() {
    this.eapController.switchToProfilePerspective();
  }

}