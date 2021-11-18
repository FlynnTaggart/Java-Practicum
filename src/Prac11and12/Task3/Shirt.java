package Prac11and12.Task3;

import java.util.List;

public class Shirt {
    private String serial = "";
    private String name  = "";
    private String color = "";
    private String size = "";

    public Shirt(String s) {
        parseShirt(s);
    }

    void parseShirt(String s){
        List<String> addressList = List.of(s.split("\\s*,\\s*"));
        serial = addressList.get(0);
        name   = addressList.get(1);
        color  = addressList.get(2);
        size  = addressList.get(3);
    }

    @Override
    public String toString() {
        return "serial: " + serial + '\n' +
                "name: " + name + '\n' +
                "color: " + color + '\n' +
                "size: " + size + '\n';
    }
}
