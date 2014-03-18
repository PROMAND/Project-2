package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Speaker;
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
    }
}
