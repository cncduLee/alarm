package mq;

import listener.IListener;

/**
 * Created by wylipengming on 2014/7/26.
 */
public interface IMQ<T> {
    /**
     * 添加到优先级消息队列【发送消息】
     * @param param
     * @return
     */
    public Boolean offer(T param);


    /**
     * 读取并删除最前面的一则数据
     * @return
     */
    public T poll();

    /**
     * 添加监听器
     * @param listener
     */
    public void addListener(IListener listener);


}
