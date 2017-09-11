
package pocs3_ibd.part.handler;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

/**
 * The class <b>NewDiagramHandler</b> allows to create new diagram
 */
public class NewDiagramHandler {
    @Execute
    public void execute() {
        System.out.println("NEW DIAGRAM");
    }

    @CanExecute
    public boolean canExecute() {

        return true;
    }

}