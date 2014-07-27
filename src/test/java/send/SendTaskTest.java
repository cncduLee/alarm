package send;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "classpath:spring.xml"
        }
)
public class SendTaskTest {

    @Resource
    private SendTask sendTask;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testR(){
        sendTask.run();
    }
}