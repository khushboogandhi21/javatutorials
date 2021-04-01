import java.util.Optional;

/**
 * It can help in writing a neat code without using too many null checks.
 * By using Optional, we can specify alternate values to return or alternate code to run
 * if value returned from a piece of code/method is null.
 *
 * The intent of Java when releasing Optional was to use it as a return type,
 * thus indicating that a method could return an empty value.
 * As a matter of fact, the practice of using Optional as a method parameter or Field Type  is even DISCOURAGED by some code inspectors. see section  15 baeldung
 * coz the arg[of Optional type] passed can be null resulting in null pointer exception
 *
 * using Optional in a serializable class will result in a NotSerializableException.
 */
public class OptionalDemo {

    public static void main(String[] args){
        //3 ways to create Optional via static factory methods
        Optional<String> strOpt = Optional.empty(); //empty
        // returns java.util.NoSuchElementException: No value present
        // System.out.println("result = " + strOpt.get());
        System.out.println("1 result isPresent= " + strOpt.isPresent());
        // System.out.println("1 result isEmpty= " + strOpt.isEmpty()); //Introduced in java 11

        // In reality "TestSTr" will be some value returned from some code which we can check for nul by wrapping it in Optional Object
        strOpt = Optional.of("TestStr"); // non null value throws null pointer exception if value is null
        System.out.println("2 result = " + strOpt.get());
        System.out.println("2 result isPresent= " + strOpt.isPresent());

        //If value present do something
        strOpt.ifPresent(name -> System.out.println("length = " + name.length())); //consumer function
        // OLD Equivalent code prev to java 8
        /*if(name != null) {
            System.out.println(name.length());
        }*/


        strOpt = Optional.ofNullable("TestStr"); //value may be null  //MOST RECOMMENDED
        System.out.println("3 result = " + strOpt.get());
        System.out.println("3 result isPresent= " + strOpt.isPresent());


        // The orElse() method returns the wrapped value if it's present, and its argument [STATIC VALUE] otherwise
        System.out.println("3 result orElse= " + strOpt.orElse("DefaultVal"));
        //Above with null val
        strOpt = Optional.ofNullable(null); //value may be null
        System.out.println("3 result orElse with null = " + strOpt.orElse("DefaultVal"));


        String returnVal =  strOpt.orElseGet(()-> "DefvalueSupplier"); //Takes a Supplier Function as arg and returns the produced value if Optional has null value
        System.out.println("3 result orElseGet with null = " + returnVal);

        //SO USE orElseGet when you want to process something and return a default value

        //DIFFERENCE between orElse and orElseGet is orElseGet will not be executed if Optional Value is present.

        try {
            strOpt.orElseThrow(() -> new Exception()); // takes Supplier FI arg
            //OR
            strOpt.orElseThrow( Exception :: new);

        }catch (Exception ex) {
            // Do Nothing
        }


        strOpt = Optional.ofNullable("TestStr"); //value may be null  //MOST RECOMMENDED
        // the filter method takes a Predicate as FI argument and returns an Optional object with original input value if
        // the wrapped value passes testing by the predicate, then the Optional is returned as-is else Optional.empty

        System.out.println("3 result Filter = " +         strOpt.filter(y->"TestStr".equals(y))   );
        System.out.println("3 result Filter  TestStr111= " +    strOpt.filter(y->"TestStr111".equals(y))   );


        // The map call is simply used to transform a value to some other value[do some processing].
        // The transformed value is wrapped inside Optional.
        // We then have to call an appropriate method on the returned Optional to retrieve its value.
        // Keep in mind that this operation does not modify the original value.
        //map takes Function as FI argument

        System.out.println("3 result Map  TestStr= " +   strOpt.map(s->s.length()).orElse(0)  );
        //OR
        System.out.println("3 result Map  TestStr= " +   strOpt.map(String:: length).orElse(0)  );

        //Chain map with filter
        System.out.println("3 result Map  TestStr= " +   strOpt.map(String:: length).filter(y -> y == 7 ) );
        System.out.println("3 result Map  TestStr= " +   strOpt.map(String:: length).filter(y -> y == 88 ) );
        System.out.println("3 result Map  TestStr= " +   strOpt.map(String:: length).filter(y -> y == 88 ).isPresent() );

        // map transforms values only when they are unwrapped whereas flatMap takes a wrapped value and unwraps it before transforming it.
        //so use flatmap if u r going  to get Optional object wrapped in Optional

        Person person1 = new Person(null, 30, "![]{}");
        Optional<Person> personOptional = Optional.of(person1);

        Optional<Optional<String>> nameWrapper = personOptional.map(Person::getName);
        Optional<String> nameOpt = nameWrapper.orElse(Optional.empty());
        String nameVal = nameOpt.orElse("");
        System.out.println("Map example nameval = " + nameVal);

        //Using flatmap
        Person person2 = new Person("Kamal", 30, "![]{}");
        Optional<Person> personOptional2 = Optional.of(person2);
        Optional<String> nameOpt2 = personOptional2.flatMap(Person::getName);
        String nameVal2 = nameOpt2.orElse("");
        System.out.println("flatMap example nameval2 = " + nameVal2);




        /*The release of Java 9 added even more new methods to the Optional API:
        or() method for providing a supplier that creates an alternative Optional
        ifPresentOrElse() method that allows executing an action if the Optional is present or another action if not
        stream() method for converting an Optional to a Stream
        */




    }
}
