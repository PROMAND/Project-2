package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class ScheduleAdapter extends BaseListAdapter<Talk> {

    public ScheduleAdapter(Context context, List<Talk> list) {
        super(context, list);
    }

    @Override
    public View getView(int index, View v, ViewGroup viewGroup) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.all_schedule_cell, null);
        Talk talk = getItem(index);

        TextView text = (TextView) view.findViewById(R.id.talkTitle);
        text.setText(talk.getTitle());

        String startTime = DateUtils.hoursMinutesFormat(talk.getStartTime());
        String endTime = DateUtils.hoursMinutesFormat(talk.getEndTime());
        text = (TextView) view.findViewById(R.id.talkStartEndsTime);
        text.setText(startTime + " - " + endTime);

        return view;
    }
}
