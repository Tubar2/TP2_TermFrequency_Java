import com.ricardo.MyFunctions;
import com.ricardo.TheOne;
import org.junit.Assert;
import org.junit.Test;

public class TheTest {
    private TheOne theOne = new TheOne<>("dracula.txt");
    @Test
    public void dataCreationTest(){
        Assert.assertEquals("failure - wrong path", theOne.getValue(), "dracula.txt");
    }

    @Test()
    public void bindTest(){
        //Todo: Insert in try catch block
        try {
            TheOne theOne1 = new TheOne<>("").bind(MyFunctions::readFile);
        } catch (Exception e){
            Assert.assertTrue(true);
        }
    }
}
