import Part1.File.File;
import Part1.File.Type.Image;
import Part1.File.Type.ImageSubType.Png;
import Part1.File.Type.VideoSubType.Avi;
import Part1.File.Type.VideoSubType.Mp4;
import Part1.File.TypeHandler;
import Part1.Visitor.Visitor;

import java.lang.reflect.Proxy;

public class DynamicProxyMain {
    public static class Text extends Image {

    }

    public static void main(String[] args) {
        System.out.println("Part1.Visitor with Dynamic proxy");
        System.out.println("------------------------------------------------");
        File file = new Mp4();
        File file1 = new Avi();
        File file2 = new Png();

        Class[] interfaces = new Class[1];
        interfaces[0] = Visitor.class;
        Visitor proxy = (Visitor) Proxy.newProxyInstance(DynamicProxyMain.class.getClassLoader(), interfaces, new TypeHandler());
        proxy.visit(file);
        proxy.visit(file1);
        proxy.visit(file2);
    }
}
