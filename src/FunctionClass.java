import java.util.function.Function;

public class FunctionClass {
    public static void main (String[] args){
        FunctionClass functionClass =  new FunctionClass();
        //Function Reference
        Function funcRef = functionClass.getFuncInterfaceImpl(); //return implementation of apply method

        Integer returnVal = (Integer) funcRef.apply("kamal");
        System.out.println("returnVal = " + returnVal);

    }


    private Function<String,Integer> getFuncInterfaceImpl(){
        return (String temp)->{System.out.println("temp = " + temp); return 1;};
    }
}
