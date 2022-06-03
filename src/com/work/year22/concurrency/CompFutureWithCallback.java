package com.work.year22.concurrency;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompFutureWithCallback {

    public static void main(String[] args){

        CompletableFuture<String> compFuture = CompletableFuture.supplyAsync(() -> {
            return "John";
        });

        //1
        CompletableFuture<String> resultFuture = compFuture.thenApply(x-> { return "Hello " + x;});  //CALLBACK METHOD returning value
        try{
            System.out.println(resultFuture.get());
        }catch(InterruptedException  |  java.util.concurrent.ExecutionException ex){
            System.out.println("Exception while get=" +ex);
        }

        //2
        CompletableFuture voidResultFuture = compFuture.thenAccept(x-> { System.out.println("Hello CONSUMED " + x);});
        //CALLBACK METHOD NOT returning value but processing it

        //3
        voidResultFuture = compFuture.thenRun(()->{ System.out.println("Doing some other task");});
        //CALLBACK METHOD NOT returning value but adding more computation logic IT DOESN'T HOLD PREVIOUS TAK RESULT



        //COMBINING TASKS
        CompletableFuture compSecondFuture = CompletableFuture.supplyAsync(()->{return 84;});

        //USE COMPOSE FOR DEPENDENT TASKS-->returns flattened result like flatmap
        //COMBINE FOR INDEPENDENT TASKS ONCE ENDED COMBINE RESULTS
        resultFuture =  compFuture.thenCompose(x->CompletableFuture.supplyAsync(()->{return x + " is welcome";}));  //takes function

        try{
            System.out.println(resultFuture.get());
        }catch(InterruptedException  |  java.util.concurrent.ExecutionException ex){
            System.out.println("Exception while get=" +ex);
        }

        resultFuture =  compFuture.thenCombine(compSecondFuture,(x,y)->{return x + " "+ y;});  //takes function


        try{
            System.out.println(resultFuture.get());
        }catch(InterruptedException  |  java.util.concurrent.ExecutionException ex){
            System.out.println("Exception while get=" +ex);
        }

        //COMBINE MORE THAN 2 FUTURES
        CompletableFuture compThirdFuture = CompletableFuture.supplyAsync(()->{return "Third Future";});
        voidResultFuture = CompletableFuture.allOf(compFuture,compSecondFuture,compThirdFuture); //similarly anyOf()


        //USED TO JOIN RESULTS AS UPPER STATEMENT RETURN VOID
       /* CompletableFuture<List<String>> allPageContentsFuture = voidResultFuture.thenApply(v -> {
            return voidResultFuture.stream()
                    .map(pageContentFuture -> pageContentFuture.join())
                    .collect(Collectors.toList());
        });*/ //CANT FIGURE OUT


        //EXCEPTION HANDLING
        //exceptionally called on exception only
        compSecondFuture = CompletableFuture.supplyAsync(()->{return 84/0;})
                .exceptionally(x->{System.out.println("Exception caught: "+x);return 0;}); //takes function and returns def value in case of error

        compSecondFuture.thenAccept(x->{System.out.println("Result is =" +x);});


        //handle always called
        compSecondFuture = CompletableFuture.supplyAsync( ()->{return new Random().nextInt(10);})
                .handle((res,ex)->
                {if(ex == null){
                    return res;
                }else return ex;}); //BIfunction(result,exception)
        compSecondFuture.thenAccept(x->{System.out.println("Result is =" +x);});

    }
}
