
package pocs3_eap.handlers;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class DeltaInfoOperation extends AbstractOperation {

    public DeltaInfoOperation() {
        super("Delta Operation");
    }

    @Override
    public IStatus execute(IProgressMonitor monitor, IAdaptable info) {

        final Job job = new Job("job DeltaInfoOperation") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                System.out.println(Thread.currentThread());
                try {
                    monitor.beginTask("run", 10);
                    for (int i = 0; i < 10; i++) {
                        System.out.println("work "+i);
                        Thread.sleep(1000);
                        monitor.worked(i);
                    }
                } catch (final InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.err.println("DeltaInfoOperation execute");
                return Status.OK_STATUS;
            }
        };
        job.schedule();


        return Status.OK_STATUS;
    }

    @Override
    public IStatus undo(IProgressMonitor monitor, IAdaptable info) {
        System.err.println("DeltaInfoOperation undo");
        return Status.OK_STATUS;
    }

    @Override
    public IStatus redo(IProgressMonitor monitor, IAdaptable info) {
        System.err.println("DeltaInfoOperation redo");
        return Status.OK_STATUS;
    }
}