package Demo;

/**
 * author: 龚细军
 * class-aim:
 */
public class Orange {

    @FruitName("龚细军")
    private String name;
    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String color;

    public Orange(String name, String color) {
        setName(name);
        setColor(color);
    }

    public Orange() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("Name" + getName() + "Color" + getColor());
    }
}
