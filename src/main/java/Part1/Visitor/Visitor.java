package Part1.Visitor;

import Part1.File.File;
import Part1.File.Type.ImageSubType.Jpg;
import Part1.File.Type.ImageSubType.Png;
import Part1.File.Type.VideoSubType.Avi;
import Part1.File.Type.VideoSubType.Mp4;
import Part1.File.Type.Image;
import Part1.File.Type.Video;

public interface Visitor {
    void visit(Jpg jpg);
    void visit(Png png);
    void visit(Image imageFile);
    void visit(Mp4 mp4);
    void visit(Avi avi);
    void visit(Video videoFile);
    void visit(File file);
}
