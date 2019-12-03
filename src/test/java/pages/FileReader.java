package pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public  class FileReader {
    public static String readFile(String path) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.replaceAll("\n", "");
    }
}
