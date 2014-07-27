package code;

/**
 * Created by wylipengming on 2014/7/27.
 */
public class SmsType extends MessageType{

    public SmsType() {
        super();
    }

    @Override
    public String setName() {
        return "sms";
    }

    @Override
    public int setPriority() {
        return -1;
    }
}
