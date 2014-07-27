package send;

import code.Message;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by wylipengming on 2014/7/27.
 */
@Component("senderFactory")
public class SenderFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public Sender getSender(Message message){
        return (Sender) applicationContext.getBean(message.getType().getName().toLowerCase() + "Sender");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
