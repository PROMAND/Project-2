package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class BaseListAdapter<T> extends BaseAdapter{

    private Context context;
    private List<T> list;

    public BaseListAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int index) {
        return list.get(index);
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    public Context getContext() {
        return context;
    }
}
