package gui.layout.account.view;

import gui.components.Modal;
import gui.components.Panel;
import gui.mvc.View;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;

import java.awt.*;

public class AccountView extends Modal implements View {

    public AccountView() {
        super(380, 700);

        init();
    }

    private void init() {
        Panel panel = new Panel(new BorderLayout());

        panel.add(new UserImage(), BorderLayout.NORTH);
        panel.add(new AccountField());

        add(panel.cover());
    }

    @Override
    public void open() {
        setVisible(true);
    }

    @Override
    public void close() {
        dispose();
    }
}
