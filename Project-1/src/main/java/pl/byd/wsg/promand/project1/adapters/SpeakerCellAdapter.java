package pl.byd.wsg.promand.project1.adapters;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Speaker;
import pl.byd.wsg.promand.project1.domain.list.SpeakerList;
import pl.byd.wsg.promand.project1.jsonservice.SpeakerServiceImpl;

public class SpeakerCellAdapter extends BaseAdapter {

    Context context;
    Speaker[] data;
    private static LayoutInflater inflater = null;

    public SpeakerCellAdapter(Context context, Speaker data[]) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
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
        View cell = view;
        if (cell == null)
            cell = inflater.inflate(R.layout.speaker_cell, null);

//        ImageView imageView = (ImageView) cell.findViewById(R.id.speakerImageView);

        TextView text = (TextView) cell.findViewById(R.id.speakerCellHeaderText);
        text.setText(data[i].getName());

        text = (TextView) cell.findViewById(R.id.speakerCellDetailsText);
        text.setText(data[i].getSurname());

        return cell;
    }
}
