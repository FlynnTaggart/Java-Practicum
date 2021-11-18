package Prac11and12.Task2;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address();
        address1.parseAddress("Russia  , Moscow,Moscow, Vernadskogo, 78, a, IVC-104");
        System.out.println(address1);
        Address address2 = new Address();
        address2.parseAddressDelim("Russia  , Kalinigradskay Oblast; Zelenogradsk, Lenin. 11, b; 2");
        System.out.println(address2);
        Address address3 = new Address();
        address3.parseAddress("awd  , awd,Moscow, awd, qsd1234, 12312, asdasd");
        System.out.println(address3);
        Address address4 = new Address();
        address4.parseAddressDelim("asd  , Moscoasdw      ;  asd; asd, sdf78, asdf. IVCsdf-104");
        System.out.println(address4);
    }
}
