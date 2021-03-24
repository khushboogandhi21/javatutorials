import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**Stream
 * Its A sequence of elements from a source that supports data processing operations
 *
 */

public class StreamsDemo {

    public static void main(String[] args){
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

    }


}
