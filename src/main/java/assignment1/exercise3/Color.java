package assignment1.exercise3;

public class Color {
    private String color;
    private String value;

    public Color() {
    }

    public Color(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Color{" +
                "color='" + color + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }
}
