package chat.gui.layout.sidebar;

public class SideBar {

    private final SideBarModel model;
    private final SideBarView view;
    private final SideBarPresenter presenter;

    public SideBar() {
        model = new SideBarModel();
        view = new SideBarView();
        presenter = new SideBarPresenter(model, view);

        init();
    }

    private void init() {
        view.getLogoutIcon().addClickListener(e -> presenter.logout());
        view.getPersonIcon().addClickListener(e -> presenter.openFriendLayout());
        view.getChatIcon().addClickListener(e -> presenter.openChatLayout());
    }

    public SideBarView getView() {
        return view;
    }
}
