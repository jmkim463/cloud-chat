package chat.module;

import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    public final static String LOGIN_USER = "loginUser";

    private static Storage instance;

    private final ConcurrentHashMap<String, Object> dataMap;

    public static Storage getInstance() {
        if(instance == null) {
            instance = new Storage();
        }

        return instance;
    }

    private Storage() {
        dataMap = new ConcurrentHashMap<>();
    }

    public void setData(String key, Object object) {
        dataMap.put(key, object);
    }

    public Object getData(String key) {
        return dataMap.get(key);
    }

    public Object removeData(String key) {
        return dataMap.remove(key);
    }

}
