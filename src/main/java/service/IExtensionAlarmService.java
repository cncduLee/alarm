package service;

import filter.IFilter;
import listener.IListener;

/**
 * Created by wylipengming on 2014/7/27.
 */
public interface IExtensionAlarmService extends IAlarmService{
    public IListener addListener();
    public IFilter addFilter();
}
