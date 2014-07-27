package filter;

import code.Message;

/**
 * Created by wylipengming on 2014/7/26.
 */
public interface IFilter {
    public void doFilter(Message message,FilterChain chain);
}
