package no.iterate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    public void sayHello(String name, String name2) {
        System.out.println("Hello, " + name + " and " + name2);
    }

    public void sayHello(List<String> names) {
        for(String name : names) {
            System.out.println("Hello, " + name);
        }
    }
}
