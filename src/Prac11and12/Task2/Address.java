package Prac11and12.Task2;

import java.util.List;
import java.util.StringTokenizer;

public class Address {
    private String country = "";
    private String region = "";
    private String city = "";
    private String street = "";
    private String house = "";
    private String building = "";
    private String flat = "";

    void parseAddress(String s){
        List<String> addressList = List.of(s.split("\\s*,\\s*"));
        country = addressList.get(0);
        region = addressList.get(1);
        city = addressList.get(2);
        street = addressList.get(3);
        house = addressList.get(4);
        building = addressList.get(5);
        flat = addressList.get(6);
    }

    void parseAddressDelim(String s){
        StringTokenizer st = new StringTokenizer(s, ",.;");
        country = st.nextToken().trim();
        region = st.nextToken().trim();
        city = st.nextToken().trim();
        street = st.nextToken().trim();
        house = st.nextToken().trim();
        building = st.nextToken().trim();
        flat = st.nextToken().trim();
    }

    @Override
    public String toString() {
        return country + ", " +
                region + ", " +
                city + ", " +
                street + ", " +
                house + ", " +
                flat;
    }
}
