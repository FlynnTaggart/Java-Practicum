package Prac15and16.Exceptions;

public class OrderAlreadyAddedException extends Exception{
    public OrderAlreadyAddedException(String message){
        super(message);
    }
}
