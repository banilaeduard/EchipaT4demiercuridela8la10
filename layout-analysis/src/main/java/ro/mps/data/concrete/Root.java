package ro.mps.data.concrete;

import ro.mps.data.api.HasPosition;
import ro.mps.data.base.OrphanCompoundNode;
import java.util.LinkedList;
import java.util.List;

public class Root extends OrphanCompoundNode<Block> {

    private String imageName;
    private String direction;


    public String getImageName() {
        return imageName;
    }

    public String getDirection() {
        return direction;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Root(int width, int height) {
        super("Document", 0, 0, height, width);
    }

    /**
     * Returns text from paragraphs
     * @return - returns a list of text from paragraph
     */
    public List<String> getTextFromParagraphs() {
        List<String> textFromParagraphs = new LinkedList<String>();

        for ( Block block : getChildren() ) {
            textFromParagraphs.add(block.getTextFromParagraph());
        }

        return textFromParagraphs;
    }

    /**
     * Returns text from lines
     * @return - returns a list of text from paragraph
     */
    public List<String> getTextFromLines() {
        List<String> textFromLines = new LinkedList<String>();

        for ( Block block : getChildren() ) {
            for ( Line line : block.getChildren() ) {
                textFromLines.add(line.getContent());
            }
        }

        return textFromLines;
    }

    /**
     * Returns the line contained in the tree
     * @return - returns a list of lines contained in the tree
     */
    public List<Line> getLines() {
        List<Line> lines = new LinkedList<Line>();

        for ( Block block : getChildren() ) {
            lines.addAll(block.getChildren());
        }

        return lines;
    }

    @Override
    public String toString() {
        final String TEMPLATE = "**ROOT**\n" +
                "\tx = %d\n" +
                "\ty = %d\n" +
                "\tWidth = %d\n" +
                "\tHeight = %d\n";

        String result = String.format(TEMPLATE, getLeftUpperCornerX(), getLeftUpperCornerY(), getHeight(), getWidth());

        for ( Block block : getChildren() ) {
            result += block.toString();
        }

        return result;
    }
}
