import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args){
        TextContainer textContainer = new TextContainer("I am a string to be saved");
        Class cls = textContainer.getClass();
        Method[] methods = cls.getMethods();

        for (Method method:methods){
            if (method.isAnnotationPresent(Saver.class)){
                SaveTo saveTo = (SaveTo)cls.getAnnotation(SaveTo.class);
                try {
                    method.invoke(textContainer, saveTo.path());
                } catch (IllegalAccessException|InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
