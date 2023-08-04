package module.session;

import gui.utils.ImageUtils;
import module.dto.UserDTO;

import javax.swing.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

public class Session {

    private static Session instance = new Session();

    private HashMap<String, Object> map = new HashMap<>();

    public static Session getInstance() {
        return instance;
    }

    public void addAttribute(String key, Object obj) {
        map.put(key, obj);
    }

    public Object getAttribute(String key) {
        return map.get(key);
    }

}
