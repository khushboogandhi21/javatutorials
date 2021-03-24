import java.util.Optional;

/**
 * It can help in writing a neat code without using too many null checks.
 * By using Optional, we can specify alternate values to return or alternate code to run.
 */
public class OptionalDemo {

    public static void main(String[] args){
        //3 ways to create Optional via static factory methods
        Optional<String> strOpt = Optional.empty(); //empty
        // returns java.util.NoSuchElementException: No value present
        // System.out.println("result = " + strOpt.get());
        System.out.println("1 result = " + strOpt.isPresent());


        strOpt = Optional.of("TestStr"); // non null value throws null pointer exception if value is null
        System.out.println("2 result = " + strOpt.get());
        System.out.println("2 result = " + strOpt.isPresent());

        strOpt = Optional.ofNullable("TestStr"); //value may be null
        System.out.println("3 result = " + strOpt.get());
        System.out.println("3 result = " + strOpt.isPresent());
    }
}
