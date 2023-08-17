package chat.gui.layout;

import chat.gui.components.Frame;
import chat.module.SocketManager;

public class MainFrame extends Frame {

    private static MainFrame instance;

    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
        }

        return instance;
    }

    public MainFrame() {

    }

    @Override
    public void dispose() {
        super.dispose();

        SocketManager manager = SocketManager.getInstance();

        if(manager.isStarted()) {
            manager.shutDown();
        }

        instance = null;
    }

}
