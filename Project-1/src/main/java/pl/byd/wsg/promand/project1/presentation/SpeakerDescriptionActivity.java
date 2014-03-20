package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.presentation.model.SpeakerDescriptionField;

public class SpeakerDescriptionActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_description);

//        Intent intent = getIntent();
//
//        TextView fullNameText = (TextView)findViewById(R.id.speaker_full_name);
//        String name = intent.getStringExtra(SpeakerDescriptionField.NAME.toString());
//        String surname = intent.getStringExtra(SpeakerDescriptionField.SURNAME.toString());
//        fullNameText.setText(name + " " + surname);
//
//        TextView companyText = (TextView)findViewById(R.id.speaker_company);
//        String company = intent.getStringExtra(SpeakerDescriptionField.COMPANY.toString());
//        companyText.setText(company);
//
//        TextView descriptionText = (TextView) findViewById(R.id.speaker_description);
//        String description = intent.getStringExtra(SpeakerDescriptionField.DESCRIPTION.toString());
//        descriptionText.setText(description);

//        TextView image = (TextView) findViewById(R.id.TEST_image_URL);
//        String imageUrl = intent.getStringExtra(SpeakerDescriptionField.PHOTO_URL.toString());
//        image.setText(imageUrl);
//
//        ImageView speakerPhoto = (ImageView) findViewById(R.id.speaker_image);

        //twitter button
        ImageButton btnTwitter = (ImageButton) findViewById(R.id.btnTwitter);
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "#Conference_name #talk/speaker";
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("twitter://user?screen_name=[user_name]"));
                    intent.putExtra(Intent.EXTRA_TEXT,message);
                    startActivity(intent);

                }catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://twitter.com/#!/[user_name]")));
                }

            }
        });

        //facebook button
        ImageButton btnFacebook = (ImageButton) findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "#Conference_name #talk/speaker";
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("facebook://user?screen_name=[user_name]"));
                    intent.putExtra(Intent.EXTRA_TEXT,message);
                    startActivity(intent);

                }catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://facebook.com/#!/[user_name]")));
                }

            }
        });

        //google+ button
        ImageButton btnGoogle = (ImageButton) findViewById(R.id.btnGoogle);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "#Conference_name #talk/speaker";
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("googleplus://user?screen_name=[user_name]"));
                    intent.putExtra(Intent.EXTRA_TEXT,message);
                    startActivity(intent);

                }catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://plus.google.com/#!/[user_name]")));
                }

            }
        });


/*
        LinearLayout bar = (LinearLayout)findViewById(R.id.linearbar);
        bar.setBackgroundResource(R.drawable.bar_gradient);

        // Add Bar to library
        adapter = new SocialAuthAdapter(new ResponseListener());

        // Add providers
        adapter.addProvider(Provider.FACEBOOK, R.drawable.facebook);
        adapter.addProvider(Provider.TWITTER, R.drawable.twitter);
        adapter.addProvider(Provider.LINKEDIN, R.drawable.linkedin);
        adapter.addProvider(Provider.MYSPACE, R.drawable.myspace);
        adapter.enable(bar);

        TextView fullNameText = (TextView)findViewById(R.id.speaker_full_name);
        String name = intent.getStringExtra(SpeakerDescriptionField.NAME.toString());
        String surname = intent.getStringExtra(SpeakerDescriptionField.SURNAME.toString());
        fullNameText.setText(name + " " + surname);

        TextView companyText = (TextView)findViewById(R.id.speaker_company);
        String company = intent.getStringExtra(SpeakerDescriptionField.COMPANY.toString());
        companyText.setText(company);

        TextView descriptionText = (TextView) findViewById(R.id.speaker_description_text);
        String description = intent.getStringExtra(SpeakerDescriptionField.DESCRIPTION.toString());
        descriptionText.setText(description);

        TextView image = (TextView) findViewById(R.id.TEST_image_URL);
        String imageUrl = intent.getStringExtra(SpeakerDescriptionField.PHOTO_URL.toString());
        image.setText(imageUrl);

        ImageView speakerPhoto = (ImageView) findViewById(R.id.speaker_image);
>>>>>>> Stashed changes

        /*ImageLoader imageLoader = new ImageLoader(getApplicationContext(), new MemoryCache(), new FileCache(getApplicationContext()));
        imageLoader.downloadImage(imageUrl);
        speakerPhoto.setVisibility(View.VISIBLE);
        imageLoader.displayImage(imageUrl, speakerPhoto);*/


        /*TrackDao trackDao = BaseApplication.getTrackDao();//new TrackDao(new DatabaseHelper(getApplicationContext()));
        trackDao.saveTrack(new Track(1,"sdfsdf"));
        List<Track> tracks = trackDao.load();*/


        /*TextView TEST = (TextView) findViewById(R.id.TEST_image_URL);
        TEST.setText("");*/

    }
}

