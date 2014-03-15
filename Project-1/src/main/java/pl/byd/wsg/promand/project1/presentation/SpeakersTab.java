package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.adapters.SpeakerCellAdapter;
import pl.byd.wsg.promand.project1.domain.entity.Speaker;
import pl.byd.wsg.promand.project1.jsonservice.SpeakerServiceImpl;

public class SpeakersTab extends Activity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speakers_tab);

        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
        List<Speaker> listOfSpeakers = speakerService.getSpeakerList();
        Speaker[] speakersArray = listOfSpeakers.toArray(new Speaker[listOfSpeakers.size()]);

        listview = (ListView) findViewById(R.id.speakersListView);
        listview.setAdapter(new SpeakerCellAdapter(this, speakersArray));
    }

}
