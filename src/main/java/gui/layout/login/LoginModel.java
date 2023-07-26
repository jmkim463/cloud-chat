package gui.layout.login;

import gui.mvc.Model;

public class LoginModel implements Model {

    private String id;
    private String password;

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserNo() {
        if("test01".equals(getId()) && "test01".equals(getPassword())) {
            return 1;
        }

        return null;
    }
}
