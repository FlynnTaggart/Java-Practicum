package Prac15and16.Exceptions;

public class EmptyOrderException extends Exception{
    public EmptyOrderException(String message){
        super(message);
    }
}
