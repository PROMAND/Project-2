package pl.byd.wsg.promand.project1.presentation.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Speaker;

public class SpeakerAdapter extends BaseListAdapter<Speaker>{

    public SpeakerAdapter(Context context, List<Speaker> list) {
        super(context, list);
    }

    @Override
    public View getView(int index, View v, ViewGroup viewGroup) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.speaker_cell, null);
        Speaker speaker = getItem(index);

        TextView name = (TextView) view.findViewById(R.id.speakerCellHeaderText);
        name.setText(speaker.getName());

        TextView surname = (TextView) view.findViewById(R.id.speakerCellDetailsText);
        surname.setText(speaker.getName());

        return view;
    }
}
