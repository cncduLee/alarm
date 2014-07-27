package code;

import java.util.List;

/**
 * Created by wylipengming on 2014/7/26.
 */
public class Message<T extends MessageType> implements Comparable<Message>{
    private T type;
    private String content;
    private List<String> calling;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getCalling() {
        return calling;
    }

    public void setCalling(List<String> calling) {
        this.calling = calling;
    }

    @Override
    public int compareTo(Message message) {
        return this.getType().getPriority() <= message.getType().getPriority() ? this.getType().getPriority() : message.getType().getPriority();
    }
}
