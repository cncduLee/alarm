package send;

import code.Message;
import mq.IMQ;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wylipengming on 2014/7/27.
 */

@Service("dancer")
public class Dancer {
    private final static ExecutorService pool = Executors.newCachedThreadPool();
    private boolean running = false;
    private Long idle = 1 * 1000L;//懒停时间间隔

    @Resource(name = "IMQ")
    private IMQ mq;

    @Resource(name = "sendTask")
    private SendTask sendTask;

    public void done() {
        while (running) {
            Message message = (Message) mq.poll();
            if(message == null){
                Threads.sleep(idle);
            }else{
                sendTask.setMessage(message);
                pool.execute(sendTask);
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
