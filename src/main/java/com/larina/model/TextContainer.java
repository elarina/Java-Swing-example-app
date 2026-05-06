package main.java.com.larina.model;

public class TextContainer {
    private String text;
    private boolean isBold;
    private boolean isItalic;
    private boolean isCentered;

    public TextContainer(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isBold() {
        return isBold;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }

    public boolean isCentered() {
        return isCentered;
    }

    public void setCentered(boolean centered) {
        isCentered = centered;
    }

    public boolean isItalic() {
        return isItalic;
    }

    public void setItalic(boolean italic) {
        isItalic = italic;
    }
}
