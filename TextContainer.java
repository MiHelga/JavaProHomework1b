import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path="c:\\file.txt")
public class TextContainer {
    public String text;
    public TextContainer(String text){
        this.text=text;
    }

    @Saver
    public void save (String path){
        try (FileWriter writer = new FileWriter(path)){
            writer.write(text);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
