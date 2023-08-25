package chat.gui.layout.popup.pending;

import chat.gui.components.Modal;
import chat.gui.layout.App;

import java.awt.*;

public class PendingApp implements App {

    private final PendingModel model;
    private final PendingView view;
    private final PendingPresenter presenter;

    private final Modal modal;

    public static void main(String[] args) {
        PendingApp app = new PendingApp();
        app.open();
    }

    public PendingApp() {
        model = new PendingModel();
        view = new PendingView();
        presenter = new PendingPresenter(model, view);

        modal = new Modal(500, 700);
    }

    @Override
    public void open() {
        Container container = modal.getContentPane();
        container.removeAll();
        container.add(view);

        modal.setVisible(true);
    }

    @Override
    public void close() {

    }
}
