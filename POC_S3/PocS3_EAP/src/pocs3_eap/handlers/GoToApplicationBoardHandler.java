
package pocs3_eap.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;

import pocs3_eap.parts.internal.PocS3EapController;
import pocs3_service_definitions.IProfile;

public class GoToApplicationBoardHandler {
  @Execute
  public void execute(PocS3EapController eapController, IProfile profile) {
    eapController.switchToApplicationBoardPerspective(profile);
  }
}