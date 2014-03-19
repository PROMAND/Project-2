package pl.byd.wsg.promand.project1.presentation;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import pl.byd.wsg.promand.project1.R;
import pl.byd.wsg.promand.project1.domain.entity.Talk;
import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.jsonservice.TalkService;
import pl.byd.wsg.promand.project1.jsonservice.TalkServiceImpl;
import pl.byd.wsg.promand.project1.presentation.adapters.ScheduleAdapter;
import pl.byd.wsg.promand.project1.presentation.model.TalkDescriptionField;

public class TalksListFragment extends Fragment implements AdapterView.OnItemClickListener{
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
        listView.setOnItemClickListener(TalksListFragment.this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        Talk talk = (Talk) adapterView.getItemAtPosition(index);

        Intent intent = new Intent(getActivity(), TalkDescriptionActivity.class);
        intent.putExtra(TalkDescriptionField.TITLE.toString(),talk.getTitle());
        intent.putExtra(TalkDescriptionField.DESCRIPTION.toString(),talk.getDescription());
        intent.putExtra(TalkDescriptionField.START.toString(),talk.getStartTime());
        intent.putExtra(TalkDescriptionField.END.toString(),talk.getEndTime());
        startActivity(intent);
    }
}
