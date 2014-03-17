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

        TextView talkTitle = (TextView) view.findViewById(R.id.talk_title);
        talkTitle.setText(talk.getTitle());

        String startTime = DateUtils.hoursMinutesFormat(talk.getStartTime());
        TextView talkStartTime = (TextView) view.findViewById(R.id.start_time);
        talkStartTime.setText(startTime);

        String endTime = DateUtils.hoursMinutesFormat(talk.getEndTime());
        TextView talkEndTime = (TextView) view.findViewById(R.id.end_time);
        talkEndTime.setText(endTime);

        TextView speakerFullName = (TextView) view.findViewById(R.id.speaker_full_name);
        speakerFullName.setText("Tom cruse"); //TODO

        TextView trackTitle = (TextView) view.findViewById(R.id.track_title);
        trackTitle.setText("100"); //TODO
        return view;
    }
}
