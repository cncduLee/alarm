package code;

/**
 * Created by wylipengming on 2014/7/27.
 */
public class EmailType extends MessageType{

    public EmailType() {
        super();
    }

    @Override
    public String setName() {
        return "email";
    }

    @Override
    public int setPriority() {
        return 1;
    }
}
