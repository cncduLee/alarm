package mq;

import code.Message;
import listener.IListener;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by wylipengming on 2014/7/26.
 */

@Service("IMQ")
public class IMQImpl implements IMQ<Message>,Serializable {

    private static PriorityBlockingQueue<Message> que;

    @Override
    public Boolean offer(Message param) {
        que.add(param);
        return true;
    }

    @Override
    public Message poll() {
        return que.poll();
    }

    @Override
    public void addListener(IListener listener) {

    }

    private IMQImpl() {
        this(Integer.MAX_VALUE/1024);
    }

    private IMQImpl(int initialCapacity){
        this.que = new PriorityBlockingQueue<Message>(initialCapacity);
    }


    /***********************
     *      no spring      *
     **********************/

    private static class SiglentonHolder{
        private final static IMQImpl singleton = new IMQImpl();
    }

    public static IMQImpl getInstance(){
        return SiglentonHolder.singleton;
    }
}
