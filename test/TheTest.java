import com.TermFreq.MyFunctions;
import com.TermFreq.TheOne;
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
        try {
            TheOne theOne1 = new TheOne<>("").bind(MyFunctions::readFile);
        } catch (Exception e){
            Assert.assertTrue(true);
        }
    }
}
