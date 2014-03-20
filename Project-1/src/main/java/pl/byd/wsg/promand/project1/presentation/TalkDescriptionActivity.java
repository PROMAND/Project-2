package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.presentation.model.TalkDescriptionField;

public class TalkDescriptionActivity extends Activity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk_description);

       /* Intent intent = getIntent();
        TextView talkTitle = (TextView)findViewById(R.id.talk_title);
        String title = intent.getStringExtra(TalkDescriptionField.TITLE.toString());
        talkTitle.setText(title);

        TextView talkDescription = (TextView)findViewById(R.id.talk_description);
        String description = intent.getStringExtra(TalkDescriptionField.DESCRIPTION.toString());
        talkDescription.setText(description);

        TextView fullTime = (TextView) findViewById(R.id.full_time);
        String start = intent.getStringExtra(TalkDescriptionField.START.toString());
        String end = intent.getStringExtra(TalkDescriptionField.END.toString());
        fullTime.setText(start + " - " + end);


*/

    }
}
