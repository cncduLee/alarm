package service;

import code.Message;
import mq.IMQ;
import org.springframework.stereotype.Service;
import send.Dancer;

import javax.annotation.Resource;

/**
 * Created by wylipengming on 2014/7/26.
 */
@Service("IAlarmService")
public class IAlarmServiceImpl implements IAlarmService{

    @Resource(name = "IMQ")
    private IMQ mq;

    @Resource(name = "dancer")
    private Dancer dancer;

    @Override
    public void send(Message message) {
        mq.offer(message);
        //初次,启动后台处理
        if(!dancer.isRunning()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dancer.setRunning(true);
                    dancer.done();
                }
            }).start();
        }
    }

}
