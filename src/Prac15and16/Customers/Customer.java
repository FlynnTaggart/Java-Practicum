package Prac15and16.Customers;

public final class Customer {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;
    static private Customer MATURE_UNKNOWN_CUSTOMER;
    static private Customer NOT_MATURE_UNKNOWN_CUSTOMER;

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
