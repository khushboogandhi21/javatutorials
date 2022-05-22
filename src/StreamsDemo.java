import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**Stream
 * Its A sequence of elements from a source that supports data processing operations
 *
 * Streams have a BaseStream. close() method and  implements AutoCloseable Interface so no need to explicitly close stream.
 *  only streams whose source is an IO channel (such as those returned by Files. lines(Path, Charset) ) will require closing.
 *
 *  Stream will also et closed if a terminating operation is invoked on it.
 *
 */

public class StreamsDemo {

    public static void main(String[] args){

        //Empty Stream
        //Used to avoid assigning null to stream
        Stream emptyStream = Stream.empty();

        //Stream of Collection
        List<Integer> collectionData = new ArrayList<Integer>();
        collectionData.add(1);
        collectionData.add(2);
        collectionData.add(3);
        collectionData.add(4);
        Stream stream = collectionData.stream();
        stream.forEach(s -> System.out.println(s));
        //OR
        //Iterating twice on
        // same stream would give IllegalStateException
        Stream stream2 = collectionData.stream();
        stream2.forEach( System.out::println);


        // Stream of Array
        Stream arrayStream =  Stream.of("Val1","Val2","Val3");
        System.out.println("arrayStream = " + arrayStream);

        //stream out of an existing array
        String[] strArray = new String[]{"arr1","arr2","arr3"};
        Stream arrStream = Arrays.stream(strArray);

        // Stream.builder()
        // If type not specified the build() method will create an instance of the Stream<Object>
        Stream<String> builderStream= Stream.<String>builder().add("Str1").add("Str2").add("Str3").build();

        //Stream.generate()
        //The generate() method accepts a Supplier<T> for element generation.
        // As the resulting stream is infinite,
        // the developer should specify the desired size,
        // or the generate() method will work until it reaches the memory limit
        Stream generateStream = Stream.generate(()->"element").limit(10);
        System.out.println("generateStream = " + generateStream);

        //Stream.iterate()
        //It takes UnaryOperator as argument
        //In Java 8, UnaryOperator is a functional interface and it extends Function.
        //The UnaryOperator takes one argument, and returns a result of the same type of its arguments.
        Stream iterateStream = Stream.iterate(1,n->n+2).limit(5);
        iterateStream.forEach((n)->System.out.print("item = " + n +"\t"));


        //Stream of Primitives
        //create streams out of three primitive types:
        //IntStream, LongStream, DoubleStream
        IntStream primitiveStream = IntStream.range(1,3);
        primitiveStream.forEach((n)->System.out.print("\nprimitiveStream item = " + n +"\t"));
        primitiveStream = IntStream.rangeClosed(1,3);
        primitiveStream.forEach((n)->System.out.print("\nprimitiveStream rangeClosed item = " + n +"\t"));

        //the Random class provides a wide range of methods for generating streams of primitives.
        Random random = new Random();
        DoubleStream randomStream = random.doubles(3);

        //Stream of String
        IntStream intStreamOfString = "a,b,c".chars();
        Stream<String> streamOfString =
                Pattern.compile(", ").splitAsStream("a, b, c");
        streamOfString.forEach((n)->System.out.println("\nstreamOfString  item = " + n +"\t"));

        //Stream of File
        /*Path path = Paths.get("C:\\file.txt");
        Stream<String> streamOfStrings = Files.lines(path);*/

        StreamsDemo sdemo = new StreamsDemo();
        sdemo.lazyDemoIntermediateOperation();




        //Parallel streams
        //Internally implements forkjoin
        //When the source of a stream is a Collection or an array,
        Stream<Integer> parallelCollStream = collectionData.parallelStream();
        //OR
        parallelCollStream = collectionData.stream().parallel();
        Stream<Integer> resultStream = parallelCollStream.map(x->x*100).filter(x->(x>200));
        resultStream.forEach((n)->System.out.print("\nresultStream  item = " + n +"\t"));

        //If the source of a stream is something other than a Collection or an array, the parallel() method should be used
        primitiveStream = IntStream.rangeClosed(1,5).parallel();
        System.out.println("\nprimitiveStream is parrallel = " + primitiveStream.isParallel());
        primitiveStream.sequential(); //turn back to sequential
        System.out.println("\nprimitiveStream is parrallel = " + primitiveStream.isParallel());


    }



     void lazyDemoIntermediateOperation(){
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        this.counter = 0;
        Stream<String> stream = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });
        System.out.println("counter Before   = " + counter +"\t");
        stream.forEach((n)->System.out.println("\nstream  item = " + n +"\t"));
        System.out.println("counter After  = " + counter +"\t");
    }
    long counter;
    void wasCalled() {
        counter++;
    }

}
