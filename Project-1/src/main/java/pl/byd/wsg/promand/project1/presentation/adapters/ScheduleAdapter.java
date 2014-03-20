package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.presentation.TalkDescriptionActivity;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class ScheduleAdapter extends BaseListAdapter<Talk> {
    Context ct;
    public ScheduleAdapter(Context context, List<Talk> list) {
        super(context, list);
        this.ct = context;
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

       // String date = DateUtils.dateFormat(talk.getStartTime());
       // TextView talkDate = (TextView) view.findViewById(R.id.talk_date);
      //  talkDate.setText(date);

        Button button = (Button) view.findViewById(R.id.attending_button);
        setupButtonForTalk(button, talk, index);

        Button button1 = (Button) view.findViewById(R.id.btnGoToTalkDesc);
               button1.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                              Intent intent = new Intent (ct, TalkDescriptionActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

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
    private void setupButtonForTalk (final Button button, Talk talk, final int index) {
        //TODO: Check if i'm attending to this talk and then mark button
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                button.setSelected(!button.isSelected());
                if (button.isSelected()) {
                    button.setBackgroundColor(Color.GREEN);
                } else {
                    button.setBackgroundColor(Color.LTGRAY);
                }

//                Toast.makeText(getContext(), "Index - " + index, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
