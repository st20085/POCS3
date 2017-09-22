
package pocs3_ibd.part.application_module;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;

import pocs3_ibd.part.ApplicationModuleView;

public class CreateApplicationModuleHandler {
	@Execute
	public void execute(MPart part, Shell shell) {
	  ApplicationModuleView applicationModuleView = (ApplicationModuleView) part.getObject();

	  final InputDialog inputDialog = new InputDialog(shell, "Example", "Enter an application module name", "Module n°"+System.currentTimeMillis()%100, null);
    if (inputDialog.open() == InputDialog.OK) {
        final String applicationModuleName = inputDialog.getValue();
        applicationModuleView.createNewApplicationModule(applicationModuleName);
    }
	}

}