package completablefuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            if(true) {
                throw new RuntimeException("Something went wrong !");
            }
            return 42;
        });

        CompletableFuture<Integer> exceptionallyHandledFuture = future.exceptionally(ex -> {
            System.out.println("Exception Occurred: "+ ex.getMessage());
            return 0;
        });
        try {
            Integer result = exceptionallyHandledFuture.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
}
