package Prac15and16.Items;

public final class Drink implements Item, Alcoholable {
    private final double price;
    private final String description;
    private final String name;
    private final DrinkTypeEnum type;

    public Drink(String name, String description, DrinkTypeEnum type) throws IllegalArgumentException{
        this.name = name;
        this.description = description;
        this.price = 0;
        this.type = type;
        if (name.equals(""))
            throw new IllegalArgumentException("Имя блюда не может быть пустым");
        if (description.isEmpty())
            throw new IllegalArgumentException("Описание блюда не может быть пустым");
    }

    public Drink(String name, String description, int price, DrinkTypeEnum type) throws IllegalArgumentException{
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
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

    @Override
    public boolean isAlcoholicDrink() {
        return type.getAlcoholVol() > 0;
    }

    @Override
    public double getAlcoholVol() {
        return type.getAlcoholVol();
    }
}
