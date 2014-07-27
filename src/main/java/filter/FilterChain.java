package filter;

import code.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wylipengming on 2014/7/27.
 */
public class FilterChain implements IFilter{
    private int index = 0;
    private List<IFilter> filters = new ArrayList<IFilter>();

    public FilterChain addFilter(IFilter filter){
        if(!filters.contains(filter)) {
            this.filters.add(filter);
        }
        return this;
    }

    @Override
    public void doFilter(Message message, FilterChain chain) {
        if(index == filters.size()){
            return;
        }
        index++;
        filters.get(index).doFilter(message, chain);
    }
}
