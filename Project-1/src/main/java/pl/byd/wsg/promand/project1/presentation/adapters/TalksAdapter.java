package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class TalksAdapter extends BaseAdapter{

    private Context context;
    private List<Talk> talkList;
    private static LayoutInflater inflater;

    public TalksAdapter(Context context, List<Talk> talkList) {
        this.context = context;
        this.talkList = talkList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return talkList.size();
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
        if (view == null){
            view = inflater.inflate(R.layout.all_schedule_cell, null);
        }
        TextView text = (TextView) view.findViewById(R.id.talkTitle);
        text.setText(talkList.get(i).getTitle());

        String startTime = DateUtils.hoursMinutesFormat(talkList.get(i).getStartTime());
        String endTime = DateUtils.hoursMinutesFormat(talkList.get(i).getEndTime());
        text = (TextView) view.findViewById(R.id.talkStartEndsTime);

        text.setText(startTime + " - " + endTime);
        return view;
    }
}
