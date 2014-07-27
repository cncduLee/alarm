package send;

import code.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wylipengming on 2014/7/27.
 */

@Service("sendTask")
public class SendTask implements Runnable{
    private Message message;
    @Resource(name = "senderFactory")
    private SenderFactory sf;
    public SendTask(){}

    public void setMessage(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        if(message == null) return;
        for (Object contact : message.getCalling()) {
            try {
                sf.getSender(message).send(message.getContent(), contact.toString());
            }catch (Exception e){
                System.out.print("send error::"+e.getMessage());
            }
        }
    }
}
