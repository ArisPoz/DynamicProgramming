package Part1.File.Type;


import Part1.File.File;
import Part1.Visitor.Visitor;

public class Image implements File {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String print() {
        return "This is an image file";
    }
}
