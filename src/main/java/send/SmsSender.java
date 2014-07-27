package send;

import org.springframework.stereotype.Service;
import third.SmsUtils;

/**
 * Created by wylipengming on 2014/7/27.
 */

@Service("smsSender")
public class SmsSender implements Sender {
    @Override
    public void send(String content, String calling) {
        SmsUtils.getInstance().sendMessage(content, calling);
    }
}
