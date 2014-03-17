package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.jsonservice.SpeakerService;
import pl.byd.wsg.promand.project1.jsonservice.SpeakerServiceImpl;
import pl.byd.wsg.promand.project1.presentation.adapters.SpeakerAdapter;

public class SpeakersTab extends Activity {

    private SpeakerService speakerService = new SpeakerServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speakers_tab);

        ListView listView = (ListView) findViewById(R.id.speakersListView);
        listView.setAdapter(new SpeakerAdapter(this, speakerService.getSpeakerList()));
    }

}
