package Prac11and12.Task1;

public class Person {
    private String surname = "Unknown";
    private String name = "";
    private String patronymic = "";

    public Person(String surname) {
        this.surname = surname;
    }

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Person() {}

    String getFIO(){
        StringBuilder ans = new StringBuilder(surname);
        if(!name.equals("") && patronymic.equals("")){
            ans.append(" " + name.charAt(0) + ".");
            return ans.toString();
        }
        else if(name.equals("") && !patronymic.equals("")){
            ans.append(" " + patronymic.charAt(0) + ".");
            return ans.toString();
        }
        else if(name.equals("") && patronymic.equals(""))
            return ans.toString();
        else{
            ans.append(" " + name.charAt(0) + ".");
            ans.append(patronymic.charAt(0) + ".");
            return ans.toString();
        }
    }
}
