package pl.byd.wsg.promand.project1.jsonmock;

import com.google.gson.Gson;

import java.util.List;

import pl.byd.wsg.promand.project1.domain.entity.Track;
import pl.byd.wsg.promand.project1.domain.list.TrackList;

public class TrackJsonServiceImpl implements TrackJsonService{

    private TrackList trackList = new TrackList();

    public TrackJsonServiceImpl() {
        trackList.add(new Track(1, "Track 1"));
        trackList.add(new Track(2, "Track 2"));
        trackList.add(new Track(3, "Track 3"));
        trackList.add(new Track(4, "Track 4"));
        trackList.add(new Track(5, "Track 5"));
    }

    @Override
    public String getTrackList() {
        return new Gson().toJson(trackList);
    }
}
