package pl.byd.wsg.promand.project1.presentation.adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Speaker;

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
//        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

//        Bitmap bitmap = getBitmapFromURL(data[i].getPhotoUrl());
//        Bitmap circleImage = ImageHelper.getRoundedCornerBitmap(bitmap, 50);
//        imageView.setImageBitmap(bitmap);




        TextView text = (TextView) cell.findViewById(R.id.speakerCellHeaderText);
        text.setText(data[i].getName());

        text = (TextView) cell.findViewById(R.id.speakerCellDetailsText);
        text.setText(data[i].getSurname());

        return cell;
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
