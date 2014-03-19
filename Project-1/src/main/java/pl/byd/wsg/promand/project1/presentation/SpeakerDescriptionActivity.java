package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.jsonmock.TalkJsonService;
import pl.byd.wsg.promand.project1.jsonmock.TalkJsonServiceImpl;
import pl.byd.wsg.promand.project1.presentation.application.BaseApplication;
import pl.byd.wsg.promand.project1.presentation.model.SpeakerDescriptionField;
import pl.byd.wsg.promand.project1.utils.DateUtils;

public class SpeakerDescriptionActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_description);
        Intent intent = getIntent();

        TextView fullNameText = (TextView) findViewById(R.id.speaker_full_name);
        String name = intent.getStringExtra(SpeakerDescriptionField.NAME.toString());
        String surname = intent.getStringExtra(SpeakerDescriptionField.SURNAME.toString());
        fullNameText.setText(name + " " + surname);

        TextView companyText = (TextView) findViewById(R.id.speaker_company);
        String company = intent.getStringExtra(SpeakerDescriptionField.COMPANY.toString());
        companyText.setText(company);

        TextView descriptionText = (TextView) findViewById(R.id.speaker_description);
        String description = intent.getStringExtra(SpeakerDescriptionField.DESCRIPTION.toString());
        descriptionText.setText(description);

        TextView image = (TextView) findViewById(R.id.TEST_image_URL);
        String imageUrl = intent.getStringExtra(SpeakerDescriptionField.PHOTO_URL.toString());
        image.setText(imageUrl);

        ImageView speakerPhoto = (ImageView) findViewById(R.id.speaker_image);

        /*ImageLoader imageLoader = new ImageLoader(getApplicationContext(), new MemoryCache(), new FileCache(getApplicationContext()));
        imageLoader.downloadImage(imageUrl);
        speakerPhoto.setVisibility(View.VISIBLE);
        imageLoader.displayImage(imageUrl, speakerPhoto);*/

        BaseApplication.getTalkDao().save(new Talk(3, "How to be hot",
                "You will get some advices for how to be hot",
                DateUtils.createDate(2015, 1, 1, 10, 00),
                DateUtils.createDate(2015, 1, 1, 12, 00),
                Arrays.asList(1L, 4L),
                Arrays.asList(1L, 5L)
        ));

        List<Talk> talkList = BaseApplication.getTalkDao().findAll();
        Toast.makeText(getApplicationContext(),talkList.get(2).getTitle() + talkList.get(4).getId(), Toast.LENGTH_SHORT).show();
        TextView TEST = (TextView) findViewById(R.id.TEST_image_URL);
        TEST.setText("");

    }
}
