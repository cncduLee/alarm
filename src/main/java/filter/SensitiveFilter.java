package filter;

import code.Message;

/**
 * Created by wylipengming on 2014/7/27.
 */
public class SensitiveFilter implements IFilter {
    @Override
    public void doFilter(Message message, FilterChain chain) {
        chain.doFilter(message, chain);
    }
}
