
package pocs3_eap.handlers;

import org.eclipse.e4.core.di.annotations.Execute;

import pocs3_eap.parts.internal.PocS3EapController;

public class GoToProfilePerspectiveHandler {
  @Execute
  public void execute(PocS3EapController eapController) {
      eapController.switchToProfilePerspective();
  }

}