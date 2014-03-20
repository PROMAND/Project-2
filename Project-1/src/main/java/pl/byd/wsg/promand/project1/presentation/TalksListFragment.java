package pl.byd.wsg.promand.project1.presentation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.dao.TalkDao;
import pl.byd.wsg.promand.project1.dao.TalkTrackDao;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.domain.entity.TalkTrack;
import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.jsonservice.TalkService;
import pl.byd.wsg.promand.project1.jsonservice.TalkServiceImpl;
import pl.byd.wsg.promand.project1.presentation.adapters.ScheduleAdapter;
import pl.byd.wsg.promand.project1.presentation.application.BaseApplication;

public class TalksListFragment extends Fragment {
    private TalkTrackDao talkTrackDao = BaseApplication.getTalkTrackDao();
    private TalkDao talkDao = BaseApplication.getTalkDao();
    private Track track;
    private int tabNumber;

    public TalksListFragment(Track track, int tabNumber) {
        this.track = track;
        this.tabNumber = tabNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.talks_list_view, container, false);

        assert view != null;
        ListView listView = (ListView) view.findViewById(R.id.reusableTalksList);
        listView.setAdapter(new ScheduleAdapter(getActivity().getBaseContext(), filterEmptyTracks(), track));
        return view;
    }

    private List<Talk> filterEmptyTracks(){
        List<Talk> result = new ArrayList<Talk>();
        List<TalkTrack> talkTrackList = talkTrackDao.findAll();
        List<Talk> talkList = talkDao.findTalksByTrack(track, talkTrackList);
        for(Talk talk : talkList) {
            if(!talk.getTrackList().isEmpty()) {
                if(tabNumber == 0){
                    boolean isAdded = false;
                    for(TalkTrack talkTrack : talkTrackList){
                        long trackId = talk.getTrackList().get(0);
                        if (talkTrack.getTrackId() == trackId) {
                            if(talkTrack.getIsAdded()){
                                isAdded = true;
                                result.add(talk);
                                break;
                            }
                        }
                    }

                }
                else {
                    result.add(talk);
                }

            }
        }
        return result;
    }

}


