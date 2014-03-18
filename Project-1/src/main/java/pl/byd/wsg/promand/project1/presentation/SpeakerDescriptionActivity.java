package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.presentation.helpers.FileCache;
import pl.byd.wsg.promand.project1.presentation.helpers.ImageLoader;
import pl.byd.wsg.promand.project1.presentation.helpers.MemoryCache;
import pl.byd.wsg.promand.project1.presentation.model.SpeakerDescriptionField;

public class SpeakerDescriptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_description);
        Intent intent = getIntent();

        TextView fullNameText = (TextView)findViewById(R.id.speaker_full_name);
        String name = intent.getStringExtra(SpeakerDescriptionField.NAME.toString());
        String surname = intent.getStringExtra(SpeakerDescriptionField.SURNAME.toString());
        fullNameText.setText(name + " " + surname);

        TextView companyText = (TextView)findViewById(R.id.speaker_company);
        String company = intent.getStringExtra(SpeakerDescriptionField.COMPANY.toString());
        companyText.setText(company);

        TextView descriptionText = (TextView) findViewById(R.id.speaker_description);
        String description = intent.getStringExtra(SpeakerDescriptionField.DESCRIPTION.toString());
        descriptionText.setText(description);

        TextView image = (TextView) findViewById(R.id.TEST_image_URL);
        String imageUrl = intent.getStringExtra(SpeakerDescriptionField.PHOTO_URL.toString());
        image.setText(imageUrl);

        ImageView speakerPhoto = (ImageView) findViewById(R.id.speaker_image);
        ImageLoader imageLoader = new ImageLoader(this, new MemoryCache(), new FileCache());
        imageLoader.downloadImage(imageUrl);
        imageLoader.displayImage(imageUrl, speakerPhoto);
    }
}
