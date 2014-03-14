package pl.byd.wsg.promand.project1;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import pl.byd.wsg.promand.project1.activities.AllScheduleTab;
import pl.byd.wsg.promand.project1.activities.MyScheduleTab;
import pl.byd.wsg.promand.project1.activities.SpeakersTab;

public class MainActivity extends ActionBarActivity {
    LocalActivityManager mLocalActivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocalActivityManager = new LocalActivityManager(this, false);

        TabHost myTabHost = (TabHost) findViewById(R.id.tabHost);
        mLocalActivityManager.dispatchCreate(savedInstanceState);
        myTabHost.setup(mLocalActivityManager);

        TabHost.TabSpec tabSpec = myTabHost.newTabSpec("MyScheduleTab");
        tabSpec.setIndicator("My\nSchedule", null);
        Intent myIntent = new Intent(this, MyScheduleTab.class);
        tabSpec.setContent(myIntent);
        myTabHost.addTab(tabSpec);

        tabSpec = myTabHost.newTabSpec("allSchedule");
        tabSpec.setIndicator("All\nSchedule");
        myIntent = new Intent(this, AllScheduleTab.class);
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
