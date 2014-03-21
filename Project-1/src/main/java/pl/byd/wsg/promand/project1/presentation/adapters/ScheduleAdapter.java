package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.dao.TalkTrackDao;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.presentation.TalkDescriptionActivity;
import pl.byd.wsg.promand.project1.presentation.application.BaseApplication;
import pl.byd.wsg.promand.project1.presentation.model.TalkDescriptionField;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class ScheduleAdapter extends BaseListAdapter<Talk> {
    Context ct;
    Track track;
    TalkTrackDao talkTrackDao = BaseApplication.getTalkTrackDao();

    public ScheduleAdapter(Context context, List<Talk> list, Track track) {
        super(context, list);
        this.ct = context;
        this.track = track;
    }

    @Override
    public View getView(final int index, View v, ViewGroup viewGroup) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.talks_list_cell, null);
        final Talk talk = getItem(index);

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

        String date = DateUtils.dateFormat(talk.getStartTime());
        TextView talkDate = (TextView) view.findViewById(R.id.speaker_cell_date);
        talkDate.setText(date);

        Button button = (Button) view.findViewById(R.id.attending_button);
        boolean b = talkTrackDao.getIsAdded(talk, track, talkTrackDao.findAll());
        button.setSelected(b);
        if (button.isSelected()) {
            button.setTextColor(getContext().getResources().getColor(R.color.green));
            button.setTypeface(null, Typeface.BOLD);
        } else {
            button.setTextColor(Color.BLACK);
            button.setTypeface(null, Typeface.NORMAL);
        }
        setupButtonForTalk(button, talk, index);

        Button button1 = (Button) view.findViewById(R.id.btnGoToTalkDesc);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ct, TalkDescriptionActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                assert talk != null;
                intent.putExtra(TalkDescriptionField.TITLE.toString(), talk.getTitle());
                intent.putExtra(TalkDescriptionField.DESCRIPTION.toString(), talk.getDescription());
                intent.putExtra(TalkDescriptionField.START.toString(), DateUtils.hoursMinutesFormat(talk.getStartTime()));
                intent.putExtra(TalkDescriptionField.END.toString(), DateUtils.hoursMinutesFormat(talk.getEndTime()));
                ct.startActivity(intent);
            }
        });
        return view;
    }

    /*        ImageView imageView = (ImageView) view.findViewById(R.id.talk_image);

            TextView speakerFullName = (TextView) view.findViewById(R.id.speaker_full_name);
            speakerFullName.setText("Tom cruse"); //TODO

            TextView trackTitle = (TextView) view.findViewById(R.id.track_title);
            trackTitle.setText("100"); //TODO
            return view;
        }
    */
    private void setupButtonForTalk(final Button button, final Talk talk, final int index) {
        //TODO: Check if i'm attending to this talk and then mark button

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                button.setSelected(!button.isSelected());
                talkTrackDao.updateIsAdded(talk, track, button.isSelected());
                if (button.isSelected()) {
                    button.setTextColor(getContext().getResources().getColor(R.color.green));
                    button.setTypeface(null, Typeface.BOLD);
                } else {
                    button.setTextColor(Color.BLACK);
                    button.setTypeface(null, Typeface.NORMAL);
                }
            }
        });
    }
}
