package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.jsonservice.TalkService;
import pl.byd.wsg.promand.project1.jsonservice.TalkServiceImpl;
import pl.byd.wsg.promand.project1.presentation.adapters.TalksAdapter;

public class AllScheduleTab extends Activity {

    private TalkService talkService = new TalkServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_schedule_tab);

        ListView listView = (ListView) findViewById(R.id.textView);
        listView.setAdapter(new TalksAdapter(this, talkService.getTalkList()));
    }

}
