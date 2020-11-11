package Part1.File.Type.VideoSubType;

import Part1.File.Type.Video;
import Part1.Visitor.Visitor;

public class Mp4 extends Video {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String print() {
        return "This is a Mp4 video file";
    }
}
