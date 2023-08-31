package test;

import chat.gui.components.FileSelector;
import chat.gui.layout.chat.ChatModel;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.UUID;

public class LogicTest {

    @Test
    void test() {
        System.out.println(UUID.randomUUID());
    }

    @Test
    void image() {
        try(FileSelector selector = new FileSelector()) {
            selector.show();

            String path = selector.getPath();
            String name = selector.getFile();

            if(path == null) {
                return;
            }

            if(!(name.endsWith(".jpg") || name.endsWith(".png"))) {
                return;
            }

            ChatModel model = new ChatModel();

            String content = model.uploadImage(new File(path));
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
