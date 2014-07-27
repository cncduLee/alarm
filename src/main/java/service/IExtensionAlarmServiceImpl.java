package service;

import code.Message;
import filter.FilterChain;
import filter.IFilter;
import listener.IListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wylipengming on 2014/7/27.
 */
public class IExtensionAlarmServiceImpl implements IExtensionAlarmService{
    private static FilterChain chain = new FilterChain();
    private static List<IListener> listeners = new ArrayList<IListener>();

    @Override
    public IListener addListener() {
        return null;
    }

    @Override
    public IFilter addFilter() {
        return null;
    }

    @Override
    public void send(Message message) {

    }


}
