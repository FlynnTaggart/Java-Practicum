package Prac9;

public class Checker {
    String fullName = "";
    String INN = "";

    public Checker(String fullName, String INN) throws InvalidINNException {
        if(checkINN(INN))
            this.INN = INN;
        this.fullName = fullName;
    }

    public Checker() {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getINN() {
        return INN;
    }

    public Checker(String fullName) {
        this.fullName = fullName;
    }

    boolean checkINN(String INN) throws InvalidINNException{
        if(INN.length() != 10 && INN.length() != 12)
            throw new InvalidINNException("Wrong INN length");
        for(int i = 0; i < INN.length(); ++i)
            if(INN.charAt(i) < '0' || INN.charAt(i) > '9')
                throw new InvalidINNException("Wrong INN character");
        return true;
    }

    void enterINN(String INN) throws InvalidINNException{
        if(checkINN(INN))
            this.INN = INN;
    }
}
