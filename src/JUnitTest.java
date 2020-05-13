import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JUnitTest {

    Controller controller = new Controller();

    @Test
    public void createSurvey(){
        assertEquals("Test", controller.createSurvey().getName());
    }

}