package pl.byd.wsg.promand.project1.presentation;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import java.util.List;
import java.util.Locale;
import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.jsonservice.TalkService;
import pl.byd.wsg.promand.project1.jsonservice.TalkServiceImpl;
import pl.byd.wsg.promand.project1.jsonservice.TrackService;
import pl.byd.wsg.promand.project1.jsonservice.TrackServiceImpl;

public class TalksListFragmentActivity extends FragmentActivity {
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    private TrackService trackService = new TrackServiceImpl();
    private TalkService talkServise = new TalkServiceImpl();
    List<Track> trackList = trackService.getTrackList();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talks_schedule_tab);

        Intent intent = getIntent();
        int i = intent.getIntExtra("tab_index", 99);
        Log.i("Some name", "Some number" + i);

        this.registerReceiver(clickedReceiver, new IntentFilter("pl.byd.wsg"));

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.my_schedule_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private BroadcastReceiver clickedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new TalksListFragment(trackList.get(position));
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return trackList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            Track track = trackList.get(position);
            return track.getTitle();
        }
    }

        public void onDestroy(){
            unregisterReceiver(clickedReceiver);
        }
}
