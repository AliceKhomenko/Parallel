import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args){
        System.out.println(readFile("build/downloads/data.txt"));


    }

    public static String readFile(String path) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
