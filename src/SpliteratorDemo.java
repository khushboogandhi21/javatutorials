import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorDemo {
    public static void main(String[] args){
        List<Integer> numberList = new ArrayList<>();
        numberList.add(5);
        numberList.add(1);
        numberList.add(2);
        numberList.add(0);
        numberList.add(-3);

        int count =0;

        // getting Spliterator object on numberList
        Spliterator<Integer> numberSplitIterator = numberList.spliterator();

        //Returns the characteristics of the invoking spliterator,encoded into an integer.
        //The result is from ORDERED(0x00000010), DISTINCT(0x00000001), SORTED(0x00000004), SIZED(0x00000040),
        // NONNULL(0x00000100), IMMUTABLE(0x00000400), CONCURRENT(0x00001000), SUBSIZED(0x00004000).
        //0x is prefix for hexadecimal 16 ordered 4 sorted iterator NOT Collection , 64 sized
        System.out.println("characteristics = " + numberSplitIterator.characteristics()); //16464
        System.out.println("estimateSize = " + numberSplitIterator.estimateSize());
        System.out.println("getExactSizeIfKnown = " + numberSplitIterator.getExactSizeIfKnown());

        while(numberSplitIterator.tryAdvance(n->System.out.println("The number is:" +n))){
            count++;
        }
        System.out.println("count is:" +count);

        // getting Spliterator object on numberList Again since Iterator and splitIterator traverses ONLY ONCE
        Spliterator<Integer> numberSplitAgainIterator = numberList.spliterator();
        Spliterator<Integer> secondSplitIterator = numberSplitAgainIterator.trySplit();   //returns first part
        if(secondSplitIterator != null)
        {
            secondSplitIterator.forEachRemaining(n->System.out.println("The number in First part list is:" +n));
        }

        if(numberSplitAgainIterator != null)
        {
            numberSplitAgainIterator.forEachRemaining(n->System.out.println("The number in Second Part list is:" +n));
        }

        //Similar operation u can use on Stream
        // Obtain a Stream to the array list.
        Stream<Integer> number = numberList.stream();
        // getting Spliterator object on number stream
        Spliterator<Integer> numberStreamSplitIterator = number.spliterator();
        count = 0;
        while(numberStreamSplitIterator.tryAdvance(n->System.out.println("The number in stream is:" +n))){
            count++;
        }
        System.out.println("count in stream is:" +count);
    }

}
