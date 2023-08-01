package gui;

import gui.layout.login.LoginController;

public class Main {

    public static void main(String[] args) {

        LoginController controller = new LoginController();
        controller.getView().open();

    }
}
