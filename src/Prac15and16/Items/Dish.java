package Prac15and16.Items;

public final class Dish implements Item {
    private final double price;
    private final String description;
    private final String name;

    public Dish(String name, String description) throws IllegalArgumentException{
        this.name = name;
        this.description = description;
        this.price = 0;
        if (name.equals(""))
            throw new IllegalArgumentException("Имя блюда не может быть пустым");
        if (description.isEmpty())
            throw new IllegalArgumentException("Описание блюда не может быть пустым");
    }

    public Dish(String name, String description, int price) throws IllegalArgumentException{
        this.name = name;
        this.description = description;
        this.price = price;
        if (price < 0)
            throw new IllegalArgumentException("Цена напитка не может быть отрицательной");
        if (name.equals(""))
            throw new IllegalArgumentException("Имя напитка не может быть пустым");
        if (description.isEmpty())
            throw new IllegalArgumentException("Описание напитка не может быть пустым");
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public double getPrice(){
        return price;
    }
}
