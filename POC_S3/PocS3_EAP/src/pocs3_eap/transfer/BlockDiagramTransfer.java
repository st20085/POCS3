package pocs3_eap.transfer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TransferData;

import pocs3_service_definitions.IBlocDiagramService;
import pocs3_service_definitions.IBlockDiagram;


/**
 * The class <b>BlockDiagramTransfer</b> allows to transfer block diagram
 */
public class BlockDiagramTransfer extends ByteArrayTransfer {

    private static final String BLOCK_DIAGRAM_NAME = "BlockDiagram"; //$NON-NLS-1$

    private static final int BLOCK_DIAGRAM_TYPE_ID = registerType(BLOCK_DIAGRAM_NAME);

    private static final BlockDiagramTransfer INSTANCE = new BlockDiagramTransfer();

    /**
     * Return instance
     */
    public static BlockDiagramTransfer getInstance() {
        return INSTANCE;
    }

    private BlockDiagramTransfer() {}

    @Override
    public void javaToNative(Object object, TransferData transferData) {
        if (!this.checkBlockDiagram(object) || !this.isSupportedType(transferData)) {
            DND.error(DND.ERROR_INVALID_DATA);
        }

        final IBlockDiagram[] blockDiagrams = (IBlockDiagram[]) object;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             DataOutputStream writeOut = new DataOutputStream(out)) {

            // write blockDiagrams length
            writeOut.writeInt(blockDiagrams.length);

            // write blockDiagrams list
            for (final IBlockDiagram blockDiagram : blockDiagrams) {
                // write blockDiagram
                writeBlockDiagram(writeOut, blockDiagram);
            }

            // write to native
            final byte[] buffer = out.toByteArray();
            super.javaToNative(buffer, transferData);
        } catch (final IOException e) {
        }
    }

    /**
     * Write block diagram
     *
     * @param writeOut
     * @param blockDiagram
     * @throws IOException
     */
    private static void writeBlockDiagram(final DataOutputStream writeOut, final IBlockDiagram blockDiagram) throws IOException {
        writeOut.writeUTF(blockDiagram.getName());
    }

    @Override
    public Object nativeToJava(TransferData transferData) {
        if (this.isSupportedType(transferData)) {

            // read from native
            final byte[] buffer = (byte[]) super.nativeToJava(transferData);
            if (buffer == null) {
                return null;
            }

            IBlockDiagram[] blockDiagrams;
            try (ByteArrayInputStream in = new ByteArrayInputStream(buffer);
                DataInputStream readIn = new DataInputStream(in)) {

                // read blockDiagrams length
                final int blockDiagramLength = readIn.readInt();
                blockDiagrams = new IBlockDiagram[blockDiagramLength];

                int index = 0;
                while (readIn.available() != 0) {
                    // read blockDiagram
                    final IBlockDiagram blockDiagram = readBlockDiagram(readIn);
                    blockDiagrams[index++] = blockDiagram;
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return blockDiagrams;
        }

        return null;
    }

    /**
     * Read block diagram
     *
     * @param writeOut
     * @throws IOException
     */
    private static IBlockDiagram readBlockDiagram(DataInputStream readIn) throws IOException {
        final String blockDiagramName = readIn.readUTF();

        // create new block diagram
        final IEclipseContext eclipseCtx = E4Workbench.getServiceContext();
        final IEclipseContext activeEclipseCtx = eclipseCtx.getActiveLeaf();
        final IBlocDiagramService blocDiagramService = activeEclipseCtx.get(IBlocDiagramService.class);
        final IBlockDiagram blockDiagram = blocDiagramService.createNewBlockDiagram(blockDiagramName);

        return blockDiagram;
    }

    @Override
    protected String[] getTypeNames() {
        return new String[] {BLOCK_DIAGRAM_NAME};
    }

    @Override
    protected int[] getTypeIds() {
        return new int[] {BLOCK_DIAGRAM_TYPE_ID};
    }

    boolean checkBlockDiagram(Object object) {
        if (object == null || !(object instanceof IBlockDiagram[])
            || ((IBlockDiagram[]) object).length == 0) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean validate(Object object) {
        return this.checkBlockDiagram(object);
    }
}
