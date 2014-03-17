package pl.byd.wsg.promand.project1.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.dao.PersonalScheduleDao;
import pl.byd.wsg.promand.project1.presentation.adapters.PersonalScheduleAdapter;
import pl.byd.wsg.promand.project1.presentation.adapters.ScheduleAdapter;

public class PersonalScheduleTab extends Activity {

    private PersonalScheduleDao personalScheduleDao = PersonalScheduleDao.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_schedule_tab);

        ListView listView = (ListView) findViewById(R.id.myScheduleView);
        listView.setAdapter(new PersonalScheduleAdapter(this, personalScheduleDao.getPersonalTalkList()));
    }
}
