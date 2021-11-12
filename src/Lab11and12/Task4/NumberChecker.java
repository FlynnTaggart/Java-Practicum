package Lab11and12.Task4;

public class NumberChecker {
    private int countryCode = 0;
    private String firstCode = "";
    private String secondCode = "";
    private String thirdCode = "";
    private String number = "";

    public NumberChecker(String s) {
        parseNumber(s);
    }

    void parseNumber(String s){
        if(s.charAt(0) == '+'){
            countryCode = Character.getNumericValue(s.charAt(1));
            firstCode = s.substring(2, 5);
            secondCode = s.substring(5, 8);
            thirdCode = s.substring(8);
        }
        else{
            countryCode = Character.getNumericValue(s.charAt(0));
            countryCode--;
            firstCode = s.substring(1, 4);
            secondCode = s.substring(4, 7);
            thirdCode = s.substring(7);
        }
        number = "+" + countryCode + firstCode + "-" + secondCode + "-" + thirdCode;
    }

    @Override
    public String toString() {
        return number;
    }
}
