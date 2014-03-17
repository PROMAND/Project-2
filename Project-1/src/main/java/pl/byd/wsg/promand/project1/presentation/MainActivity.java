package pl.byd.wsg.promand.project1.presentation;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import pl.byd.wsg.promand.project1.R;

public class MainActivity extends ActionBarActivity {
    LocalActivityManager mLocalActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocalActivityManager = new LocalActivityManager(this, false);
        mLocalActivityManager.dispatchCreate(savedInstanceState);

        setupTabs();
    }

    private void setupTabs () {
        TabHost myTabHost = (TabHost) findViewById(R.id.tabHost);
        myTabHost.setup(mLocalActivityManager);

        TabHost.TabSpec tabSpec = myTabHost.newTabSpec("PersonalScheduleTab");
        tabSpec.setIndicator("My\nSchedule", null);
        Intent myIntent = new Intent(this, PersonalScheduleTab.class);
        tabSpec.setContent(myIntent);
        myTabHost.addTab(tabSpec);

        tabSpec = myTabHost.newTabSpec("allSchedule");
        tabSpec.setIndicator("All\nSchedule");
        myIntent = new Intent(this, ScheduleTab.class);
        tabSpec.setContent(myIntent);
        myTabHost.addTab(tabSpec);

        tabSpec = myTabHost.newTabSpec("speakers");
        tabSpec.setIndicator("Speakers");
        myIntent = new Intent(this, SpeakersTab.class);
        tabSpec.setContent(myIntent);
        myTabHost.addTab(tabSpec);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocalActivityManager.dispatchResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocalActivityManager.dispatchPause(isFinishing());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
