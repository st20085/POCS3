import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

import pocs3_emf.BlockUnit;
import pocs3_emf.Pocs3_emfFactory;
import pocs3_emf.Pocs3_emfPackage;
import pocs3_emf.ThermalUnit;
import pocs3_emf.util.Pocs3_emfAdapterFactory;

/**
 * The class <b>Main</b> allows to.<br>
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Pocs3_emfFactory factory = Pocs3_emfFactory.eINSTANCE;

    ThermalUnit thermalUnit = factory.createThermalUnit();
    thermalUnit.setName("thermalUnit");


    BlockUnit blockUnit1 = factory.createBlockUnit();
    blockUnit1.setName("blockUnit1");
    thermalUnit.getBlockUnit().add(blockUnit1);

    BlockUnit blockUnit2 = factory.createBlockUnit();
    blockUnit2.setName("blockUnit2");
    thermalUnit.getBlockUnit().add(blockUnit2);

    System.out.println(thermalUnit.getName());
    System.out.println(blockUnit1.getName());

    blockUnit1.generate();

    //
    BasicCommandStack commandStack = new BasicCommandStack();

    ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(); // new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    adapterFactory.addAdapterFactory(new Pocs3_emfAdapterFactory());

    AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);

    //
    Command setCommand = SetCommand.create(editingDomain, blockUnit1, Pocs3_emfPackage.Literals.BLOCK_UNIT__NAME, "blockUnit1_bis");
    editingDomain.getCommandStack().execute(setCommand);

    System.out.println(blockUnit1.getName());

    // UNDO
    System.out.println(commandStack.canUndo());
    commandStack.undo();
    System.out.println(blockUnit1.getName());

    // REDO
    System.out.println(commandStack.canRedo());
    commandStack.redo();
    System.out.println(blockUnit1.getName());

  }

}
