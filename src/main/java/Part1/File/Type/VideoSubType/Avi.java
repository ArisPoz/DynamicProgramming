package Part1.File.Type.VideoSubType;

import Part1.File.Type.Video;
import Part1.Visitor.Visitor;

public class Avi extends Video {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String print() {
        return "This is an Avi video file";
    }
}
