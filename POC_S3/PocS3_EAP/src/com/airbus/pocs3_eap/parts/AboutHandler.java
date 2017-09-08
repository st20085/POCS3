package com.airbus.pocs3_eap.parts;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class AboutHandler {
	@Execute
	public void execute(Shell shell) {
//	    new InstallNewSoftwareHandler().execute(null);
		MessageDialog.openInformation(shell, "About", "POC S3 Application");
	}
}
