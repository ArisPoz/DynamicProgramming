package Part1.File.Type.ImageSubType;

import Part1.File.Type.Image;
import Part1.Visitor.Visitor;

public class Png extends Image {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String print() {
        return "This is a PNG image file";
    }
}
