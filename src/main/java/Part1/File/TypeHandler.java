package Part1.File;

import Part1.File.Type.Image;
import Part1.File.Type.ImageSubType.Jpg;
import Part1.File.Type.ImageSubType.Png;
import Part1.File.Type.VideoSubType.Avi;
import Part1.File.Type.VideoSubType.Mp4;
import Part1.File.Type.Video;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TypeHandler implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (1 != args.length) throw new IllegalArgumentException();

        Object obj = args[0];

        if (obj instanceof Jpg) {
            System.out.println("This is an JPG image file");
            return ((Jpg) obj).print();
        } else if (obj instanceof Png) {
            System.out.println("This is a Png image file");
            return ((Png) obj).print();
        } else if (obj instanceof Mp4) {
            System.out.println("This is a MP4 video file");
            return ((Mp4) obj).print();
        } else if (obj instanceof Avi) {
            System.out.println("This is an AVI video file");
            return ((Avi) obj).print();
        } else if (obj instanceof Image) {
            System.out.println("This is an image file");
            return ((Image) obj).print();
        } else if (obj instanceof Video) {
            System.out.println("This is a video file");
            return ((Video) obj).print();
        } else {
            return "This is not a supported file";
        }
    }
}
