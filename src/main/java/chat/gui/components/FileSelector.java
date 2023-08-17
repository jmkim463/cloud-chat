package chat.gui.components;

import java.awt.*;
import java.awt.Frame;

public class FileSelector implements AutoCloseable {

    private Frame frame = new Frame();
    private FileDialog dialog = new FileDialog(frame, "File Selector");

    private int mode = FileDialog.LOAD;

    public FileSelector() {
        init();
    }

    public FileSelector(int mode) {
        this.mode = mode;
        init();
    }

    private void init() {
        frame.setSize(500, 200);
        frame.setFont(new Font());
        frame.setLocationRelativeTo(null);

        dialog.setMode(mode);
        dialog.setFont(new Font());
        dialog.setDirectory("C:\\");
    }

    public void show() {
        dialog.setVisible(true);
    }

    public String getFileName() {
        return dialog.getFile();
    }

    public String getPath() {
        if(dialog.getDirectory() == null || dialog.getFile() == null) {
            return null;
        }

        return dialog.getDirectory() + dialog.getFile();
    }

    public String getDirectory() {
        return dialog.getDirectory();
    }

    @Override
    public void close() throws Exception {
        frame.dispose();
        dialog.dispose();
    }
}
