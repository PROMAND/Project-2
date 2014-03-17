package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Speaker;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.utils.DateUtils;


public class PersonalScheduleAdapter extends BaseListAdapter<Talk> {


    public PersonalScheduleAdapter(Context context, List<Talk> list) {
        super(context, list);
    }

    @Override
    public View getView(int index, View v, ViewGroup viewGroup) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.my_schedule_cell, null);
        Talk talk = getItem(index);

        TextView title = (TextView) view.findViewById(R.id.talkTitle);
        title.setText(talk.getTitle());

        String startTime = DateUtils.hoursMinutesFormat(talk.getStartTime());
        String endTime = DateUtils.hoursMinutesFormat(talk.getEndTime());
        TextView time = (TextView) view.findViewById(R.id.talkStartEndsTime);
        time.setText(startTime + " - " + endTime);

        return view;
    }
}