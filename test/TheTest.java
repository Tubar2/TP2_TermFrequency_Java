import com.ricardo.MyFunctions;
import com.ricardo.TheOne;
import org.junit.Assert;
import org.junit.Test;

public class TheTest {
    private MyFunctions myFunctions = new MyFunctions();


    @Test
    public void dataCreationTest(){
        TheOne theOne = new TheOne("dracula.txt");
        Assert.assertEquals("failure - wrong path", theOne.getValue(), "dracula.txt");
    }

    @Test()
    public void bindTest(){
        //Todo: Insert in try catch block
        try {
            TheOne theOne1 = new TheOne("").bind(myFunctions::readFile);
        } catch (Exception e){
            Assert.assertTrue(true);
        }
    }
}