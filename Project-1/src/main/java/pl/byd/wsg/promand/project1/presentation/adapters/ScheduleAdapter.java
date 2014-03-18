package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class ScheduleAdapter extends BaseListAdapter<Talk> {

    public ScheduleAdapter(Context context, List<Talk> list) {
        super(context, list);
    }

    @Override
    public View getView(final int index, View v, ViewGroup viewGroup) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.talks_list_cell, null);
        Talk talk = getItem(index);

        TextView talkTitle = (TextView) view.findViewById(R.id.talk_title);
        talkTitle.setText(talk.getTitle());

        String startTime = DateUtils.hoursMinutesFormat(talk.getStartTime());
        TextView talkStartTime = (TextView) view.findViewById(R.id.start_time);
        talkStartTime.setText(startTime);

        String endTime = DateUtils.hoursMinutesFormat(talk.getEndTime());
        TextView talkEndTime = (TextView) view.findViewById(R.id.end_time);
        talkEndTime.setText(endTime);

        Button button = (Button) view.findViewById(R.id.attending_button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getContext(), "Index - " + index, Toast.LENGTH_SHORT).show();
            }
        });

        TextView speakerFullName = (TextView) view.findViewById(R.id.speaker_full_name);
        speakerFullName.setText("Tom cruse"); //TODO

        TextView trackTitle = (TextView) view.findViewById(R.id.track_title);
        trackTitle.setText("100"); //TODO
        return view;
    }
}
