package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Talk;


public class MyScheduleAdapter extends BaseAdapter {

    private Context context;
    private List<Talk> myTalkList;

    public MyScheduleAdapter(Context context, List<Talk> myTalkList) {
        this.context = context;
        this.myTalkList = myTalkList;
    }

    @Override
    public int getCount() {
        return myTalkList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
