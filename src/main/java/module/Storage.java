package module;

import java.util.HashMap;

public class Storage {

    /**
     * key
     * loginUserDTO : 현재 로그인 한 회원의 dto
     *
     */

    private static Storage instance = new Storage();

    private HashMap<String, Object> map = new HashMap<>();

    public static Storage getInstance() {
        return instance;
    }

    private Storage() {

    }

    public void addAttribute(String key, Object obj) {
        map.put(key, obj);
    }

    public Object getAttribute(String key) {
        return map.get(key);
    }

}
