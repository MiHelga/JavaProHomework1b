import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path="c:\\file.txt")
public class TextContainer {
    private String text;
    public TextContainer(String text){
        this.text=text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
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
