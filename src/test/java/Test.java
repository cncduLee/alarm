import code.EmailType;
import code.Message;
import code.SmsType;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IAlarmService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wylipengming on 2014/7/27.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "classpath:spring.xml"
        }
)
public class Test {
    @Resource(name = "IAlarmService")
    IAlarmService alarmService;

    @Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void testV(){
        List<String> contacts = new ArrayList<String>();
        contacts.add("消息1");
        contacts.add("消息2");
        contacts.add("消息3");

        Message message = new Message();
        message.setCalling(contacts);
        message.setContent("测试");

        for(int a = 0;a<100;a++){
            if(a % 2 == 0){
                message.setType(new SmsType());
            }else if(a % 2 == 1){
                message.setType(new EmailType());
            }
            alarmService.send(message);
        }
    }

}
