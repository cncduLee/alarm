package send;

import org.springframework.stereotype.Service;
import third.EmailUtils;

/**
 * Created by wylipengming on 2014/7/27.
 */

@Service("emailSender")
public class EmailSender implements Sender {
    @Override
    public void send(String content, String calling) {
        EmailUtils.getInstance().sendMessage(content, calling);
    }
}
