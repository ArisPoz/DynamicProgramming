package Part1.File;
import Part1.Visitor.Visitor;

public interface File {
    void accept(Visitor visitor);
    String print();
}
