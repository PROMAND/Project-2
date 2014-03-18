package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Speaker;
import pl.byd.wsg.promand.project1.jsonservice.SpeakerService;
import pl.byd.wsg.promand.project1.jsonservice.SpeakerServiceImpl;
import pl.byd.wsg.promand.project1.presentation.adapters.SpeakerAdapter;

public class SpeakersTab extends Activity implements AdapterView.OnItemClickListener {

    private SpeakerService speakerService = new SpeakerServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speakers_tab);

        ListView listView = (ListView) findViewById(R.id.speakersListView);
        listView.setAdapter(new SpeakerAdapter(this, speakerService.getSpeakerList()));
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        //Speaker speaker = (Speaker)adapterView.getItemAtPosition(index);
        Intent intent = new Intent(this, SpeakerDescriptionActivity.class);
        startActivity(intent);
}
}
