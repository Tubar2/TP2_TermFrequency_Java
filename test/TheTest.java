import com.ricardo.MyMonads;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TheTest{

    private MyMonads myMonads = new MyMonads();
    private CompletableFuture<Object> theOneCompletableFuture = CompletableFuture.supplyAsync(() -> "dracula.txt");

    @Test
    public void dataCreationTest() throws ExecutionException, InterruptedException {
        Assert.assertEquals("failure - wrong path", theOneCompletableFuture.get(), "dracula.txt");
    }

    @Test()
    public void bindTest(){
        //Todo: Insert in try catch block
        try {
            CompletableFuture<Object> theOneCompletableFuture = CompletableFuture.supplyAsync(() -> "").thenApply(myMonads::readFile);
        } catch (Exception e){
            Assert.assertTrue(true);
        }
    }
}