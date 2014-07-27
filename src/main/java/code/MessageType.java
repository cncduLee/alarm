package code;

/**
 * Created by wylipengming on 2014/7/26.
 */
public abstract class MessageType {
    protected int priority = 0;
    protected String name = "#";

    public MessageType(){
        this.priority = setPriority();
        this.name = setName();
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public abstract String setName();

    public abstract int setPriority();
}
