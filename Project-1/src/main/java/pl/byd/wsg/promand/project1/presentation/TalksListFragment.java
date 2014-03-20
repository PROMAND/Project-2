package pl.byd.wsg.promand.project1.presentation;





import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.jsonservice.TalkService;
import pl.byd.wsg.promand.project1.jsonservice.TalkServiceImpl;
import pl.byd.wsg.promand.project1.presentation.adapters.ScheduleAdapter;

public class TalksListFragment extends Fragment {
    private TalkService talkServise = new TalkServiceImpl();
    private Track track;

    public TalksListFragment(Track track) {
        this.track = track;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.talks_list_view, container, false);

        assert view != null;
        ListView listView = (ListView) view.findViewById(R.id.reusableTalksList);
        listView.setAdapter(new ScheduleAdapter(getActivity().getBaseContext(), talkServise.getTalkListByTrack(track)));
        return view;
        }

 }


