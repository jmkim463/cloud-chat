package gui.components;

public class Font extends java.awt.Font {
    private static final String NAME = "나눔고딕";
    private static final int STYLE = 0;
    private static final int SIZE = 15;

    public Font() {
        this(NAME, STYLE, SIZE);
    }

    public Font(int size) {
        super(NAME, STYLE, size);
    }

    public Font(int style, int size) {
        super(NAME, style, size);
    }

    public Font(String name, int style, int size) {
        super(name, style, size);
    }

}
