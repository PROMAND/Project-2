package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Speaker;
import pl.byd.wsg.promand.project1.presentation.helpers.CircleImageView;

public class SpeakerAdapter extends BaseListAdapter<Speaker> {

    public SpeakerAdapter(Context context, List<Speaker> list) {
        super(context, list);
    }

    @Override
    public View getView(int index, View v, ViewGroup viewGroup) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.speaker_cell, null);
        Speaker speaker = getItem(index);

        TextView speakerFullName = (TextView) view.findViewById(R.id.speaker_full_name);
        speakerFullName.setText(speaker.getName() + " " + speaker.getSurname());

        TextView speakerCompany = (TextView) view.findViewById(R.id.speaker_company);
        speakerCompany.setText(speaker.getCompany().getName());

        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.cell_profile_image);
        if ("Tom".equals(speaker.getName())) {

        } else {
            circleImageView.setImageDrawable(view.getResources().getDrawable(R.drawable.chuck_norris));
        }

        return view;
    }
}
